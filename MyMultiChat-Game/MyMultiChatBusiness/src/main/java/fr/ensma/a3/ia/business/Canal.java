package fr.ensma.a3.ia.business;

import java.util.Random;

public class Canal {

	private Random rand = new Random();
	private int value;
	
	public Canal() {
		value = 1 + rand.nextInt(101);
	}
	
	public int getValue() {
		return value;
	}
	
	public void compare(int i) {
		if (i>value) {
			System.out.println("Trop grand");
		} else if (i<value) {
			System.out.println("Trop petit");
		} else {
			System.out.println("Gagne");
		}
	} 
}
