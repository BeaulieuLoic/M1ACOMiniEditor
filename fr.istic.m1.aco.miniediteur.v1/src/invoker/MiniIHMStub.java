package invoker;

import java.util.Map;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;




import command.Command;

public class MiniIHMStub extends JFrame implements MiniIHM {

	
	
	
	private Map<String, Command> mapCommand;
	
	private Button buttonCopy;
	private Button buttonCut;
	private Button buttonPaste;
	
	private JTextArea textArea;
	private JScrollPane scrollPane;
	
	private JPanel buttonPanel;
	
	public MiniIHMStub(Map<String, Command> mapCommand) {
		super("MiniACOEditor");
		this.mapCommand=mapCommand;
		
		buttonCopy = new Button("Copy");
		buttonCut = new Button("Cut");
		buttonPaste = new Button("Paste");
		
		textArea = new JTextArea();
		textArea.setBackground(new Color(255,255,255));
		scrollPane = new JScrollPane(textArea); 
		
		buttonPanel = new JPanel();
		
		
		WindowListener l = new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		};
		addWindowListener(l);
		setSize(800, 600);
		
		
		//add button on buttonPanel
		buttonPanel.add(buttonCopy);
		buttonPanel.add(buttonCut);
		buttonPanel.add(buttonPaste);
		
		
		//add element in principal panel
		this.getContentPane().add(buttonPanel,BorderLayout.NORTH);
		this.getContentPane().add(scrollPane,BorderLayout.CENTER);
				
		
		
		
		setVisible(true);
	}

 	
	public String getText(){
		return "test";
	}
	
}