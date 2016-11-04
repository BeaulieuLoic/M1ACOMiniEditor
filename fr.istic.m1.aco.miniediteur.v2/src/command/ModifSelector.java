/**
 * 
 */
package command;

import invoker.MiniIHM;
import receiver.MiniEditor;

/**
 * @author Loic_Beaulieu
 *
 */
public class ModifSelector implements Command {


	private MiniEditor editeur;
	private MiniIHM ihm;
	
	public ModifSelector(MiniEditor e, MiniIHM i){
		editeur = e;
		ihm = i;
		
	}
	
	
	
	/* (non-Javadoc)
	 * @see command.Command#execute()
	 */
	@Override
	public void execute() {
		editeur.editorSelect(ihm.getSelectStart(),ihm.getSelectEnd());
	}
	
	

}
