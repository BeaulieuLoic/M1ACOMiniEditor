package command.recordable;

import memento.MementoState;
import memento.Recorder;
import invoker.MiniIHM;
import receiver.MiniEditor;

public class InsertText extends RecordableCommand {

	private MiniEditor editor;
	private MiniIHM ihm;
	private Recorder recorder;
	
	public InsertText(MiniEditor e, MiniIHM i, Recorder r){
		editor = e;
		ihm = i;
		recorder = r;
		
	}
	
	@Override
	public void execute() {
		editor.editorInsert(ihm.getText());
		recorder.add(this);
		editor.newState();
	}
	
	@Override
	public MementoState getMemento() {
		setMemento(new MementoState(editor.getStart(), editor.getEnd(), ihm.getText()));
		return mem;
	}	

	@Override
	public void executeRecord(MementoState mem) {
		editor.editorInsert(mem.getBuf());
	}
	
}
