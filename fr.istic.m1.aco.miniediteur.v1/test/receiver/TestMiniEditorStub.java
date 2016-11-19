package receiver;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMiniEditorStub {
	MiniEditor editor;
	String msgTest = "azerty";

	@Test
	public void testEditorCopy() {
		System.out.println("----- testEditorCopy -----");
		editor = new MiniEditorStub();
		editor.editorInsert(msgTest);
		editor.editorSelect(0, 500);
		editor.editorCopy();

		assertTrue(editor.getClipboard().equals(editor.getBuffer()));
		System.out.println(editor);
	}

	@Test
	public void testEditorCut() {
		System.out.println("----- testEditorCut -----");
		editor = new MiniEditorStub();
		editor.editorInsert(msgTest);
		editor.editorSelect(0, 500);
		editor.editorCut();
		System.out.println(editor);

		assertTrue(editor.getClipboard().equals(msgTest) && editor.getBuffer().equals(""));
	}

	@Test
	public void testEditorPaste() {
		System.out.println("----- testEditorPaste -----");
		editor = new MiniEditorStub();
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
		editor = new MiniEditorStub();

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
		editor = new MiniEditorStub();
		editor.editorInsert(msgTest);
		editor.editorSelect(0, 50);
		System.out.println(editor);

		assertTrue(editor.getBuffer().equals(editor.getSelection()));
	}

}
