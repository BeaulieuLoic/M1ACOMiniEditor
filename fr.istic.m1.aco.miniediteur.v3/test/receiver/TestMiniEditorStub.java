package receiver;

import static org.junit.Assert.*;
import invoker.MiniEditorTextInterface;
import invoker.MiniIHM;
import memento.Recorder;

import org.junit.Test;

import command.recordable.InsertText;
import command.recordable.RecordableCommand;

public class TestMiniEditorStub {
	MiniEditor editor;
	Recorder rec;
	String msgTest = "aze ";

	@Test
	public void testEditorCopy() {
		System.out.println("----- testEditorCopy -----");
		rec = new Recorder();
		editor = new MiniEditorStub(rec);
		editor.editorInsert(msgTest);
		editor.editorSelect(0, 500);
		editor.editorCopy();

		assertTrue(editor.getClipboard().equals(editor.getBuffer()));
		System.out.println(editor);
	}

	@Test
	public void testEditorCut() {
		System.out.println("----- testEditorCut -----");
		rec = new Recorder();
		editor = new MiniEditorStub(rec);
		editor.editorInsert(msgTest);
		editor.editorSelect(0, 500);
		editor.editorCut();
		System.out.println(editor);

		assertTrue(editor.getClipboard().equals(msgTest) && editor.getBuffer().equals(""));
	}

	@Test
	public void testEditorPaste() {
		System.out.println("----- testEditorPaste -----");
		rec = new Recorder();
		editor = new MiniEditorStub(rec);
		editor.editorInsert(msgTest);
		editor.editorSelect(0, 500);
		editor.editorCopy();
		editor.editorPaste();
		editor.editorPaste();
		editor.editorPaste();
		System.out.println(editor);

		assertTrue(editor.getBuffer().equals(msgTest + msgTest + msgTest));
	}

	@Test
	public void testEditorInsert() {
		System.out.println("----- testEditorInsert -----");
		rec = new Recorder();
		editor = new MiniEditorStub(rec);

		editor.editorInsert(msgTest);
		editor.editorInsert(msgTest);
		editor.editorSelect(0, 50);
		editor.editorInsert("a");
		System.out.println(editor);

		assertTrue(editor.getBuffer().equals("a"));

	}

	@Test
	public void testEditorSelect() {
		System.out.println("----- testEditorSelect -----");
		rec = new Recorder();
		editor = new MiniEditorStub(rec);
		editor.editorInsert(msgTest);
		editor.editorSelect(0, 50);
		System.out.println(editor);

		assertTrue(editor.equals(editor));
	}
	
	@Test
	public void testPlayRecording() {
		System.out.println("----- testPlayRecording -----");
		rec = new Recorder();
		editor = new MiniEditorStub(rec);
		MiniIHM ihm = new MiniEditorTextInterface(editor);
		ihm.setText(msgTest);
		
		RecordableCommand insert = new InsertText(editor, ihm, rec);
		
		
		System.out.println("etat1");
		insert.execute();
		rec.startRecord();

		System.out.println("etat2");
		insert.execute();

		System.out.println("etat3");
		insert.execute();
		rec.stopRecord();
		

		System.out.println("etat4");
		editor.playRecording();
		
		//nombre total d'insert = 5
		MiniEditor testEditor = new MiniEditorStub(rec);

		testEditor.editorInsert(msgTest);
		testEditor.newState();
		testEditor.editorInsert(msgTest);
		testEditor.newState();
		testEditor.editorInsert(msgTest);
		testEditor.newState();

		testEditor.editorInsert(msgTest+msgTest);
		
		
		System.out.println(editor);
		System.out.println(testEditor);
		assertTrue(editor.equals(testEditor));
	}
	
	
	

}
