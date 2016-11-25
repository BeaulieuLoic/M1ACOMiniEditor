package command;

import command.recordable.RecordableCommand;
import memento.MementoState;

public class CommandMemento {
	


	private RecordableCommand command;
	private MementoState mem;
	
	public CommandMemento(RecordableCommand c,MementoState m){
		this.command=c;
		this.mem=m;
	}
	
	public RecordableCommand getCommand(){
		return command;
	}
	
	public MementoState getMemento(){
		return mem;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CommandMemento other = (CommandMemento) obj;
		if (command == null) {
			if (other.command != null)
				return false;
		} else if (!command.equals(other.command))
			return false;
		if (mem == null) {
			if (other.mem != null)
				return false;
		} else if (!mem.equals(other.mem))
			return false;
		return true;
	}
}
