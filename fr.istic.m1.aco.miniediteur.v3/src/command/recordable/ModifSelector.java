/**
 * 
 */
package command.recordable;

import memento.MementoState;
import memento.Recorder;
import invoker.MiniIHM;
import receiver.MiniEditor;

/**
 * @author Loic_Beaulieu
 *
 */
public class ModifSelector extends RecordableCommand {

	private MiniEditor editor;
	private MiniIHM ihm;
	private Recorder recorder;
	
	public ModifSelector(MiniEditor e, MiniIHM i, Recorder r) {
		editor = e;
		ihm = i;
		recorder = r;
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see command.Command#execute()
	 */
	@Override
	public void execute() {
		editor.editorSelect(ihm.getSelectStart(), ihm.getSelectEnd());
		recorder.add(this);
		editor.newState();
	}

	@Override
	public MementoState getMemento() {
		setMemento(new MementoState(editor.getStart(), editor.getEnd(), ""));
		return mem;
	}

	@Override
	public void executeRecord(MementoState mem) {
		editor.editorSelect(mem.getSelStart(), mem.getSelEnd());
	}

}
