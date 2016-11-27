package memento;
/** 
 * @author Loic_Beaulieu Valentin_Duron
 * 
 * */
public class MementoState {

	private int selStart;
	private int selEnd;
	private String buf;

	public MementoState(int s, int e, String b) {
		selStart = s;
		selEnd = e;
		buf = b;
	}

	public int getSelStart() {
		return selStart;
	}

	public int getSelEnd() {
		return selEnd;
	}

	public String getBuf() {
		return buf;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MementoState other = (MementoState) obj;
		if (buf == null) {
			if (other.buf != null)
				return false;
		} else if (!buf.equals(other.buf))
			return false;
		if (selEnd != other.selEnd)
			return false;
		if (selStart != other.selStart)
			return false;
		return true;
	}
}
