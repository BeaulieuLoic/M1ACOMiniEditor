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

	public void editorInsert(String str);

	public void editorRemove();

	public void editorPaste();

	public void editorSelect(int start, int end);

	public String getBuffer();

	public String getClipboard();

	public String getSelection();

	public int getStart();

	public int getEnd();

	public void undo() throws UndoException;

	public void redo() throws RedoException;

	public void newState();
	
}
