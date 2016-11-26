package command.recordable;

import memento.Memento;
import memento.MementoState;
import invoker.MiniIHM;
import receiver.MiniEditor;
import recorde.Recorder;

public class RemoveSelect extends RecordableCommand {

	private MiniEditor editor;
	
	public RemoveSelect(MiniEditor e, Recorder r){
		super(r);
		editor = e;
	}
	
	@Override
	public void execute() {
		editor.editorRemove();
		recorder.add(this);
	}
	
	public Memento createMemento() {
		return new Memento(new MementoState(editor.getStart(), editor.getEnd(),""));
	}

	@Override
	public void executeRecord(MementoState mem) {
		editor.editorRemove();
	}
	
}
