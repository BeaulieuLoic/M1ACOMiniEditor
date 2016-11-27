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
	
	public int getSize(){
		return buffer.length();
	}

	@Override
	public String toString() {
		return "\""+buffer.toString()+"\"";
	}	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MiniBuffer other = (MiniBuffer) obj;
		if (buffer == null) {
			if (other.buffer != null)
				return false;
		} else if (!buffer.toString().equals(other.buffer.toString()))// utilise toString car equals pas implémenté dans StringBuffer
			return false;
		return true;
	}
}
