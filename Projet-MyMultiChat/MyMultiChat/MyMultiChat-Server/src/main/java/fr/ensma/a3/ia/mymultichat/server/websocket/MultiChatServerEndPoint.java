package fr.ensma.a3.ia.mymultichat.server.websocket;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.EncodeException;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import fr.ensma.a3.ia.mymultichat.api.messages.client.ClientMessage;
import fr.ensma.a3.ia.mymultichat.api.messages.client.ClientMessageDecoder;
import fr.ensma.a3.ia.mymultichat.api.messages.client.ClientMessageEncoder;


@ServerEndpoint(value = "/ws/multichat/{canalandpseudo}", encoders = ClientMessageEncoder.class, decoders = ClientMessageDecoder.class)
public class MultiChatServerEndPoint {

	static Set<Session> chat1 = Collections.synchronizedSet(new HashSet<Session>());
	static Set<Session> chat2 = Collections.synchronizedSet(new HashSet<Session>());
	static Set<Session> chat3 = Collections.synchronizedSet(new HashSet<Session>());

	@OnOpen
	public void onOpen(@PathParam("canalandpseudo") String canalandpseudo, Session sess, EndpointConfig endpointConfig) {
		System.out.println(sess.getId() + " vient de se connecter au canal " + canalandpseudo);
		String[] params = canalandpseudo.split(":");
		sess.getUserProperties().put("pseudo", params[1]);
		sess.getUserProperties().put("canal", params[0]);
		if (params[0].compareTo("1")==0) {
			chat1.add(sess);
		} else if (params[0].compareTo("2")==0) {
			chat2.add(sess);
		} else if (params[0].compareTo("3")==0) {
			chat3.add(sess);
		}
		
	}

	//Réaction du serveur à la réception du serveur
	@OnMessage
	public void onMessage(ClientMessage mess, Session sess) {
		Set<Session> clients = Collections.synchronizedSet(new HashSet<Session>());
		if (((String) sess.getUserProperties().get("canal")).compareTo("1") == 0) {
			clients = chat1;
		} else if (((String) sess.getUserProperties().get("canal")).compareTo("2") == 0) {
			clients = chat2;
		} else if (((String) sess.getUserProperties().get("canal")).compareTo("3") == 0) {
			clients = chat3;
		}
		for (Session client : clients) {
			if (!sess.getId().equals(client.getId())) {
				try {
					client.getBasicRemote().sendObject(mess);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (EncodeException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	@OnClose
	public void onClose(Session sess) {
		System.out.println(sess.getUserProperties().get("pseudo") + " vient de se déconnecter ...");
		Set<Session> clients = Collections.synchronizedSet(new HashSet<Session>());
		if (((String) sess.getUserProperties().get("canal")).compareTo("1") == 0) {
			clients = chat1;
		} else if (((String) sess.getUserProperties().get("canal")).compareTo("2") == 0) {
			clients = chat2;
		} else if (((String) sess.getUserProperties().get("canal")).compareTo("3") == 0) {
			clients = chat3;
		}
		clients.remove(sess);
		ClientMessage mess = new ClientMessage();
		for (Session client : clients) {
			mess.setLePseudo("LeServer");
			mess.setLeContenu((String) sess.getUserProperties().get("pseudo") + " nous a quitté ... (sniff)");
			try {
				client.getBasicRemote().sendObject(mess);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (EncodeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	  @OnError
	  public void onError(Session session, Throwable t) {
	    t.printStackTrace();
	  }
}
