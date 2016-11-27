package receiver.exception;

import org.junit.Test;

import receiver.MiniEditorStub;
import record.Recorder;

public class TestUndoException {
	MiniEditorStub editor;
	Recorder rec;
	
	@Test(expected=UndoException.class)
	public void TestUndo() throws UndoException{

		rec = new Recorder();
		editor = new MiniEditorStub();

		editor.undo();

	}
	
}

