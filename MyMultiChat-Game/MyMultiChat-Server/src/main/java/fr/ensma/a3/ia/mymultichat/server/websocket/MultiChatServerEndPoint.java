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

	static Set<Set<Session>> liste_jeu = Collections.synchronizedSet(new HashSet<Set<Session>>());
	
	static Set<Session> chat1 = Collections.synchronizedSet(new HashSet<Session>());
	static Set<Session> chat2 = Collections.synchronizedSet(new HashSet<Session>());
	static Set<Session> chat3 = Collections.synchronizedSet(new HashSet<Session>());

	static int nb_joueur1 = 0;
	static int nb_joueur2 = 0;
	static int nb_joueur3 = 0;
	
	static int joueur1 = 0;
	static int joueur2 = 0;
	static int joueur3 = 0;

	@OnOpen
	public void onOpen(@PathParam("canalandpseudo") String canalandpseudo, Session sess, EndpointConfig endpointConfig) {
		System.out.println(sess.getId() + " vient de se connecter au canal " + canalandpseudo);
		String[] params = canalandpseudo.split(":");
		sess.getUserProperties().put("pseudo", params[1]);
		sess.getUserProperties().put("canal", params[0]);
		
		
		/*int i = 1;
		for (Set<Session> chat : liste_jeu) {
			
			if (params[0].compareTo("'" + i + "'")==0) {
				chat.add(sess);
			} else {
				liste_jeu.add(Collections.synchronizedSet(new HashSet<Session>()));
			}
			i++;
		}*/
		ClientMessage messinfo = new ClientMessage();
		messinfo.setLePseudo("LeServer");
		messinfo.setLeContenu("Bienvenue dans le jeu de chaud froid !");
		try {
			sess.getBasicRemote().sendObject(messinfo);
		} catch (IOException | EncodeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		messinfo.setLeContenu("L'objectif est de trouver un nombre entre 0 et 100");
		try {
			sess.getBasicRemote().sendObject(messinfo);
		} catch (IOException | EncodeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (params[0].compareTo("1")==0) {
			
			nb_joueur1 ++;
			sess.getUserProperties().put("numero", nb_joueur1);
			if (nb_joueur1 == 1) {
				ClientMessage messattente = new ClientMessage();
				messattente.setLePseudo("LeServer");
				messattente.setLeContenu("Vous êtes le premier joueur, attendons d'autres participants avant de jouer");
				try {
					sess.getBasicRemote().sendObject(messattente);
				} catch (IOException | EncodeException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} else if (nb_joueur1 == 2) {
				ClientMessage messattente = new ClientMessage();
				messattente.setLePseudo("LeServer");
				messattente.setLeContenu("Vous êtes le deuxième joueur, attendez votre tour pour jouer");
				try {
					sess.getBasicRemote().sendObject(messattente);
				} catch (IOException | EncodeException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for (Session client : chat1) {
					ClientMessage messtour = new ClientMessage();
					messtour.setLePseudo("LeServer");
					messtour.setLeContenu("A ton tour !");
					joueur1 ++;
					try {
						client.getBasicRemote().sendObject(messtour);
					} catch (IOException | EncodeException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} else {
				ClientMessage messattente = new ClientMessage();
				messattente.setLePseudo("LeServer");
				messattente.setLeContenu("Vous rejoignez une partie en cours, attendez votre tour pour jouer");
				try {
					sess.getBasicRemote().sendObject(messattente);
				} catch (IOException | EncodeException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	
			}
			chat1.add(sess);
		} else if (params[0].compareTo("2")==0) {
			
			nb_joueur2 ++;
			sess.getUserProperties().put("numero", nb_joueur2);
			if (nb_joueur2 == 1) {
				ClientMessage messattente = new ClientMessage();
				messattente.setLePseudo("LeServer");
				messattente.setLeContenu("Vous êtes le premier joueur, attendons d'autres participants avant de jouer");
				try {
					sess.getBasicRemote().sendObject(messattente);
				} catch (IOException | EncodeException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} else if (nb_joueur2 == 2) {
				ClientMessage messattente = new ClientMessage();
				messattente.setLePseudo("LeServer");
				messattente.setLeContenu("Vous êtes le deuxième joueur, attendez votre tour pour jouer");
				try {
					sess.getBasicRemote().sendObject(messattente);
				} catch (IOException | EncodeException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for (Session client : chat2) {
					ClientMessage messtour = new ClientMessage();
					messtour.setLePseudo("LeServer");
					messtour.setLeContenu("A ton tour !");
					joueur2 ++;
					try {
						client.getBasicRemote().sendObject(messtour);
					} catch (IOException | EncodeException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			} else {
				ClientMessage messattente = new ClientMessage();
				messattente.setLePseudo("LeServer");
				messattente.setLeContenu("Vous rejoignez une partie en cours, attendez votre tour pour jouer");
				try {
					sess.getBasicRemote().sendObject(messattente);
				} catch (IOException | EncodeException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			chat2.add(sess);
		} else if (params[0].compareTo("3")==0) {
			
			nb_joueur3 ++;
			sess.getUserProperties().put("numero", nb_joueur3);
			if (nb_joueur3 == 1) {
				ClientMessage messattente = new ClientMessage();
				messattente.setLePseudo("LeServer");
				messattente.setLeContenu("Vous êtes le premier joueur, attendons d'autres participants avant de jouer");
				try {
					sess.getBasicRemote().sendObject(messattente);
				} catch (IOException | EncodeException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (nb_joueur3 == 2) {
				ClientMessage messattente = new ClientMessage();
				messattente.setLePseudo("LeServer");
				messattente.setLeContenu("Vous êtes le deuxième joueur, attendez votre tour pour jouer");
				try {
					sess.getBasicRemote().sendObject(messattente);
				} catch (IOException | EncodeException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for (Session client : chat3) {
					ClientMessage messtour = new ClientMessage();
					messtour.setLePseudo("LeServer");
					messtour.setLeContenu("A ton tour !");
					joueur3 ++;
					try {
						client.getBasicRemote().sendObject(messtour);
					} catch (IOException | EncodeException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			} else {
				ClientMessage messattente = new ClientMessage();
				messattente.setLePseudo("LeServer");
				messattente.setLeContenu("Vous rejoignez une partie en cours, attendez votre tour pour jouer");
				try {
					sess.getBasicRemote().sendObject(messattente);
				} catch (IOException | EncodeException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					sess.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			chat3.add(sess);
		}		
	}

	//Réaction du serveur à la réception du serveur
	@OnMessage
	public void onMessage(ClientMessage mess, Session sess) {
		Set<Session> clients = Collections.synchronizedSet(new HashSet<Session>());
		int joueur = 0;
		int nb_joueur = 0;
        if (((String) sess.getUserProperties().get("canal")).compareTo("1") == 0) {
                clients = chat1;
                joueur = joueur1;
                nb_joueur = nb_joueur1;
        } else if (((String) sess.getUserProperties().get("canal")).compareTo("2") == 0) {
                clients = chat2;
                joueur = joueur2;
                nb_joueur = nb_joueur2;
        } else if (((String) sess.getUserProperties().get("canal")).compareTo("3") == 0) {
                clients = chat3;
                joueur = joueur3;
                nb_joueur = nb_joueur3;
        }
		
        
        String[] params = mess.getLeContenu().split(":");
        
		/*Set<Session> clients = Collections.synchronizedSet(new HashSet<Session>());
		int i = 1;
		for (Set<Session> chat : liste_jeu) {
			
			if (((String) sess.getUserProperties().get("canal")).compareTo("'" + i + "'")==0) {
				clients = chat;
			} 
			i++;
		}*/
        
		if (((int) sess.getUserProperties().get("numero")) == joueur) {
			if (joueur == nb_joueur) {
				joueur = 1;
			} else {
				joueur ++;
			}
			
			
			
			for (Session client : clients) {
				
				
				if (!sess.getId().equals(client.getId())) {
					try {
						ClientMessage mess2 = new ClientMessage();
						mess2.setLePseudo((String) sess.getUserProperties().get("pseudo"));
						mess2.setLeContenu(params[0]);
						client.getBasicRemote().sendObject(mess2);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (EncodeException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				if (Integer.parseInt(params[1]) == Integer.parseInt(params[0])) {
					try {
						ClientMessage mess2 = new ClientMessage();
						mess2.setLePseudo("LeServer");
						mess2.setLeContenu((String) sess.getUserProperties().get("pseudo") + " a gagné ... bravo !");
						client.getBasicRemote().sendObject(mess2);
					} catch (IOException | EncodeException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else if (Integer.parseInt(params[1]) > Integer.parseInt(params[0])) {
					try {
						ClientMessage mess2 = new ClientMessage();
						mess2.setLePseudo("LeServer");
						mess2.setLeContenu("Trop petit !");
						client.getBasicRemote().sendObject(mess2);
					} catch (IOException | EncodeException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else if (Integer.parseInt(params[1]) < Integer.parseInt(params[0])) {
					try {
						ClientMessage mess2 = new ClientMessage();
						mess2.setLePseudo("LeServer");
						mess2.setLeContenu("Trop grand !");
						client.getBasicRemote().sendObject(mess2);
					} catch (IOException | EncodeException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} 
				
				
				
				
				
				if (((int) client.getUserProperties().get("numero")) == joueur) {
					ClientMessage messtour = new ClientMessage();
					messtour.setLePseudo("LeServer");
					messtour.setLeContenu("A ton tour !");
					try {
						client.getBasicRemote().sendObject(messtour);
					} catch (IOException | EncodeException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}		
					
			}
			if (((String) sess.getUserProperties().get("canal")).compareTo("1") == 0) {
                joueur1 = joueur;
			} else if (((String) sess.getUserProperties().get("canal")).compareTo("2") == 0) {
                joueur2 = joueur;
			} else if (((String) sess.getUserProperties().get("canal")).compareTo("3") == 0) {
                joueur3 = joueur;
			}
			
			
			if (Integer.parseInt(params[1]) == Integer.parseInt(params[0])) {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for (Session ses : clients) {
					
					try {
						ses.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
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
