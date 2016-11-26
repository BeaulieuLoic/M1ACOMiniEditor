package command;

import receiver.MiniEditor;
import record.Recorder;

public class StopRecording implements Command {

	private Recorder rec;
	private MiniEditor editor;

	public StopRecording(MiniEditor e,Recorder r) {
		rec = r;
		editor = e;
	}

	@Override
	public void execute() {
		rec.stopRecord();
	}

}
