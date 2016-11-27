package command;

import record.Recorder;
/** 
 * @author Loic_Beaulieu Valentin_Duron
 * @since 2.0
 * @version 3.0
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
