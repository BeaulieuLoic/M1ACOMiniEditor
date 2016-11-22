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

}
