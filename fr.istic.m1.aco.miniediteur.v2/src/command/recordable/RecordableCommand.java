package command.recordable;

import command.Command;

import memento.Memento;
import memento.MementoState;

public abstract class RecordableCommand implements Command, Memento {

	protected MementoState mem;
	
	@Override
	public void setMemento(MementoState mem){
		this.mem=mem;
	}

	public abstract void executeRecord(MementoState mem);
	
}