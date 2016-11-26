package client;

import java.util.HashMap;
import java.util.Map;

import record.Recorder;
import receiver.*;
import command.*;
import command.recordable.Copy;
import command.recordable.Cut;
import command.recordable.InsertText;
import command.recordable.ModifSelector;
import command.recordable.Paste;
import command.recordable.RemoveSelect;
import invoker.*;

public class ConfiguratorStub {

	/* ajouter tout les attributs et faire l'instanciation du tout
	
	-MiniIHM
	-MiniEditor
	-Command : paste,Ins,Cut,Copy
	*/
	
	
	public static void main(String[] args) {
		
		Recorder rec = new Recorder();
		
		MiniEditor editor = new MiniEditorStub(rec);
		MiniIHM ihm = new MiniEditorTextInterface(editor);
		
		
		Command copy = new Copy(editor,rec);
		ihm.setCopy(copy);
		
		Command cut = new Cut(editor,rec);
		ihm.setCut(cut);
		
		Command paste = new Paste(editor,rec);
		ihm.setPaste(paste);
		
		Command insertText = new InsertText(editor,ihm,rec);
		ihm.setInsertText(insertText);
		
		Command modifSelector = new ModifSelector(editor,ihm,rec);
		ihm.setModifSelector(modifSelector);
		
		Command removeSelect = new RemoveSelect(editor,rec);
		ihm.setRemoveSelect(removeSelect);
		
		
		Command stopRecording = new StopRecording(rec);
		ihm.setStopRecording(stopRecording);
		
		Command playRecording = new PlayRecording(rec);
		ihm.setPlayRecording(playRecording);
		
		Command startRecording = new StartRecording(rec);
		ihm.setStartRecording(startRecording);
		
		
		
		ihm.launchIHM();
		
		
		
		
	}
	
}
