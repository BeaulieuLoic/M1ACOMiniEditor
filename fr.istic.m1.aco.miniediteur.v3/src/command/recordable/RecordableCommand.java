package command.recordable;

import record.Recorder;
import command.Command;
import memento.Memento;
import memento.MementoState;
/** 
 * @author Loic_Beaulieu Valentin_Duron
 * @since 2.0
 * @version 3.0
 * */
public abstract class RecordableCommand implements Command {

	protected MementoState mem;
	protected Recorder recorder;
	
	public RecordableCommand(Recorder rec){
		recorder = rec;
	}

	/**
	 * Set the state of this object with the state of mem
	 * 
	 * @param mem memento to set
	 * */
	public void setMemento(Memento mem) {
		this.mem = mem.getState();
	}

	/**
	 * 
	 * @return the memento created by the command
	 */
	public abstract Memento createMemento();
	
	/**
	 * @param mem attributes for some commands
	 */
	public abstract void executeRecord(MementoState mem);

	/**
	 * Equals, usefull for testing.
	 */
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