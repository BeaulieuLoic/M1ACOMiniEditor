package command;

import record.Recorder;
/** 
 * @author Loic_Beaulieu Valentin_Duron
 * @since 2.0
 * @version 3.0
 * */
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
