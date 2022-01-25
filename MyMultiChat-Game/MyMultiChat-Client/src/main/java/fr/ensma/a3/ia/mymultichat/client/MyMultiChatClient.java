package fr.ensma.a3.ia.mymultichat.client;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Scanner;

import javax.websocket.DeploymentException;
import javax.websocket.OnMessage;
import javax.websocket.Session;

import org.glassfish.tyrus.client.ClientManager;

import com.google.gson.Gson;

import fr.ensma.a3.ia.mymultichat.api.canal.ChatCanalDesc;
import fr.ensma.a3.ia.mymultichat.api.messages.client.ClientMessage;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;

public class MyMultiChatClient {
	
	private static final String SERVER = "ws://localhost:8080/ws/multichat";
	private static final String REST_URI = "http://localhost:8080/services/multichat/";

	private static Gson gson = new Gson();
	

	public static void main(String[] args) {
		//Appel du service pour recupérer un canal depuis un ID
		Client restclient = ClientBuilder.newClient();
			
	
		List<ChatCanalDesc> rep = restclient.target(REST_URI)
				.request(MediaType.APPLICATION_JSON).get(new GenericType<List<ChatCanalDesc>>() {});
		
//		if (rep == null) {
//			restclient.target(REST_URI).request(MediaType.APPLICATION_JSON).post(new ChatCanalDesc());
//		}
		for (ChatCanalDesc canal : rep) {
			System.out.println(canal.toString());
		}
		
		
		ClientManager client = ClientManager.createClient();
		String blabla;
		
		//Connexion au serveur :
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Choisis ton canal : ");
		String canal = scan.nextLine();
		
		System.out.println("Bienvenu sur MultiChat - " + canal + " !!");
		System.out.println("Donne ton pseudo : ");
		String pseudo = scan.nextLine();
		
		try {
			Session sess = client.connectToServer(MultiChatClientEndPoint.class, 
					URI.create(SERVER+"/"+canal+":"+pseudo));
			sess.getUserProperties().put("Pseudo", pseudo);
			
			
			do {
				
				
				blabla = scan.nextLine();
				
				
				sess.getBasicRemote().sendText(formatMessage(pseudo, blabla + ":" + rep.get(Integer.parseInt(canal)).getNombre()));
				
				
			} while(!blabla.equalsIgnoreCase("quit"));
			
		} catch (DeploymentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			scan.close();
		}	
	}
	
	/*private static String test(String blabla, ChatCanalDesc chat) {
		int nombre = chat.getNombre();
		ClientMessage m = new ClientMessage();
		if (Integer.parseInt(blabla) == nombre) {
			m.setCanalId(0);
			m.setLePseudo("LeServer");
			m.setLeContenu("Gagné !!!");
			return gson.toJson(m);
		} else if (Integer.parseInt(blabla) < nombre) {
			m.setCanalId(0);
			m.setLePseudo("LeServer");
			m.setLeContenu("Trop petit !");
			return gson.toJson(m);
		} else {
			m.setLeContenu("Trop grand !");
			m.setCanalId(0);
			m.setLePseudo("LeServer");
			return gson.toJson(m);
		}
	}*/

	private static String formatMessage(String pseu, String bla) {
		ClientMessage m = new ClientMessage();
        m.setCanalId(0);
        m.setLePseudo(pseu);
        m.setLeContenu(bla);
        return gson.toJson(m);
    }

	
}
