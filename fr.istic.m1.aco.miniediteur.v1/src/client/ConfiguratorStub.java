package client;

import java.util.HashMap;
import java.util.Map;

import receiver.MiniEditor;
import receiver.MiniEditorStub;
import command.Command;
import command.Copy;
import command.Cut;
import command.InsertText;
import command.ModifSelector;
import command.Paste;
import command.RemoveSelect;
import invoker.MiniIHM;
import invoker.MiniIHMStub;

public class ConfiguratorStub {

	/* ajouter tout les attributs et faire l'instanciation du tout
	
	-MiniIHM
	-MiniEditor
	-Command : paste,Ins,Cut,Copy
	*/
	
	
	public static void main(String[] args) {
		
		
		MiniEditor editor = new MiniEditorStub();
		MiniIHM frame = new MiniIHMStub();
		
		
		Command copy = new Copy(editor);
		frame.setCopy(copy);
		
		Command cut = new Cut(editor);
		frame.setCut(cut);
		
		Command paste = new Paste(editor);
		frame.setPaste(paste);
		
		Command insertText = new InsertText(editor,frame);
		frame.setInsertText(insertText);
		
		Command modifSelector = new ModifSelector(editor,frame);
		frame.setModifSelector(modifSelector);
		
		Command removeSelect = new RemoveSelect(editor);
		frame.setRemoveSelect(removeSelect);
		
		
		
		
	}
	
}
