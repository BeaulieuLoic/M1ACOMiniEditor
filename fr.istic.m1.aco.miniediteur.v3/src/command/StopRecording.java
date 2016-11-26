package command;

import receiver.MiniEditor;
import record.Recorder;

public class StopRecording implements Command {

	private Recorder rec;

	public StopRecording(Recorder r) {
		rec = r;
	}

	@Override
	public void execute() {
		rec.stopRecord();
	}

}
