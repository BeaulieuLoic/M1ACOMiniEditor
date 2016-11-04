package memento;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import command.Command;

public class Recording {
	private Map<Command,Memento> listCommand;
	
	
	public Recording(){
		listCommand = new HashMap<>();
	}
	
	public void recordComand(Command c){
		listCommand.put(c, c.getMemento());
	}
}
