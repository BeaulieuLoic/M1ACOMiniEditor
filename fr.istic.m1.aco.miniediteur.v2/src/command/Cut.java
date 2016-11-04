package command;

import receiver.MiniEditor;


public class Cut implements Command {

	private MiniEditor editeur;
	
	public Cut(MiniEditor e){
		editeur = e;
	}
		
	@Override
	public void execute() {
		editeur.editorCut();
	}


}
