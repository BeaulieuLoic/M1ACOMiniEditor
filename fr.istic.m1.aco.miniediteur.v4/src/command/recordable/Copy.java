package command.recordable;

import Annulator.Annulator;
import memento.Memento;
import memento.MementoState;
import receiver.MiniEditor;
import record.Recorder;

public class Copy extends RecordableCommand {

	private MiniEditor editor;

	public Copy(MiniEditor e, Recorder r, Annulator a) {
		super(r,a);
		editor = e;
	}

	@Override
	public void execute() {
		editor.editorCopy();
		recorder.add(this);
		annulator.add(this);
	}

	public Memento createMemento() {
		return new Memento(new MementoState(editor.getStart(), editor.getEnd(), editor.getClipboard()));
	}
	
	@Override
	public void executeRecord(MementoState mem) {
		editor.editorCopy();
	}

}
