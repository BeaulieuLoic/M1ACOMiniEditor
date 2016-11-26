package receiver.exception;

import static org.junit.Assert.*;

import org.junit.Test;

import memento.Recorder;
import receiver.MiniEditorStub;

public class TestRedoException {
	MiniEditorStub editor;
	Recorder rec;

	@Test(expected = RedoException.class)
	public void TestRedo() throws RedoException {

		rec = new Recorder();
		editor = new MiniEditorStub(rec);

		editor.redo();

	}

}
