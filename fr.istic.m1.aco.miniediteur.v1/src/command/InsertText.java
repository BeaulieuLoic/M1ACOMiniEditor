package command;

import receiver.MiniEditor;

public class InsertText implements Command {

	private MiniEditor editeur;
	
	public InsertText(MiniEditor e){
		editeur = e;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub

	}

}
