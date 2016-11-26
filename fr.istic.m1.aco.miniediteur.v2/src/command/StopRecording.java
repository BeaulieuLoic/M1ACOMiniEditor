package command;

import recorde.Recorder;

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
