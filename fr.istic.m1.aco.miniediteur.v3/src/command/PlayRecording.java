package command;

import memento.Recorder;

public class PlayRecording implements Command {
	private Recorder rec;

	public PlayRecording(Recorder r) {
		rec = r;
	}

	@Override
	public void execute() {
		rec.playRecord();
	}

}
