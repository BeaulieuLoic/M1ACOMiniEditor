package receiver;

import receiver.exception.RedoException;
import receiver.exception.UndoException;

/**
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public interface MiniEditor {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */

	public void editorCopy();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */

	public void editorCut();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */

	public void editorInsert(String parameter);

	public void editorRemove();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */

	public void editorPaste();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */

	public void editorSelect(int parameter, int parameter2);

	public MiniBuffer getMiniBuffer();

	public String getBuffer();

	public String getClipboard();

	public String getSelection();

	public int getStart();

	public int getEnd();

	public void startRecording();

	public void stopRecording();

	public void playRecording();

	public void undo() throws UndoException;

	public void redo() throws RedoException;

	public void newState();
}
