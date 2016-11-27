package client;

import receiver.MiniEditor;
import receiver.MiniEditorStub;
import command.Command;
import command.Copy;
import command.Cut;
import command.InsertText;
import command.ModifSelector;
import command.Paste;
import command.RemoveSelect;
import invoker.MiniEditorTextInterface;
import invoker.MiniIHM;

public class ConfiguratorStub {

	/* ajouter tout les attributs et faire l'instanciation du tout
	
	-MiniIHM
	-MiniEditor
	-Command : paste,Ins,Cut,Copy
	*/
	
	
	public static void main(String[] args) {
		
		
		MiniEditor editor = new MiniEditorStub();
		MiniIHM ihm = new MiniEditorTextInterface(editor);
		
		
		Command copy = new Copy(editor);
		ihm.setCopy(copy);
		
		Command cut = new Cut(editor);
		ihm.setCut(cut);
		
		Command paste = new Paste(editor);
		ihm.setPaste(paste);
		
		Command insertText = new InsertText(editor,ihm);
		ihm.setInsertText(insertText);
		
		Command modifSelector = new ModifSelector(editor,ihm);
		ihm.setModifSelector(modifSelector);
		
		Command removeSelect = new RemoveSelect(editor);
		ihm.setRemoveSelect(removeSelect);
		
		ihm.launchIHM();
		
		
		
		
	}
	
}
