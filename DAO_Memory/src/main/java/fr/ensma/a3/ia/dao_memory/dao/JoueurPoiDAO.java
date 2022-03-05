package fr.ensma.a3.ia.dao_memory.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import fr.ensma.a3.ia.dao_memory.dao.entity.JoueurEntity;

public class JoueurPoiDAO extends AbstractPoiDAO<JoueurEntity> {

	private static Logger LOGGER = Logger.getLogger(JoueurPoiDAO.class.getName());
	
	@Override
	public Optional<JoueurEntity> getById(int id) {
		XSSFWorkbook bdd = openBase();
		Sheet tablejoueur = bdd.getSheet("Joueurs");
		Iterator<Row> iterator = tablejoueur.iterator();
		iterator.next();
		boolean trouve = false;
		JoueurEntity joueur = null;
		while (iterator.hasNext() && !trouve) {
			Row ligne = iterator.next();
			joueur = new JoueurEntity();
			if (id == (int)ligne.getCell(0).getNumericCellValue()) {
				joueur.setIdJoueur((int)ligne.getCell(0).getNumericCellValue());
				joueur.setNomJoueur(ligne.getCell(1).getStringCellValue());
				joueur.setPrenomJoueur(ligne.getCell(2).getStringCellValue());
				joueur.setMailJoueur((String)ligne.getCell(3).getStringCellValue());
				joueur.setPseudo((String)ligne.getCell(4).getStringCellValue());
				trouve = true;
			}
		}
		if (trouve) {
			closeBase(bdd);
			return Optional.of(joueur);
		}
		closeBase(bdd);
		return Optional.empty();	
	}

	@Override
	public Optional<JoueurEntity> getByValue(JoueurEntity elem) {
		List<JoueurEntity> listtemp = getAll();
		for (JoueurEntity joueur : listtemp) {
			if (joueur.equals(elem)) {
				return Optional.of(joueur);
			}
		}
		return Optional.empty();
	}

	@Override
	public List<JoueurEntity> getAll() {
		XSSFWorkbook bdd = openBase();
		Sheet tablejoueur = bdd.getSheet("Joueurs");
		ArrayList<JoueurEntity> listejoueur = new ArrayList<JoueurEntity>();
		Iterator<Row> iterator = tablejoueur.iterator();
		iterator.next();
		while (iterator.hasNext()) {
			Row ligne = iterator.next();
			JoueurEntity joueur = new JoueurEntity();
			Iterator<Cell> cellIterator = ligne.iterator();
			Cell cellule = cellIterator.next();
			joueur.setIdJoueur((int)cellule.getNumericCellValue());
			joueur.setNomJoueur(ligne.getCell(1).getStringCellValue());
			joueur.setPrenomJoueur(ligne.getCell(2).getStringCellValue());
			joueur.setMailJoueur((String)ligne.getCell(3).getStringCellValue());
			joueur.setPseudo((String)ligne.getCell(4).getStringCellValue());
			listejoueur.add(joueur);
		}
		closeBase(bdd);
		return listejoueur;
	}

	@Override
	public void create(JoueurEntity elem) {
		if (getByValue(elem).isEmpty()) {
			XSSFWorkbook bdd = openBase();
			Sheet tablejoueur = bdd.getSheet("Joueurs");
			int lrow = tablejoueur.getLastRowNum();
			int lid = (int) tablejoueur.getRow(lrow).getCell(0).getNumericCellValue();
			elem.setIdJoueur(lid + 1);
			Row ligne = tablejoueur.createRow(lrow + 1);
			Cell cell = ligne.createCell(0);
			cell.setCellValue(elem.getIdJoueur());
			cell = ligne.createCell(1);
			cell.setCellValue(elem.getNomJoueur());
			cell = ligne.createCell(2);
			cell.setCellValue(elem.getPrenomJoueur());
			cell = ligne.createCell(3);
			cell.setCellValue(elem.getMailJoueur());
			cell = ligne.createCell(4);
			cell.setCellValue(elem.getPseudo());
			writeBase(bdd);
			closeBase(bdd);
		} else {
			//TODO : Prévoir une exception ...
			LOGGER.log(Level.INFO,"Element Deja dans la base ...");
		}
	}

	@Override
	public void update(JoueurEntity elem) {
		XSSFWorkbook bdd = openBase();
		Sheet tablejoueur = bdd.getSheet("Joueurs");
		Iterator<Row> iterator = tablejoueur.iterator();
		iterator.next();
		boolean trouve = false;
		while (iterator.hasNext() && !trouve) {
			Row ligne = iterator.next();
			if (elem.getIdJoueur() == (int) ligne.getCell(0).getNumericCellValue()) {
				trouve = true;
				ligne.getCell(1).setCellValue(elem.getNomJoueur());
				ligne.getCell(2).setCellValue(elem.getPrenomJoueur());
				ligne.getCell(3).setCellValue(elem.getMailJoueur());
				ligne.getCell(4).setCellValue(elem.getPseudo());
				writeBase(bdd);
			}
		}
		if (!trouve) {
			//TODO : Prévoir une exception ...
			LOGGER.log(Level.INFO,"Element absent de la base ...");
		}
		closeBase(bdd);
	}

	@Override
	public void delete(JoueurEntity elem) {
		XSSFWorkbook bdd = openBase();
		Sheet tablejoueur = bdd.getSheet("Joueurs");
		Iterator<Row> iterator = tablejoueur.iterator();
		iterator.next();
		boolean trouve = false;
		while (iterator.hasNext() && !trouve) {
			Row ligne = iterator.next();
			if (elem.getIdJoueur() == (int) ligne.getCell(0).getNumericCellValue()) {
				trouve = true;
				removeRow(tablejoueur, ligne.getRowNum());
				writeBase(bdd);
			}
		}
		if (!trouve) {
			//TODO : Prévoir une exception ...
			LOGGER.log(Level.INFO,"Element absent de la base ...");
		}
		closeBase(bdd);
	}

}
