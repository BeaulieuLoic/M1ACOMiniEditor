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

public class MiniIHMStub extends JFrame implements MiniIHM, ActionListener {

	private Map<String, Command> mapCommand;

	private Button buttonCopy;
	private Button buttonCut;
	private Button buttonPaste;

	private JTextArea textArea;
	private JScrollPane scrollPane;

	private JPanel buttonPanel;

	public MiniIHMStub(Map<String, Command> mapCommand) {
		super("MiniACOEditor");
		this.mapCommand = mapCommand;

		buttonCopy = new Button("Copy");
		buttonCut = new Button("Cut");
		buttonPaste = new Button("Paste");

		buttonCopy.addActionListener(this);
		buttonCut.addActionListener(this);
		buttonPaste.addActionListener(this);

		textArea = new JTextArea();
		textArea.setBackground(Color.white);
		textArea.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (!e.isActionKey()) {
					System.out.println("insert text: " + e.getKeyChar());
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}
		});

		WindowListener l = new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		};
		addWindowListener(l);

		setSize(800, 600);

		// add button on buttonPanel
		buttonPanel = new JPanel();
		buttonPanel.add(buttonCopy);
		buttonPanel.add(buttonCut);
		buttonPanel.add(buttonPaste);

		// add element in principal panel
		this.getContentPane().add(buttonPanel, BorderLayout.NORTH);
		
		scrollPane = new JScrollPane(textArea);
		this.getContentPane().add(scrollPane, BorderLayout.CENTER);

		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == buttonCopy) {
			System.out.println("Copy");
		} else if (source == buttonCut) {
			System.out.println("Cut");
		} else if (source == buttonPaste) {
			System.out.println("Paste");
		} else {
			System.out.println("Error actionPerformed, action not defined");
		}
	}

	public String getText() {
		return "test";
	}

}