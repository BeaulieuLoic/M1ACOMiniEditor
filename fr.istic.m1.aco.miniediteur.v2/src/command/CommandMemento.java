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
}
