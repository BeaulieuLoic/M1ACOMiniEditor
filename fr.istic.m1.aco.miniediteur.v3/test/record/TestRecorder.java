package record;

import static org.junit.Assert.*;
import invoker.MiniEditorTextStub;
import invoker.MiniIHM;
import memento.MementoSave;

import org.junit.Test;

import receiver.MiniEditor;
import receiver.MiniEditorStub;
import record.CommandMemento;
import record.Recorder;
import command.recordable.InsertText;
import command.recordable.RecordableCommand;



public class TestRecorder {
	Recorder recorder;
	MiniEditor editor;
	MiniIHM ihm;
	
	
	@Test
	public void testAdd1() {
		recorder = new Recorder();
		editor = new MiniEditorStub();
		ihm = new MiniEditorTextStub(editor);
		
		RecordableCommand insert = new InsertText(editor, ihm, recorder);
		recorder.add(insert);
		recorder.add(insert);


		Recorder testRec = new Recorder();

		
		
		assertEquals(recorder,testRec);
	}
	
	@Test
	public void testAdd2() {
		recorder = new Recorder();
		editor = new MiniEditorStub();
		ihm = new MiniEditorTextStub(editor);

		RecordableCommand insert = new InsertText(editor, ihm, recorder);
		
		recorder.add(insert);
		
		recorder.startRecord();
		recorder.add(insert);
		recorder.stopRecord();
		
		
		Recorder testRec = new Recorder();
		CommandMemento mem = new CommandMemento(insert, new MementoSave(insert.createMemento()));
		testRec.getListCommand().add(mem);
		
		assertEquals(recorder,testRec);
	}

}
