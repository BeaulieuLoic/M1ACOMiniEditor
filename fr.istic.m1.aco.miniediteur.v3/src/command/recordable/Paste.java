package command.recordable;

import memento.MementoState;
import memento.Recorder;
import receiver.MiniEditor;

public class Paste extends RecordableCommand {

	private MiniEditor editor;
	private Recorder recorder;
	
	public Paste(MiniEditor e, Recorder r) {
		editor = e;
		recorder = r;
	}

	@Override
	public void execute() {
		editor.editorPaste();
		recorder.add(this);
		editor.newState();
	}

	@Override
	public MementoState getMemento() {
		setMemento(new MementoState(editor.getStart(), editor.getEnd(),
				editor.getClipboard()));
		return mem;
	}

	@Override
	public void executeRecord(MementoState mem) {
		editor.editorPaste();
	}
}
