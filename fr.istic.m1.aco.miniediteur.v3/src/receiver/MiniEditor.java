package receiver;

import receiver.exception.RedoException;
import receiver.exception.UndoException;

/** 
 * @author Loic_Beaulieu Valentin_Duron
 * @since 1.0
 * @version 3.0
 * */
public interface MiniEditor {
	
	
	/**
	 * Put the current selection into the clipboard
	 * */
	public void editorCopy();

	
	/**
	 * Put the current selection into the clipboard and remove from the buffer
	 * */
	public void editorCut();

	/**
	 * Insert a String into the selection
	 * 
	 * @param str The string to insert
	 * */
	public void editorInsert(String str);

	/**
	 * Remove String in the current selection
	 * */
	public void editorRemove();

	/**
	 * Paste into the selection the clipboard
	 * */
	public void editorPaste();

	/**
	 * Move the selection
	 * 
	 * @param start The start of new selection
	 * @param end The end of new selection
	 * */
	public void editorSelect(int start, int end);

	/**
	 * Return the String contained into the buffer
	 * 
	 * @return The String contained into the buffer
	 * */
	public String getBuffer();

	/**
	 * Return the String contained into the clipboard
	 * 
	 * @return The String contained into the clipboard
	 * */
	public String getClipboard();

	/**
	 * Return the string of current selection
	 * 
	 * @return The string of current selection
	 * */
	public String getSelection();

	
	/**
	 * Return current position of start selection
	 * 
	 * @return Current position of start selection
	 * */
	public int getStart();

	/**
	 * Return current position of end selection
	 * 
	 * @return Current position of end selection
	 * */
	public int getEnd();

	/**
	 * Switch current state with previous state.
	 * 
	 * @throws UndoException Throw if previous state doesn't exist
	 * */
	public void undo() throws UndoException;

	/**
	 * Switch current state with next state. 
	 *
	 * @throws RedoException Throw if next state doesn't exist
	 * */
	public void redo() throws RedoException;
	
	/**
	 * Create a new state of the miniEditor
	 * */
	public void newState();
	
}
