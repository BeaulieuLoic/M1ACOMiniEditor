package command.recordable;

import memento.Memento;
import memento.MementoState;
import invoker.MiniIHM;
import receiver.MiniEditor;
import record.Recorder;
/** 
 * @author Loic_Beaulieu Valentin_Duron
 * @since 1.0
 * @version 2.0
 * */
public class InsertText extends RecordableCommand {

	private MiniEditor editor;
	private MiniIHM ihm;
	
	public InsertText(MiniEditor e, MiniIHM i, Recorder r){
		super(r);
		editor = e;
		ihm = i;		
	}
	
	@Override
	public void execute() {
		editor.editorInsert(ihm.getText());
		recorder.add(this);
		editor.newState();
	}
	
	public Memento createMemento() {
		return new Memento(new MementoState(editor.getStart(), editor.getEnd(), ihm.getText()));
	}	

	@Override
	public void executeRecord(MementoState mem) {
		editor.editorInsert(mem.getBuf());
	}
	
}
