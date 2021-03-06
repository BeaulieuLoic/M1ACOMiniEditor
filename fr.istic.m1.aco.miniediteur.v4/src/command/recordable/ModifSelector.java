/**
 * 
 */
package command.recordable;

import memento.Memento;
import memento.MementoState;
import Annulator.Annulator;
import invoker.MiniIHM;
import receiver.MiniEditor;
import record.Recorder;

/**
 * @author Loic_Beaulieu
 *
 */
public class ModifSelector extends RecordableCommand {

	private MiniEditor editor;
	private MiniIHM ihm;
	
	public ModifSelector(MiniEditor e, MiniIHM i, Recorder r, Annulator a) {
		super(r,a);
		editor = e;
		ihm = i;
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
		//annulator.add(this);
	}

	public Memento createMemento() {
		return new Memento(new MementoState(editor.getStart(), editor.getEnd(), ""));
	}

	@Override
	public void executeRecord(MementoState mem) {
		editor.editorSelect(mem.getSelStart(), mem.getSelEnd());
	}

}
