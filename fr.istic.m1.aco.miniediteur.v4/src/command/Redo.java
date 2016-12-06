package command;

import Annulator.exception.RedoException;
import receiver.MiniEditor;

public class Redo implements Command {
	private MiniEditor editor;

	public Redo(MiniEditor e) {
		editor = e;
	}

	public void execute() {
		try {
			editor.redo();
		} catch (RedoException e) {
			System.out.println(e.getMessage());
		}
	}

}
