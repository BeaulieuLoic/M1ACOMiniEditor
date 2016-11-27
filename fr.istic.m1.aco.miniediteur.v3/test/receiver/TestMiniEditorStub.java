package receiver;

import static org.junit.Assert.*;
import invoker.MiniEditorTextStub;
import invoker.MiniIHM;
import receiver.exception.UndoException;
import record.Recorder;

import org.junit.Test;

import command.recordable.InsertText;
import command.recordable.RecordableCommand;

public class TestMiniEditorStub {
	MiniEditorStub editor;
	Recorder rec;
	String msgTest = "aze ";

	@Test
	public void testEditorCopy() {
		System.out.println("----- testEditorCopy -----");
		rec = new Recorder();
		editor = new MiniEditorStub();
		editor.editorInsert(msgTest);
		editor.editorSelect(0, 500);
		editor.editorCopy();

		assertEquals(editor.getClipboard(),editor.getBuffer());

		System.out.println(editor);
	}

	@Test
	public void testEditorCut() {
		System.out.println("----- testEditorCut -----");
		rec = new Recorder();
		editor = new MiniEditorStub();
		editor.editorInsert(msgTest);
		editor.editorSelect(0, 500);
		editor.editorCut();
		System.out.println(editor);

		assertEquals(editor.getClipboard(),msgTest);
		assertEquals(editor.getBuffer(),"");
	}

	@Test
	public void testEditorPaste() {
		System.out.println("----- testEditorPaste -----");
		rec = new Recorder();
		editor = new MiniEditorStub();
		editor.editorInsert(msgTest);
		editor.editorSelect(0, 500);
		editor.editorCopy();
		editor.editorPaste();
		editor.editorPaste();
		editor.editorPaste();
		System.out.println(editor);
		
		assertEquals(editor.getBuffer(),(msgTest + msgTest + msgTest));
	}

	@Test
	public void testEditorInsert() {
		System.out.println("----- testEditorInsert -----");
		rec = new Recorder();
		editor = new MiniEditorStub();

		editor.editorInsert(msgTest);
		editor.editorInsert(msgTest);
		editor.editorSelect(0, 50);
		editor.editorInsert("a");
		System.out.println(editor);

		assertEquals(editor.getBuffer(),"a");

	}

	@Test
	public void testEditorSelect() {
		System.out.println("----- testEditorSelect -----");
		rec = new Recorder();
		editor = new MiniEditorStub();
		editor.editorInsert(msgTest);
		editor.editorSelect(0, 50);
		System.out.println(editor);

		assertEquals(editor,editor);
	}

	@Test
	public void testPlayRecording() {
		System.out.println("----- testPlayRecording -----");
		rec = new Recorder();
		editor = new MiniEditorStub();
		MiniIHM ihm = new MiniEditorTextStub(editor);
		ihm.setText(msgTest);

		RecordableCommand insert = new InsertText(editor, ihm, rec);

		insert.execute();
		rec.startRecord();

		insert.execute();

		insert.execute();
		rec.stopRecord();

		rec.playRecord();

		// nombre total d'insert = 5
		MiniEditorStub testEditor = new MiniEditorStub();

		testEditor.editorInsert(msgTest);
		testEditor.newState();
		testEditor.editorInsert(msgTest);
		testEditor.newState();
		testEditor.editorInsert(msgTest);
		testEditor.newState();

		testEditor.editorInsert(msgTest + msgTest);

		assertEquals(editor.getSelection(),testEditor.getSelection());
		assertEquals(editor.getClipboard(), testEditor.getClipboard());
		assertEquals(editor.getBuffer(),testEditor.getBuffer());
	}

	@Test
	public void testUndo() {
		System.out.println("----- testUndo -----");
		rec = new Recorder();
		editor = new MiniEditorStub();
		MiniIHM ihm = new MiniEditorTextStub(editor);

		ihm.setText(msgTest);
		RecordableCommand insert = new InsertText(editor, ihm, rec);

		MiniState firstState = editor.getState();

		insert.execute();

		try {
			editor.undo();
		} catch (UndoException e) {
			e.printStackTrace();
		}

		System.out.println(editor);
		assertEquals(firstState,editor.getState());

	}

	@Test
	public void testRedo() {
		System.out.println("----- testRedo -----");
		rec = new Recorder();
		editor = new MiniEditorStub();
		MiniIHM ihm = new MiniEditorTextStub(editor);

		ihm.setText(msgTest);
		RecordableCommand insert = new InsertText(editor, ihm, rec);

		insert.execute();

		MiniState secondState = editor.getState();

		try {
			editor.undo();
			editor.redo();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(editor);
		assertEquals(secondState,editor.getState());
	}

}
