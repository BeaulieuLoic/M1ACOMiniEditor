package client;

import java.util.HashMap;
import java.util.Map;

import command.Command;
import invoker.MiniIHM;
import invoker.MiniIHMStub;

public class ConfiguratorStub {

	/* ajouter tout les attributs et faire l'instanciation du tout
	
	-MiniIHM
	-MiniEditor
	-Command : paste,Ins,Cut,Copy
	*/
	
	
	public static void main(String[] args) {
		Map<String, Command> mapCommand = new HashMap<>();
		
		
		MiniIHM frame = new MiniIHMStub(mapCommand);
	}
	
}
