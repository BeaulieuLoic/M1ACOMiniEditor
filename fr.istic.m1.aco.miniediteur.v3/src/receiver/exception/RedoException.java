package receiver.exception;

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
