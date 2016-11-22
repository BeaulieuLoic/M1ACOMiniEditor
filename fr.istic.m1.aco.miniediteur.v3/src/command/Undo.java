package command;

import receiver.MiniEditor;
import receiver.exception.UndoException;

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
