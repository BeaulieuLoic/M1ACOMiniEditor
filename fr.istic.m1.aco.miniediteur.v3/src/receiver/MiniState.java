package receiver;

/** 
 * MiniState of the MiniEditorStub. Class add for V3
 * 
 * 
 * @author Loic_Beaulieu Valentin_Duron
 * @since 3.0
 * @version 3.0
 * */
public class MiniState {

	
	/**
	 * 
	 * previous state. Can be null if this is the first state
	 * 
	 * */
	private MiniState pre;
	
	/**
	 * 
	 * next state, Can be null if this is the last state
	 * 
	 * */
	private MiniState next;

	
	/**
	 * 
	 * MiniBuffer of the actual state
	 * 
	 * */
	private MiniBuffer buf;
	
	/**
	 * 
	 * Selector of the actual state
	 * 
	 * */
	private Selector sel;

	public MiniState(MiniBuffer buf, Selector sel) {
		super();

		this.buf = new MiniBuffer(buf.getBuffer());
		this.sel = new Selector(sel.getStart(),sel.getEnd());
	}
	
	
	/**
	 * 
	 * add new next state
	 * 
	 * @param buf MiniBuffer of the next state
	 * @param sel Selector of the next state
	 * 
	 * */
	public void addNext(MiniBuffer buf, Selector sel) {
		next = new MiniState(buf, sel);
		next.pre = this;
	}

	
	/**
	 * 
	 * return the previous state
	 * 
	 * @return the previous state
	 * 
	 * */
	public MiniState getPre() {
		return pre;
	}

	/**
	 * 
	 * return the next state
	 * 
	 * @return next state
	 * 
	 * */
	public MiniState getNext() {
		return next;
	}

	/**
	 * 
	 * return the MiniBuffer of the actual state
	 * 
	 * @return the MiniBuffer of the actual state
	 * 
	 * */
	public MiniBuffer getBuf() {
		return buf;
	}

	/**
	 * 
	 * return the Selector of the actual state
	 * 
	 * @return the Selector of the actual state
	 * 
	 * */
	public Selector getSel() {
		return sel;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MiniState other = (MiniState) obj;
		if (buf == null) {
			if (other.buf != null)
				return false;
		} else if (!buf.equals(other.buf))
			return false;
		if (next == null) {
			if (other.next != null)
				return false;
		} else if (!next.equals(other.next)) // A changer sinon appel en boucle
			return false;
		if (pre == null) {
			if (other.pre != null)
				return false;
		} else if (!pre.equals(other.pre))// A changer sinon appel en boucle
			return false;
		if (sel == null) {
			if (other.sel != null)
				return false;
		} else if (!sel.equals(other.sel))
			return false;
		return true;
	}

}
