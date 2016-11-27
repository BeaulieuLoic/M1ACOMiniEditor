package receiver.exception;

/** 
 * @author Loic_Beaulieu Valentin_Duron
 * @since 3.0
 * @version 3.0
 * */
public class UndoException extends Exception {

	public UndoException() {
		super();
	}

	public UndoException(String message) {
		super(message);
	}

	public UndoException(String message, Throwable cause) {
		super(message, cause);
	}

	public UndoException(Throwable cause) {
		super(cause);
	}
}
