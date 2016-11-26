package command;

import receiver.MiniEditor;
import recorde.Recorder;

public class PlayRecording implements Command {
	private Recorder rec;
	private MiniEditor editor;

	public PlayRecording(MiniEditor e, Recorder r) {
		rec = r;
		editor = e;
	}

	@Override
	public void execute() {
		rec.playRecord();
		editor.newState();
	}

}
