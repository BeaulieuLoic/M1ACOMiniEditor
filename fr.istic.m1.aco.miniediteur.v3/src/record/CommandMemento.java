package record;

import command.recordable.RecordableCommand;
import memento.Memento;
import memento.MementoSave;


/**
 * Class for associate a command with one of its memento
 * 
 * 
 * @author Loic_Beaulieu Valentin_Duron
 * @since 2.0
 * @version 2.0
 * */
public class CommandMemento {
	
	/**
	 * 
	 * the recordable command associate with its MementoSave (Caretaker)
	 * 
	 * */
	private RecordableCommand command;
	
	/**
	 * 
	 * the MementoSave associate with its RecordableCommand (Originator)
	 * 
	 * */
	private MementoSave save;
	
	public CommandMemento(RecordableCommand c,MementoSave m){
		this.command=c;
		this.save=m;
	}
	
	/**
	 * return the recordable command
	 * 
	 * @return a recordable command
	 * 
	 * */
	public RecordableCommand getCommand(){
		return command;
	}
	
	
	/**
	 * return a memento of the recordable command
	 * 
	 * @return memento of a recordable command
	 * 
	 * */
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
