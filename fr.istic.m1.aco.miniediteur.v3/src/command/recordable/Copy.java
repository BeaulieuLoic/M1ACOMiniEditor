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
public class Copy extends RecordableCommand {

	private MiniEditor editor;

	public Copy(MiniEditor e, Recorder r) {
		super(r);
		editor = e;
	}

	@Override
	public void execute() {
		editor.editorCopy();
		recorder.add(this);
	}

	public Memento createMemento() {
		return new Memento(new MementoState(editor.getStart(), editor.getEnd(), editor.getClipboard()));
	}

	@Override
	public void executeRecord(MementoState mem) {
		editor.editorCopy();
	}

}
