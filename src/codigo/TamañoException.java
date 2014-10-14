package codigo;

@SuppressWarnings("serial")
public class TamañoException extends Exception {
	String message;

	public TamañoException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
	
	

}
