package receiver;

/** 
 * @author Loic_Beaulieu Valentin_Duron
 * 
 * */
import java.lang.StringBuffer;


/** 
 * @author Loic_Beaulieu Valentin_Duron
 * @since 1.0
 * @version 1.0
 * */
public class MiniBuffer {

	private StringBuffer buffer;

	public MiniBuffer() {
		super();
		buffer = new StringBuffer();
	}

	public MiniBuffer(StringBuffer buf){
		super();
		buffer=new StringBuffer(buf.toString());
	}
	
	/**
	 * 
	 * 
	 * @param start position to start for remove text
	 * @param end position to end for remove text
	 * 
	 * 
	 * */
	public void delete(int start, int end) {
		buffer.delete(start, end);
	}

	
	/**
	 * 
	 * @param start position to start for copy text
	 * @param end position to end for copy text
	 * 
	 * @return string to copy
	 * 
	 * */
	public String copy(int start, int end) {
		return buffer.substring(start, end);
	}

	
	/**
	 * 
	 * @param cursor position of the insert text
	 * @param str String to insert
	 * 
	 * */
	public void insert(int cursor, String str) {
		buffer.insert(cursor, str);
	}
	
	
	/**
	 * 
	 * @param start position to start for copy text
	 * @param end position to end for copy text
	 * @param str String to insert
	 * 
	 * */
	public void replace(int start, int end, String str) {
		buffer.replace(start, end, str);
	}
	
	
	/**
	 * 
	 * @return the StringBuffer who contain text
	 * 
	 * */
	public StringBuffer getBuffer() {
		return buffer;
	}
	
	
	/**
	 * 
	 * @return the size of the buffer
	 */
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
