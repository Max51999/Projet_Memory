package fr.ensma.a3.ia.mymultichat.api.canal;

import java.util.Random;

public class ChatCanalDesc {

	private int canalId;
	private String canalName;
	
	private Random rand;
	private int nombre;

	public ChatCanalDesc() {}
	
	public ChatCanalDesc(final int cid, final String name) {
		canalId = cid;
		canalName = name;
		rand = new Random();
		nombre = rand.nextInt(101) + 1;
	}
	
	
	public final int getCanalId() {
		return canalId;
	}
	public final void setCanalId(final int cid) {
		canalId = cid;
	}
	
	public final String getcanalName() {
		return canalName;
	}
	public final void setCanalName(final String name) {
		canalName = name;
	}
	
	public final int getNombre() {
		return nombre;
	}
	
	@Override
	public String toString() {
		return canalId + " : -> " + canalName;
	}	
}
