package codigo;

@SuppressWarnings("serial")
public class Tama�oException extends Exception {
	String message;

	public Tama�oException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
	
	

}
