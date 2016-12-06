package command;

import record.Recorder;

public class StartRecording implements Command {
	
	private Recorder rec;
	
	public StartRecording(Recorder e){
		rec = e;
	}
	
	@Override
	public void execute() {
		rec.startRecord();
	}

}
