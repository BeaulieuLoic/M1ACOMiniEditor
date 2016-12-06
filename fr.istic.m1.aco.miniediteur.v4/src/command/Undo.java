package command;

import Annulator.exception.UndoException;
import receiver.MiniEditor;

public class Undo implements Command {
	private MiniEditor editor;

	public Undo(MiniEditor e) {
		editor = e;
	}

	public void execute() {
		try {
			editor.undo();
		} catch (UndoException e) {
			System.out.println(e.getMessage());
		}
	}

}
