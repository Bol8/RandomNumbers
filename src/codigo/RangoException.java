package codigo;

@SuppressWarnings("serial")
public class RangoException extends Exception {
	String message;

	public RangoException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
	
	
	
	

}
