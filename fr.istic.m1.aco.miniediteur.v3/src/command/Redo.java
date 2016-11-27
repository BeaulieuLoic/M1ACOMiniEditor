package command;

import receiver.MiniEditor;
import receiver.exception.RedoException;
/** 
 * @author Loic_Beaulieu Valentin_Duron
 * 
 * */
public class Redo implements Command {

	private MiniEditor editor;

	public Redo(MiniEditor editor) {
		this.editor = editor;
	}

	@Override
	public void execute() {
		try {
			editor.redo();
		} catch (RedoException e) {
			System.out.println(e.getMessage());
		}
	}
}
