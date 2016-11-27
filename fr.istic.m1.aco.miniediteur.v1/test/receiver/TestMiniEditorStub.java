package receiver;

import static org.junit.Assert.*;

import org.junit.Test;


public class TestMiniEditorStub {
	MiniEditorStub editor;
	String msgTest = "aze ";

	@Test
	public void testEditorCopy() {
		System.out.println("----- testEditorCopy -----");
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
		editor = new MiniEditorStub();
		editor.editorInsert(msgTest);
		editor.editorSelect(0, 50);
		System.out.println(editor);

		assertEquals(editor,editor);
	}


	
}
