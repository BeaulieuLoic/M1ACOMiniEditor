package invoker;

import java.awt.event.*;
import javax.swing.JFrame;

public class MiniIHMStub extends JFrame implements MiniIHM {

	public MiniIHMStub() {
		super("MiniACOEditor");

		WindowListener l = new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		};
		addWindowListener(l);
		setSize(200, 100);
		setVisible(true);

	}
	
	public static void main(String[] args) {
		JFrame frame = new MiniIHMStub();
	}

	
	public String getText(){
		return "test";
	}
	
}
