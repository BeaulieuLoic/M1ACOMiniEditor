package record;

import command.recordable.RecordableCommand;
import memento.Memento;
import memento.MementoSave;
import memento.MementoState;

public class CommandMemento {
	


	private RecordableCommand command;
	private MementoSave save;
	
	public CommandMemento(RecordableCommand c,MementoSave m){
		this.command=c;
		this.save=m;
	}
	
	public RecordableCommand getCommand(){
		return command;
	}
	
	public Memento getMemento(){
		return save.getMemento();
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
		if (save == null) {
			if (other.save != null)
				return false;
		} else if (!save.equals(other.save))
			return false;
		return true;
	}
}
