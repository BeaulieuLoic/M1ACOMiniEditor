package client;

import receiver.*;
import record.Recorder;
import command.*;
import command.recordable.Copy;
import command.recordable.Cut;
import command.recordable.InsertText;
import command.recordable.ModifSelector;
import command.recordable.Paste;
import command.recordable.RemoveSelect;
import invoker.*;
/** 
 * @author Loic_Beaulieu Valentin_Duron
 * 
 * */
public class ConfiguratorStub {


	/**
	 * Initialize all necessary context
	 * @param args args
	 */
	public static void main(String[] args) {

		Recorder rec = new Recorder();

		MiniEditor editor = new MiniEditorStub();
		MiniIHM ihm = new MiniEditorTextStub(editor);

		Command copy = new Copy(editor, rec);
		ihm.setCopy(copy);

		Command cut = new Cut(editor, rec);
		ihm.setCut(cut);

		Command paste = new Paste(editor, rec);
		ihm.setPaste(paste);

		Command insertText = new InsertText(editor, ihm, rec);
		ihm.setInsertText(insertText);

		Command modifSelector = new ModifSelector(editor, ihm, rec);
		ihm.setModifSelector(modifSelector);

		Command removeSelect = new RemoveSelect(editor, rec);
		ihm.setRemoveSelect(removeSelect);

		Command stopRecording = new StopRecording(rec);
		ihm.setStopRecording(stopRecording);

		Command playRecording = new PlayRecording(editor, rec);
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
