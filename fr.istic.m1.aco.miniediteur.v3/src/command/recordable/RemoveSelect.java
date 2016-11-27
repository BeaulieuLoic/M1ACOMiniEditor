package command.recordable;

import memento.Memento;
import memento.MementoState;
import receiver.MiniEditor;
import record.Recorder;
/** 
 * @author Loic_Beaulieu Valentin_Duron
 * @since 1.0
 * @version 2.0
 * */
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
		editor.newState();
	}
	
	public Memento createMemento() {
		return new Memento(new MementoState(editor.getStart(), editor.getEnd(),""));
	}

	@Override
	public void executeRecord(MementoState mem) {
		editor.editorRemove();
	}
	
}
