package command;

import receiver.MiniEditor;
import record.Recorder;
/** 
 * @author Loic_Beaulieu Valentin_Duron
 * @since 2.0
 * @version 3.0
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
