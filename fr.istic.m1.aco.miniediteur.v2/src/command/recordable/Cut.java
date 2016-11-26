package command.recordable;

import memento.Memento;
import memento.MementoState;
import receiver.MiniEditor;
import recorde.Recorder;

public class Cut extends RecordableCommand {

	private MiniEditor editor;

	public Cut(MiniEditor e, Recorder r) {
		super(r);
		recorder = r;
	}

	@Override
	public void execute() {
		editor.editorCut();
		recorder.add(this);
	}

	public Memento createMemento() {
		return new Memento(new MementoState(editor.getStart(), editor.getEnd(),
				editor.getClipboard()));
	}

	@Override
	public void executeRecord(MementoState mem) {
		editor.editorCut();
	}

}
