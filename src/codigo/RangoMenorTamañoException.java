package codigo;

@SuppressWarnings("serial")
public class RangoMenorTama�oException extends Exception {
	String message;

	public RangoMenorTama�oException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
	
	
	
	
	
	

}
