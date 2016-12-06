package command;

import record.Recorder;

public class StopRecording implements Command {

	private Recorder rec;

	public StopRecording(Recorder e) {
		rec = e;
	}

	@Override
	public void execute() {
		rec.stopRecord();
	}

}
