package receiver;

import receiver.exception.RedoException;
import receiver.exception.UndoException;

/** 
 * @author Loic_Beaulieu Valentin_Duron
 * @since 1.0
 * @version 3.0
 * */
public interface MiniEditor {
	
	public void editorCopy();

	public void editorCut();

	public void editorInsert(String parameter);

	public void editorRemove();

	public void editorPaste();

	public void editorSelect(int parameter, int parameter2);

	public MiniBuffer getMiniBuffer();

	public String getBuffer();

	public String getClipboard();

	public String getSelection();

	public int getStart();

	public int getEnd();

	public void undo() throws UndoException;

	public void redo() throws RedoException;

	public void newState();
	
}
