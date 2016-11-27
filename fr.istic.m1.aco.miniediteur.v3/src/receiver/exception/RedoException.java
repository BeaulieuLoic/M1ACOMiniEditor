package receiver.exception;

/** 
 * @author Loic_Beaulieu Valentin_Duron
 * @since 3.0
 * @version 3.0
 * */
public class RedoException extends Exception {

	public RedoException() {
		super();
	}

	public RedoException(String message) {
		super(message);
	}

	public RedoException(String message, Throwable cause) {
		super(message, cause);
	}

	public RedoException(Throwable cause) {
		super(cause);
	}
}
