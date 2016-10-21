package command;

import receiver.MiniEditor;
import receiver.MiniEditorStub;

public class Cut implements Command {

	private MiniEditor editeur;
	
	public Cut(){
		editeur = new MiniEditorStub();
	}
		
	@Override
	public void execute() {
		editeur.editorCut();
	}


}
