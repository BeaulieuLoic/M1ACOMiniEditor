package receiver;

public class MiniState {

	private MiniState pre;
	private MiniState next;

	private MiniBuffer buf;
	private Selector sel;

	public MiniState(MiniBuffer buf, Selector sel) {
		super();

		this.buf = new MiniBuffer(buf.getBuffer());
		this.sel = new Selector(sel.getStart(),sel.getEnd());
	}

	public void addNext(MiniBuffer buf, Selector sel) {
		next = new MiniState(buf, sel);
		next.pre = this;
	}

	public MiniState getPre() {
		return pre;
	}

	public MiniState getNext() {
		return next;
	}

	public MiniBuffer getBuf() {
		return buf;
	}

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
		} else if (!next.equals(other.next))
			return false;
		if (pre == null) {
			if (other.pre != null)
				return false;
		} else if (!pre.equals(other.pre))
			return false;
		if (sel == null) {
			if (other.sel != null)
				return false;
		} else if (!sel.equals(other.sel))
			return false;
		return true;
	}

}
