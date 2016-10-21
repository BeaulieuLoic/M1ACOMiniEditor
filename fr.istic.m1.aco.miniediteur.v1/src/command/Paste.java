package command;

import receiver.MiniEditor;
import receiver.MiniEditorStub;

public class Paste implements Command {

	
	private MiniEditor editeur;
	
	public Paste(){
		editeur = new MiniEditorStub();
	}
		
	@Override
	public void execute() {
		editeur.editorPaste();
	}

}
