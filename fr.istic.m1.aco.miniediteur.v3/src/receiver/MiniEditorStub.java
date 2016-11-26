package receiver;

import receiver.exception.*;
import recorde.Recorder;

/**
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */

public class MiniEditorStub implements MiniEditor {

	@Override
	public String toString() {
		return "MiniEditorStub: \nselector=" + selector + "\nclipboard="
				+ clipboard + "\nbuffer=\n" + buffer + "\n";
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */

	private MiniBuffer buffer;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */

	private Selector selector;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */

	private MiniClipboard clipboard;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */

	private Recorder recorder;

	private MiniState actualState;

	public MiniEditorStub(Recorder r) {
		super();
		buffer = new MiniBuffer();
		clipboard = new MiniClipboard();
		selector = new Selector();
		recorder = r;
		actualState = new MiniState(buffer, selector);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */

	@Override
	public void editorCopy() {
		if (selector.getStart() != selector.getEnd()) {
			clipboard.setClip(buffer.copy(selector.getStart(),
					selector.getEnd()));
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */

	@Override
	public void editorCut() {
		if (selector.getStart() != selector.getEnd()) {
			clipboard.setClip(buffer.copy(selector.getStart(),
					selector.getEnd()));
			buffer.delete(selector.getStart(), selector.getEnd());
			editorSelect(selector.getStart(), selector.getStart());
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */

	@Override
	public void editorPaste() {

		editorInsert(clipboard.getClip());

	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */

	@Override
	public void editorInsert(String str) {
		int lengthStr = str.length();
		if (selector.getStart() == selector.getEnd()) {
			buffer.insert(selector.getStart(), str);
			editorSelect(selector.getStart() + lengthStr, selector.getEnd()
					+ lengthStr);
		} else {
			buffer.replace(selector.getStart(), selector.getEnd(), str);
			editorSelect(selector.getStart() + lengthStr, selector.getStart()
					+ lengthStr);
		}
	}

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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */

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

	public MiniBuffer getMiniBuffer() {
		return buffer;
	}

	@Override
	public String getBuffer() {
		return buffer.getBuffer().toString();
	}

	@Override
	public String getClipboard() {
		return clipboard.getClip();
	}

	@Override
	public String getSelection() {

		return buffer.getBuffer().toString()
				.substring(selector.getStart(), selector.getEnd());
	}

	@Override
	public int getStart() {
		return selector.getStart();
	}

	@Override
	public int getEnd() {
		return selector.getEnd();
	}

	@Override
	public void startRecording() {
		recorder.startRecord();
	}

	@Override
	public void stopRecording() {
		recorder.stopRecord();
	}

	@Override
	public void playRecording() {
		recorder.playRecord();
	}

	private void update() {
		buffer = actualState.getBuf();
		selector = actualState.getSel();
	}

	protected MiniState getState(){
		return this.actualState;
	}
	
	public void undo() throws UndoException {
		if (actualState.getPre() == null) {
			throw new UndoException("No previous state");
		} else {
			actualState = actualState.getPre();
			update();
		}
	}

	public void redo() throws RedoException {
		if (actualState.getNext() == null) {
			throw new RedoException("No next state");
		} else {
			actualState = actualState.getNext();
			update();
		}

	}

	public void newState() {
		actualState.addNext(buffer, selector);
		actualState = actualState.getNext();
	}

	public boolean equalsSansEtat(MiniEditorStub edit){
		return buffer.equals(edit.buffer) 
				&& clipboard.equals(edit.clipboard)
				&& recorder.equals(edit.recorder)
				&& selector.equals(edit.selector);
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
		if (recorder == null) {
			if (other.recorder != null)
				return false;
		} else if (!recorder.equals(other.recorder))
			return false;
		if (selector == null) {
			if (other.selector != null)
				return false;
		} else if (!selector.equals(other.selector))
			return false;
		return true;
	}

}
