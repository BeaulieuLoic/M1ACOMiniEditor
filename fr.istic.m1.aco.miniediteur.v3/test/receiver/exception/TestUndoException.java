package receiver.exception;

import static org.junit.Assert.*;
import org.junit.Test;

import command.recordable.InsertText;
import command.recordable.RecordableCommand;
import invoker.MiniEditorTextInterface;
import invoker.MiniIHM;
import memento.Recorder;
import receiver.MiniEditorStub;
import receiver.MiniState;

public class TestUndoException {
	MiniEditorStub editor;
	Recorder rec;
	
	@Test(expected=UndoException.class)
	public void TestUndo() throws UndoException{

		rec = new Recorder();
		editor = new MiniEditorStub(rec);

		editor.undo();

	}
	
}

