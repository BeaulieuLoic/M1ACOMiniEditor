package command;

import invoker.MiniIHM;
import receiver.MiniEditor;

public class InsertText implements Command {

	private MiniEditor editeur;
	private MiniIHM ihm;
	
	public InsertText(MiniEditor e, MiniIHM i){
		editeur = e;
		ihm = i;
		
	}
	
	@Override
	public void execute() {
		editeur.editorInsert(ihm.getText());
	}

}
