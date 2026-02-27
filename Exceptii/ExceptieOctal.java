package A2026_J15.Exceptii;

public class ExceptieOctal extends Exception{

	private static final long serialVersionUID = 1L;
	
	public ExceptieOctal() {
		super("Nr nu este octal(0-7)");
	}

}
