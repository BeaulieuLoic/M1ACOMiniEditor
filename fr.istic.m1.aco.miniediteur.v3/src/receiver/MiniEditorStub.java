package receiver;

import receiver.exception.*;

/** 
 * Implementation of MiniEditor
 * 
 * @author Loic_Beaulieu Valentin_Duron
 * @since 1.0
 * @version 3.0
 * */
public class MiniEditorStub implements MiniEditor {

	@Override
	public String toString() {
		return "MiniEditorStub: \nselector=" + selector + "\nclipboard=" + clipboard + "\nbuffer=\n" + buffer + "\n";
	}

	private MiniBuffer buffer;

	private Selector selector;

	private MiniClipboard clipboard;

	private MiniState actualState;

	public MiniEditorStub() {
		super();
		buffer = new MiniBuffer();
		clipboard = new MiniClipboard();
		selector = new Selector();
		actualState = new MiniState(buffer, selector);
	}


	/**
	 * Implementation of editorCopy()
	 * 
	 * */
	@Override
	public void editorCopy() {
		if (selector.getStart() != selector.getEnd()) {
			clipboard.setClip(buffer.copy(selector.getStart(), selector.getEnd()));
		}
	}

	/**
	 * Implementation of editorCut()
	 * 
	 * */
	@Override
	public void editorCut() {
		if (selector.getStart() != selector.getEnd()) {
			clipboard.setClip(buffer.copy(selector.getStart(), selector.getEnd()));
			buffer.delete(selector.getStart(), selector.getEnd());
			editorSelect(selector.getStart(), selector.getStart());
		}
	}

	/**
	 * Implementation of editorPaste()
	 * 
	 * @see MiniEditor#editorPaste()
	 * */
	@Override
	public void editorPaste() {

		editorInsert(clipboard.getClip());

	}

	/**
	 * Implementation of editorInsert(String str)
	 * 
	 * */
	@Override
	public void editorInsert(String str) {
		int lengthStr = str.length();
		if (selector.getStart() == selector.getEnd()) {
			buffer.insert(selector.getStart(), str);
			editorSelect(selector.getStart() + lengthStr, selector.getEnd() + lengthStr);
		} else {
			buffer.replace(selector.getStart(), selector.getEnd(), str);
			editorSelect(selector.getStart() + lengthStr, selector.getStart() + lengthStr);
		}
	}

	
	/**
	 * Implementation of editorRemove()
	 * 
	 * */
	@Override
	public void editorRemove() {

		if (selector.getStart() == selector.getEnd()) {
			buffer.delete(selector.getStart() - 1, selector.getEnd());
			editorSelect(selector.getStart() - 1, selector.getStart() - 1);
		} else {
			buffer.delete(selector.getStart(), selector.getEnd());
			editorSelect(selector.getStart(), selector.getStart());
		}
	}
	
	/**
	 * Implementation of editorSelect(int start, int end)
	 * 
	 * */
	@Override
	public void editorSelect(int start, int end) {
		int startModif = start, endModif = end, tmp;
		if (startModif > endModif) {
			tmp = endModif;
			endModif = startModif;
			startModif = tmp;
		}

		if (startModif > buffer.getSize()) {
			startModif = buffer.getSize();
		}

		if (endModif > buffer.getSize()) {
			endModif = buffer.getSize();
		}

		selector.setStart(startModif);
		selector.setEnd(endModif);
	}

	/**
	 * Use only for test
	 * 
	 * @return actual MiniBuffer
	 * */
	public MiniBuffer getMiniBuffer() {
		return buffer;
	}

	/**
	 * Implementation of editorSelect(int start, int end)
	 * 
	 * */
	@Override
	public String getBuffer() {
		return buffer.getBuffer().toString();
	}

	/**
	 * Implementation of getClipboard()
	 * 
	 * */
	@Override
	public String getClipboard() {
		return clipboard.getClip();
	}

	/**
	 * Implementation of getSelection()
	 * 
	 * */
	@Override
	public String getSelection() {
		return buffer.getBuffer().toString().substring(selector.getStart(), selector.getEnd());
	}


	/**
	 * Implementation of getSelection()
	 * 
	 * */
	@Override
	public int getStart() {
		return selector.getStart();
	}
	
	
	/**
	 * Implementation of getSelection()
	 * 
	 * */
	@Override
	public int getEnd() {
		return selector.getEnd();
	}

	/**
	 * update buffer and selector with the actual state
	 * 
	 * 
	 * */
	private void update() {
		buffer = actualState.getBuf();
		selector = actualState.getSel();
	}

	/**
	 * use only for test
	 * 
	 * */
	protected MiniState getState() {
		return this.actualState;
	}

	/**
	 * Implementation of undo()
	 * 
	 * */
	@Override
	public void undo() throws UndoException {
		if (actualState.getPre() == null) {
			throw new UndoException("No previous state");
		} else {
			actualState = actualState.getPre();
			update();
		}
	}

	/**
	 * Implementation of redo()
	 * 
	 * */
	@Override
	public void redo() throws RedoException {
		if (actualState.getNext() == null) {
			throw new RedoException("No next state");
		} else {
			actualState = actualState.getNext();
			update();
		}

	}

	/**
	 * Implementation of newState()
	 * 
	 * */
	@Override
	public void newState() {
		actualState.addNext(buffer, selector);
		actualState = actualState.getNext();
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MiniEditorStub other = (MiniEditorStub) obj;
		if (actualState == null) {
			if (other.actualState != null)
				return false;
		} else if (!actualState.equals(other.actualState))
			return false;
		if (buffer == null) {
			if (other.buffer != null)
				return false;
		} else if (!buffer.equals(other.buffer))
			return false;
		if (clipboard == null) {
			if (other.clipboard != null)
				return false;
		} else if (!clipboard.equals(other.clipboard))
			return false;
		if (selector == null) {
			if (other.selector != null)
				return false;
		} else if (!selector.equals(other.selector))
			return false;
		return true;
	}

}
