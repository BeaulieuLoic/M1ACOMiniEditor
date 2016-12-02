package invoker;

import command.Command;
/** 
 * @author Loic_Beaulieu Valentin_Duron
 * @since 1.0
 * @version 3.0
 * */
public interface MiniIHM {
	public void setCopy(Command c);

	public void setCut(Command c);

	public void setPaste(Command c);

	public void setModifSelector(Command c);

	
	public void setRemoveSelect(Command c);

	public void setInsertText(Command c);

	/**
	 * Return the start position of selection
	 * 
	 * @return The start position of selection
	 * */
	public int getSelectStart();

	/**
	 * Return the end position of selection
	 * 
	 * @return The end position of selection
	 * */
	public int getSelectEnd();

	public void setStartRecording(Command c);

	public void setStopRecording(Command c);

	public void setPlayRecording(Command c);

	public void setUndo(Command c);

	public void setRedo(Command c);

	public void launchIHM();

	/**
	 * return the string to insert into the miniEditor
	 * 
	 * @return The string to insert into the miniEditor
	 * */
	public String getText();

	/**
	 * Set the text to insert into the miniEditor. Use only for test
	 * 
	 * @param str String to set
	 * */
	public void setText(String str);

}
