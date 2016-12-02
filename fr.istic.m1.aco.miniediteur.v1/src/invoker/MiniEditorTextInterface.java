package invoker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import command.*;
import receiver.MiniEditor;

public class MiniEditorTextInterface implements MiniIHM {
	static BufferedReader keyboard = new BufferedReader(new InputStreamReader(
			System.in));

	// Direct reference to MiniEditor (for V1 only)

	private Command copy;
	private Command cut;
	private Command paste;
	private Command insert;
	private Command removeSelect;
	private Command modifSelect;

	private MiniEditor editor;

	private int startSelect;
	private int endSelect;

	private String insertText;

	public MiniEditorTextInterface(MiniEditor editor) {
		startSelect = 0;
		endSelect = 0;
		insertText = "";
		this.editor = editor;

	}

	public void launchIHM() {

		String inputLine;
		char commandLetter;

		System.out.println("Welcome to MiniEditor 9.99 (c) 2015 ISTIC Rennes");
		System.out
				.println("-----------------------------------------------------------");

		System.out.println("Enter command (I/S/C/X/V/D/R/E/P/Z/Y/Q) > ");
		try {
			inputLine = keyboard.readLine();
		} catch (IOException e) {
			System.out.println("Unable to read standard input");
			inputLine = "W";
		}
		if (inputLine.isEmpty()) {
			commandLetter = '0';
		} else {
			commandLetter = Character.toUpperCase(inputLine.charAt(0));
		}
		while (commandLetter != 'Q') /* Quit */
		{
			switch (commandLetter) {
			case '0':
				break;
			case 'I': /* Insert */
				insertText = inputLine.substring(2);
				insert.execute();
				break;
			case 'S': /* Select */
				String numberString = "";
				try {
					String[] arguments = inputLine.substring(2).split("\\s+");
					numberString = arguments[0];
					startSelect = Integer.parseInt(numberString);
					numberString = arguments[1];
					endSelect = Integer.parseInt(numberString);
					modifSelect.execute();
				} catch (Exception e) {
					System.out.println("Invalid number: " + numberString);
				}
				break;
			case 'C': /* Copy */
				copy.execute();
				break;
			case 'X': /* cut */
				cut.execute();
				break;
			case 'V': /* paste */
				paste.execute();
				break;
			case 'D': /* Delete, i.e. insert empty string */
				removeSelect.execute();
				break;
			case 'R': /* start Recording */
				// Insert your code here (V2)
				break;
			case 'E': /* End recording */
				// Insert your code here (V2)
				break;
			case 'P': /* Play recording */
				// Insert your code here (V2)
				break;
			case 'Z': /* undo */
				// Insert your code here (V3)
				break;
			case 'Y': /* redo */
				// Insert your code here (V3)
				break;
			default:
				System.out.println("Unrecognized command, please try again:");
				break;
			}
			System.out.println("-----------------------------------------------------");
			System.out.println("Buffer :[" + editor.getBuffer() + "]");
			System.out.println("-----------------------------------------------------");
			System.out.println("Selection :[" + editor.getSelection() + "]");
			System.out.println("-----------------------------------------------------");
			System.out.println("Clipboard :[" + editor.getClipboard() + "]");
			System.out.println("-----------------------------------------------------");


			System.out.println("Enter command (I/S/C/X/V/D/R/E/P/Z/Y/Q) > ");
			try {
				inputLine = keyboard.readLine();
			} catch (IOException e) {
				System.out.println("Unable to read standard input");
				inputLine = "W";
			}
			if (inputLine.isEmpty()) {
				commandLetter = '0';
			} else {
				commandLetter = Character.toUpperCase(inputLine.charAt(0));
			}
		}
		System.out.println("Goodbye");
	}

	@Override
	public void setCopy(Command c) {
		copy = c;

	}

	@Override
	public void setCut(Command c) {
		cut = c;

	}

	@Override
	public void setPaste(Command c) {
		paste = c;

	}

	@Override
	public void setModifSelector(Command c) {
		modifSelect = c;

	}

	@Override
	public void setRemoveSelect(Command c) {
		removeSelect = c;

	}

	@Override
	public void setInsertText(Command c) {
		insert = c;

	}

	@Override
	public int getSelectStart() {
		return startSelect;
	}

	@Override
	public int getSelectEnd() {
		return endSelect;
	}

	@Override
	public String getText() {

		return insertText;
	}

}
