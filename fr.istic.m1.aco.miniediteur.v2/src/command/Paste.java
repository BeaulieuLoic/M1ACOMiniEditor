package command;

import receiver.MiniEditor;

public class Paste implements Command {

	
	private MiniEditor editeur;
	
	public Paste(MiniEditor e){
		editeur = e;
	}
		
	@Override
	public void execute() {
		editeur.editorPaste();
	}

}
