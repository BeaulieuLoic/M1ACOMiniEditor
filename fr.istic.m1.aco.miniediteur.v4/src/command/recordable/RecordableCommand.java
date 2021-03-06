package command.recordable;

import record.Recorder;
import Annulator.Annulator;
import command.Command;
import memento.Memento;
import memento.MementoState;

public abstract class RecordableCommand implements Command {

	protected MementoState mem;
	protected Recorder recorder;
	protected Annulator annulator;
	
	public RecordableCommand(Recorder rec,Annulator ann){
		recorder = rec;
		annulator = ann;
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