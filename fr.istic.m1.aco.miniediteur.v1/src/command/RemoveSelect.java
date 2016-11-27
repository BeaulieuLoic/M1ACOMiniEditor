package command;

import receiver.MiniEditor;

public class RemoveSelect implements Command {

	private MiniEditor editeur;

	public RemoveSelect(MiniEditor e) {
		editeur = e;
	}

	@Override
	public void execute() {
		editeur.editorRemove();
	}

}
