package command.recordable;

import record.Recorder;
import command.Command;
import memento.Memento;
import memento.MementoState;
/** 
 * @author Loic_Beaulieu Valentin_Duron
 * 
 * */
public abstract class RecordableCommand implements Command {

	protected MementoState mem;
	protected Recorder recorder;
	
	public RecordableCommand(Recorder rec){
		recorder = rec;
	}

	public void setMemento(Memento mem) {
		this.mem = mem.getState();
	}

	public abstract Memento createMemento();
	
	public abstract void executeRecord(MementoState mem);

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RecordableCommand other = (RecordableCommand) obj;
		if (mem == null) {
			if (other.mem != null)
				return false;
		} else if (!mem.equals(other.mem))
			return false;
		return true;
	}
}