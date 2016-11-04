package client;

import java.util.HashMap;
import java.util.Map;

import receiver.*;
import command.*;
import invoker.*;

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
		
		
		Command endRecording = new EndRecording(editor);
		ihm.setEndRecording(endRecording);
		
		Command playRecording = new PlayRecording(editor);
		ihm.setPlayRecording(playRecording);
		
		Command startRecording = new StartRecording(editor);
		ihm.setStartRecording(startRecording);
		
		
		
		ihm.launchIHM();
		
		
		
		
	}
	
}
