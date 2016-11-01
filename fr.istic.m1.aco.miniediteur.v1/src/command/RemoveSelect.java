package command;

import invoker.MiniIHM;
import receiver.MiniEditor;

public class RemoveSelect implements Command {

	private MiniEditor editeur;
	private MiniIHM ihm;
	
	public RemoveSelect(MiniEditor e){
		editeur = e;		
	}
	
	@Override
	public void execute() {
		editeur.editorRemove();
	}

}
