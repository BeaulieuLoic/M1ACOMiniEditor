package receiver;

import Annulator.Annulator;
import Annulator.exception.RedoException;
import Annulator.exception.UndoException;
import record.Recorder;

/**
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */

public class MiniEditorStub implements MiniEditor {
	@Override
	public String toString() {
		return "MiniEditorStub: \nselector=" + selector + "\nclipboard=" + clipboard + "\nbuffer=" + buffer + "\nannulator=" + annulator + "\n";
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
	
	private Annulator annulator;

	public MiniEditorStub(Recorder r,Annulator a) {
		super();
		buffer = new MiniBuffer();
		clipboard = new MiniClipboard();
		selector = new Selector();
		recorder = r;
		annulator = a;
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
			clipboard.setClip(buffer.copy(selector.getStart(), selector.getEnd()));
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
			clipboard.setClip(buffer.copy(selector.getStart(), selector.getEnd()));
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
			editorSelect(selector.getStart() + lengthStr, selector.getEnd() + lengthStr);
		} else {
			buffer.replace(selector.getStart(), selector.getEnd(), str);
			editorSelect(selector.getStart() + lengthStr, selector.getStart() + lengthStr);
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
		if (start < 0) {
			startModif= 0;
		}
		if (end < 0) {
			endModif= 0;
		}		
		
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

		return buffer.getBuffer().toString().substring(selector.getStart(), selector.getEnd());
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
	
	@Override
	public void undo() throws UndoException {
		this.reset();
		annulator.undo();
	}
	
	@Override
	public void redo() throws RedoException {
		annulator.redo();
	}

	@Override
	public void reset() {
		buffer = new MiniBuffer();
		selector = new Selector();
	}

}
