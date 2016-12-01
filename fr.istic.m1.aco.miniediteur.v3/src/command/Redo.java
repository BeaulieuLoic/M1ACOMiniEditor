package command;

import receiver.MiniEditor;
import receiver.exception.RedoException;
/** 
 * @author Loic_Beaulieu Valentin_Duron
 * @since 3.0
 * @version 3.0
 * */
public class Redo implements Command {

	private MiniEditor editor;

	public Redo(MiniEditor editor) {
		this.editor = editor;
	}
	
	/**
	 * Execute the concerned command and
	 * do diverse others operations given by context
	 * 
	 * And catch RedoExceptions
	 */
	@Override
	public void execute() {
		try {
			editor.redo();
		} catch (RedoException e) {
			System.out.println(e.getMessage());
		}
	}
}
