package fr.ensma.a3.ia.mymultichat.api.canal;

import java.util.Random;

public class ChatCanalDesc {

	private int canalId;
	private String canalName;
	private Random rand = new Random();
	private int value;
	

	public ChatCanalDesc() {}
	
	public ChatCanalDesc(final int cid, final String name) {
		canalId = cid;
		canalName = name;
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

	
	public int getValue() {
		return value;
	}
	
	
	public String compare(int i) {
		if (i>value) {
			return "Trop grand";
		} else if (i<value) {
			return "Trop petit";
		} else {
			return "Gagne";
		}
	} 
	
	@Override
	public String toString() {
		return canalId + " : -> " + canalName;
	}	
}
