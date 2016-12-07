package receiver;

import static org.junit.Assert.*;
import invoker.MiniEditorTextInterface;
import invoker.MiniIHM;
import record.Recorder;

import org.junit.Test;

import Annulator.Annulator;
import command.recordable.InsertText;
import command.recordable.RecordableCommand;

public class TestMiniEditorStub {
	MiniEditorStub editor;
	Recorder rec;
	Annulator ann;
	String msgTest = "aze ";

	@Test
	public void testEditorCopy() {
		System.out.println("----- testEditorCopy -----");
		rec = new Recorder();
		ann = new Annulator();
		editor = new MiniEditorStub(rec, ann);
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
		ann = new Annulator();
		editor = new MiniEditorStub(rec, ann);
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
		ann = new Annulator();
		editor = new MiniEditorStub(rec, ann);
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
		ann = new Annulator();
		editor = new MiniEditorStub(rec, ann);

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
		ann = new Annulator();
		editor = new MiniEditorStub(rec, ann);
		editor.editorInsert(msgTest);
		editor.editorSelect(0, 50);
		System.out.println(editor);

		assertEquals(editor,editor);
	}

	@Test
	public void testPlayRecording() {
		System.out.println("----- testPlayRecording -----");
		rec = new Recorder();
		ann = new Annulator();
		editor = new MiniEditorStub(rec, ann);
		MiniIHM ihm = new MiniEditorTextInterface(editor);
		ihm.setText(msgTest);

		RecordableCommand insert = new InsertText(editor, ihm, rec, ann);

		insert.execute();
		rec.startRecord();

		insert.execute();

		insert.execute();
		rec.stopRecord();

		rec.playRecord();

		// nombre total d'insert = 5
		MiniEditorStub testEditor = new MiniEditorStub(rec, ann);

		testEditor.editorInsert(msgTest);
		testEditor.editorInsert(msgTest);
		testEditor.editorInsert(msgTest);

		testEditor.editorInsert(msgTest + msgTest);
		
		System.out.println(editor);
		System.out.println(testEditor);
		
		assertEquals(editor.getSelection(),testEditor.getSelection());
		assertEquals(editor.getClipboard(), testEditor.getClipboard());
		assertEquals(editor.getBuffer(),testEditor.getBuffer());
	}
}
