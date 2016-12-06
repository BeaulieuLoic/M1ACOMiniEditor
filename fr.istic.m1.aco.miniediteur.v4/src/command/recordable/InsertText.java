package command.recordable;

import memento.Memento;
import memento.MementoState;
import Annulator.Annulator;
import invoker.MiniIHM;
import receiver.MiniEditor;
import record.Recorder;

public class InsertText extends RecordableCommand {

	private MiniEditor editor;
	private MiniIHM ihm;
	
	public InsertText(MiniEditor e, MiniIHM i, Recorder r, Annulator a){
		super(r,a);
		editor = e;
		ihm = i;		
	}
	
	@Override
	public void execute() {
		editor.editorInsert(ihm.getText());
		recorder.add(this);
		annulator.add(this);
	}
	
	public Memento createMemento() {
		return new Memento(new MementoState(editor.getStart(), editor.getEnd(), ihm.getText()));
	}	

	@Override
	public void executeRecord(MementoState mem) {
		editor.editorInsert(mem.getBuf());
	}
	
}
