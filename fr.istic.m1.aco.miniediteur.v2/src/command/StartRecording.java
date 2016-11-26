package command;

import recorde.Recorder;

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
