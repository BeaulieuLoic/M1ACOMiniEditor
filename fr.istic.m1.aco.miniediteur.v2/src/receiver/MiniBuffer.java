package receiver;

import java.lang.StringBuffer;

/**
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */

public class MiniBuffer {

	private StringBuffer buffer;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public MiniBuffer() {
		super();
		buffer = new StringBuffer();
	}

	public void delete(int start, int end) {
		buffer.delete(start, end);
	}

	public String copy(int start, int end) {
		return buffer.substring(start, end);
	}

	public void insert(int cursor, String str) {
		buffer.insert(cursor, str);
	}

	public void replace(int start, int end, String str) {
		buffer.replace(start, end, str);
	}

	public StringBuffer getBuffer() {
		return buffer;
	}

	public int getSize() {
		return buffer.length();
	}

	@Override
	public String toString() {
		return "\"" + buffer.toString() + "\"";
	}

}
