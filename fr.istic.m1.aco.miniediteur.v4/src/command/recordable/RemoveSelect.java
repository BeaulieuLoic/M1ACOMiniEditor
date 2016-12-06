package command.recordable;

import Annulator.Annulator;
import memento.Memento;
import memento.MementoState;
import receiver.MiniEditor;
import record.Recorder;

public class RemoveSelect extends RecordableCommand {

	private MiniEditor editor;

	public RemoveSelect(MiniEditor e, Recorder r, Annulator a) {
		super(r, a);
		editor = e;
	}

	@Override
	public void execute() {
		editor.editorRemove();
		recorder.add(this);
		annulator.add(this);
	}

	public Memento createMemento() {
		return new Memento(new MementoState(editor.getStart(), editor.getEnd(), ""));
	}

	@Override
	public void executeRecord(MementoState mem) {
		editor.editorRemove();
	}

}
