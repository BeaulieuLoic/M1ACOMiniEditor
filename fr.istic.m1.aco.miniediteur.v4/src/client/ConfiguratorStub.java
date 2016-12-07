package client;

import record.Recorder;
import receiver.*;
import Annulator.Annulator;
import command.*;
import command.recordable.Copy;
import command.recordable.Cut;
import command.recordable.InsertText;
import command.recordable.ModifSelector;
import command.recordable.Paste;
import command.recordable.RemoveSelect;
import invoker.*;

public class ConfiguratorStub {

	/*
	 * ajouter tout les attributs et faire l'instanciation du tout
	 * 
	 * -MiniIHM -MiniEditor -Command : paste,Ins,Cut,Copy
	 */

	public static void main(String[] args) {

		Recorder rec = new Recorder();
		Annulator annulator = new Annulator();

		MiniEditor editor = new MiniEditorStub(rec, annulator);

		MiniIHM ihm = new MiniEditorTextInterface(editor);

		Command copy = new Copy(editor, rec, annulator);
		ihm.setCopy(copy);

		Command cut = new Cut(editor, rec, annulator);
		ihm.setCut(cut);

		Command paste = new Paste(editor, rec, annulator);
		ihm.setPaste(paste);

		Command insertText = new InsertText(editor, ihm, rec, annulator);
		ihm.setInsertText(insertText);

		Command modifSelector = new ModifSelector(editor, ihm, rec, annulator);
		ihm.setModifSelector(modifSelector);

		Command removeSelect = new RemoveSelect(editor, rec, annulator);
		ihm.setRemoveSelect(removeSelect);

		Command stopRecording = new StopRecording(rec);
		ihm.setStopRecording(stopRecording);

		Command playRecording = new PlayRecording(rec);
		ihm.setPlayRecording(playRecording);

		Command startRecording = new StartRecording(rec);
		ihm.setStartRecording(startRecording);

		Command undo = new Undo(editor);
		ihm.setUndo(undo);

		Command redo = new Redo(editor);
		ihm.setRedo(redo);

		ihm.launchIHM();

	}

}
