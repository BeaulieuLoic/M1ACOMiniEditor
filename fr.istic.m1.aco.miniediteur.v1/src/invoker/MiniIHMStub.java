package invoker;

import java.util.Map;
import java.awt.event.*;

import javax.swing.JFrame;

import command.Command;

public class MiniIHMStub extends JFrame implements MiniIHM {

	
	
	
	private Map<Integer, Command> mapCommand;
	
	
	
	public MiniIHMStub(Map mapCommand) {
		super("MiniACOEditor");

		this.mapCommand=mapCommand;
		
		
		WindowListener l = new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		};
		addWindowListener(l);
		setSize(200, 100);
		setVisible(true);

	}

 	
	public String getText(){
		return "test";
	}
	
}