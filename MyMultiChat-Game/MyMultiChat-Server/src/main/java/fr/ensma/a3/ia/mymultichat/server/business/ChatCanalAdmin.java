package fr.ensma.a3.ia.mymultichat.server.business;

import java.util.ArrayList;
import java.util.List;

import fr.ensma.a3.ia.mymultichat.api.canal.ChatCanalDesc;

public class ChatCanalAdmin {

	private static List<ChatCanalDesc> liste = new ArrayList<ChatCanalDesc>();
	
	private static int numero_canal = 1;
	
	private static ChatCanalDesc canal1 = new ChatCanalDesc(1, "Canal de jeu 1 ... ");
	private static ChatCanalDesc canal2 = new ChatCanalDesc(2, "Canal de jeu 2 ...");
	private static ChatCanalDesc canal3 = new ChatCanalDesc(3,"Canal de jeu 3 ...");
	
	public static List<ChatCanalDesc> getAllCanal() {
		List<ChatCanalDesc> liste_canaux = new ArrayList<ChatCanalDesc>();
		liste_canaux.add(canal1);
		liste_canaux.add(canal2);
		liste_canaux.add(canal3);
		return liste_canaux;
	}
	
	public static void createCanal(ChatCanalDesc chat) {
		liste.add(chat);
		numero_canal ++;
	}
	
	
}
