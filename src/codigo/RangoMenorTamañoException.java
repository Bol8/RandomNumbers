package codigo;

@SuppressWarnings("serial")
public class RangoMenorTamañoException extends Exception {
	String message;

	public RangoMenorTamañoException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
	
	
	
	
	
	

}
