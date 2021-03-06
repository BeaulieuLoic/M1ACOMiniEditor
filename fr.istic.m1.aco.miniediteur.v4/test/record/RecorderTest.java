package record;

import static org.junit.Assert.*;
import invoker.MiniEditorTextInterface;
import invoker.MiniIHM;
import memento.MementoSave;

import org.junit.Test;

import Annulator.Annulator;
import receiver.MiniEditor;
import receiver.MiniEditorStub;
import record.CommandMemento;
import record.Recorder;
import command.recordable.InsertText;
import command.recordable.RecordableCommand;



public class RecorderTest {
	Recorder recorder;
	Annulator annulator;
	MiniEditor editor;
	MiniIHM ihm;
	
	
	@Test
	public void testAdd1() {
		recorder = new Recorder();
		annulator = new Annulator();
		editor = new MiniEditorStub(recorder, annulator);
		ihm = new MiniEditorTextInterface(editor);
		
		RecordableCommand insert = new InsertText(editor, ihm, recorder, annulator);
		recorder.add(insert);
		recorder.add(insert);


		Recorder testRec = new Recorder();

		
		
		assertEquals(recorder,testRec);
	}
	
	@Test
	public void testAdd2() {
		recorder = new Recorder();
		annulator = new Annulator();
		editor = new MiniEditorStub(recorder, annulator);
		ihm = new MiniEditorTextInterface(editor);

		RecordableCommand insert = new InsertText(editor, ihm, recorder, annulator);
		
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
