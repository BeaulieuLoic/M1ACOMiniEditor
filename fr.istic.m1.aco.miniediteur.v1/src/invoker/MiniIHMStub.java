package invoker;

import java.util.Map;

import javax.swing.text.AttributeSet;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

import command.Command;

public class MiniIHMStub extends JFrame implements MiniIHM, ActionListener {

	private Map<String, Command> mapCommand;

	private Button buttonCopy;
	private Button buttonCut;
	private Button buttonPaste;

	private JTextArea textArea;
	private JScrollPane scrollPane;

	private JPanel buttonPanel;

	private Command copy;
	private Command cut;
	private Command paste;
	private Command insertText;
	private Command modifSelector;
	private Command removeSelect;

	private String strInsert = "";

	private boolean commande = false;

	public MiniIHMStub() {
		super("MiniACOEditor");

		// button
		buttonCopy = new Button("Copy");
		buttonCut = new Button("Cut");
		buttonPaste = new Button("Paste");

		buttonCopy.addActionListener(this);
		buttonCut.addActionListener(this);
		buttonPaste.addActionListener(this);

		// textArea
		textArea = new JTextArea();

		// insert text

		((AbstractDocument) textArea.getDocument())
				.setDocumentFilter(new DocumentFilter() {
					@Override
					public void replace(DocumentFilter.FilterBypass fb,
							int offset, int length, String text,
							AttributeSet attrs) throws BadLocationException {
						if (!commande) {
							strInsert = text;
							insertText.execute();
							super.replace(fb, offset, length, text, attrs);
						} else {
							commande = false;
							super.replace(fb, offset, length, text, attrs);
						}

					}

					@Override
					public void insertString(DocumentFilter.FilterBypass fb,
							int offset, String text, AttributeSet attr)
							throws BadLocationException {
						super.insertString(fb, offset, text, attr);
					}

					@Override
					public void remove(DocumentFilter.FilterBypass fb,
							int offset, int length) throws BadLocationException {
						if (!commande) {
							removeSelect.execute();
							super.remove(fb, offset, length);
						} else {
							commande = false;
							super.remove(fb, offset, length);
						}
					}
				});

		textArea.addCaretListener(new CaretListener() {
			@Override
			public void caretUpdate(CaretEvent e) {
				modifSelector.execute();
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
			commande = true;
			copy.execute();

		} else if (source == buttonCut) {
			System.out.println("Cut");
			if (textArea.getSelectionStart() != textArea.getSelectionEnd()) {
				commande = true;
				cut.execute();
				textArea.setText(textArea.getText().replace(
						textArea.getSelectedText(), ""));
			}
		} else if (source == buttonPaste) {
			System.out.println("Paste");
			commande = true;
			paste.execute();
		} else {
			System.out.println("Error actionPerformed, action not defined");
		}
	}

	public void setCopy(Command c) {
		copy = c;
	}

	public void setCut(Command c) {
		cut = c;
	}

	public void setPaste(Command c) {
		paste = c;
	}

	public void setInsertText(Command c) {
		insertText = c;
	}

	public void setModifSelector(Command c) {
		modifSelector = c;
	}

	public void setRemoveSelect(Command c) {
		removeSelect = c;
	}

	public int getSelectStart() {
		return textArea.getSelectionStart();
	}

	public int getSelectEnd() {
		return textArea.getSelectionEnd();
	}

	public String getText() {
		return strInsert;
	}

	@Override
	public void launchIHM() {
		// TODO Auto-generated method stub
		
	}

}