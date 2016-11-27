package command;

import record.Recorder;
/** 
 * @author Loic_Beaulieu Valentin_Duron
 * 
 * */
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
