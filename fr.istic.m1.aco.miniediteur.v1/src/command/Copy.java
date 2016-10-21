package command;

import receiver.MiniEditor;
import receiver.MiniEditorStub;

public class Copy implements Command {

	private MiniEditor editeur;
	
	public Copy(){
		editeur = new MiniEditorStub();
	}
		
	@Override
	public void execute() {
		editeur.editorCopy();
	}

}
