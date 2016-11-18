package command.recordable;

import memento.MementoState;
import memento.Recorder;
import receiver.MiniEditor;

public class Copy extends RecordableCommand {

	private MiniEditor editor;
	private Recorder recorder;

	public Copy(MiniEditor e, Recorder r) {
		editor = e;
		recorder = r;
	}

	@Override
	public void execute() {
		editor.editorCopy();
		recorder.add(this);
	}

	@Override
	public MementoState getMemento() {
		setMemento(new MementoState(editor.getStart(), editor.getEnd(), editor.getClipboard()));
		return mem;
	}

	@Override
	public void executeRecord(MementoState mem) {
		editor.editorCopy();
	}

}
