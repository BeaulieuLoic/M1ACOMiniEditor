package command;

import receiver.MiniEditor;
import receiver.exception.UndoException;
/** 
 * @author Loic_Beaulieu Valentin_Duron
 * @since 3.0
 * @version 3.0
 * */
public class Undo implements Command {

	private MiniEditor editor;
	
	public Undo(MiniEditor editor){
		this.editor=editor;
	}
	
	@Override
	public void execute() {
		try {
			editor.undo();
		} catch (UndoException e) {
			System.out.println(e.getMessage());
		}
	}
	

}
