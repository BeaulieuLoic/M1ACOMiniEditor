package command.recordable;

import memento.MementoState;
import memento.Recorder;
import invoker.MiniIHM;
import receiver.MiniEditor;

public class RemoveSelect extends RecordableCommand {

	private MiniEditor editor;
	private Recorder recorder;
	
	public RemoveSelect(MiniEditor e, Recorder r){
		editor = e;
		recorder = r;
	}
	
	@Override
	public void execute() {
		editor.editorRemove();
		recorder.add(this);
	}
	
	@Override
	public MementoState getMemento() {
		setMemento(new MementoState(editor.getStart(), editor.getEnd(),""));
		return mem;
	}

	@Override
	public void executeRecord(MementoState mem) {
		editor.editorRemove();
	}
	
}
