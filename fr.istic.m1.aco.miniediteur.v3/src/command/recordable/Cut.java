package command.recordable;

import memento.MementoState;
import memento.Recorder;
import receiver.MiniEditor;

public class Cut extends RecordableCommand {

	private MiniEditor editor;
	private Recorder recorder;

	public Cut(MiniEditor e, Recorder r) {
		editor = e;
		recorder = r;
	}

	@Override
	public void execute() {
		editor.editorCut();
		recorder.add(this);
	}

	@Override
	public MementoState getMemento() {
		setMemento(new MementoState(editor.getStart(), editor.getEnd(),
				editor.getClipboard()));
		return mem;
	}

	@Override
	public void executeRecord(MementoState mem) {
		editor.editorCut();
	}

}
