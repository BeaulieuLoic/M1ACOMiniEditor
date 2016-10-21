package command;

import receiver.MiniEditor;

public class Copy implements Command {

	private MiniEditor editeur;
	
	public Copy(MiniEditor e){
		editeur = e;
	}
		
	@Override
	public void execute() {
		editeur.editorCopy();
	}

}
