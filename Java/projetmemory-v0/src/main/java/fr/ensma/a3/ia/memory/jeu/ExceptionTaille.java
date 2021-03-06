package fr.ensma.a3.ia.memory.jeu;

/**
 * 
 * @author vitrym
 *
 */
public class ExceptionTaille extends Exception {

private String monMessage;
	
	public ExceptionTaille() {}
	
	public ExceptionTaille(final String msg) {
		monMessage = msg;
	}
	
	public final String getMonMessage() {
		return monMessage;
	}
	
	@Override
	public String getMessage() {
		return monMessage + " : " + super.getMessage();
	}
	
	private static final long serialVersionUID = 1L;
}
