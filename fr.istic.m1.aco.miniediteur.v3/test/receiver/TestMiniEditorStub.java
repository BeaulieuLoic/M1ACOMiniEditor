package receiver;

import static org.junit.Assert.*;
import memento.Recorder;

import org.junit.Test;

public class TestMiniEditorStub {
	MiniEditor editor;
	Recorder rec;
	String msgTest = "azerty";
	

	@Test
	public void testEditorCopy() {
		System.out.println("----- testEditorCopy -----");
		rec = new Recorder();
		editor = new MiniEditorStub(rec);
		editor.editorInsert(msgTest);
		editor.editorSelect(0,500);
		editor.editorCopy();
		
		
		System.out.println(editor);
		fail("Not yet implemented");
	}

	@Test
	public void testEditorCut() {
		System.out.println("----- testEditorCut -----");
		rec = new Recorder();
		editor = new MiniEditorStub(rec);
		editor.editorInsert(msgTest);
		editor.editorSelect(0,500);
		editor.editorCut();
		
		
		System.out.println(editor);
		
		fail("Not yet implemented");
	}

	@Test
	public void testEditorPaste() {
		System.out.println("----- testEditorPaste -----");
		rec = new Recorder();
		editor = new MiniEditorStub(rec);
		editor.editorInsert(msgTest);
		editor.editorSelect(0,500);
		editor.editorCopy();
		editor.editorPaste();
		editor.editorPaste();
		editor.editorPaste();
		
		System.out.println(editor);
		fail("Not yet implemented");
	}

	@Test
	public void testEditorInsert() {
		System.out.println("----- testEditorInsert -----");
		rec = new Recorder();
		editor = new MiniEditorStub(rec);
		
		editor.editorInsert(msgTest);
		editor.editorInsert(msgTest);
		editor.editorSelect(0,50);
		editor.editorInsert("a");
		System.out.println(editor);
		
		fail("Not yet implemented");
	}

	@Test
	public void testEditorSelect() {
		System.out.println("----- testEditorSelect -----");
		rec = new Recorder();
		editor = new MiniEditorStub(rec);
		editor.editorSelect(50,50);
		
		System.out.println(editor);
		fail("Not yet implemented");
	}

}
