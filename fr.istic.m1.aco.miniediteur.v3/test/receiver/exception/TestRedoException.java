package receiver.exception;

import static org.junit.Assert.*;

import org.junit.Test;

import receiver.MiniEditorStub;
import record.Recorder;

public class TestRedoException {
	MiniEditorStub editor;
	Recorder rec;

	@Test(expected = RedoException.class)
	public void TestRedo() throws RedoException {

		rec = new Recorder();
		editor = new MiniEditorStub();

		editor.redo();

	}

}
