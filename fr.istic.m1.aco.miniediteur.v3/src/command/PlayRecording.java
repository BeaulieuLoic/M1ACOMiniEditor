package command;

import receiver.MiniEditor;
import record.Recorder;
/** 
 * @author Loic_Beaulieu Valentin_Duron
 * 
 * */
public class PlayRecording implements Command {
	private Recorder rec;
	private MiniEditor editor;

	public PlayRecording(MiniEditor e, Recorder r) {
		rec = r;
		editor = e;
	}

	@Override
	public void execute() {
		rec.playRecord();
		editor.newState();
	}

}
