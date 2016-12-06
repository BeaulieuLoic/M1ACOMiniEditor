package invoker;

import command.Command;

public interface MiniIHM {
	public void setCopy(Command c);

	public void setCut(Command c);

	public void setPaste(Command c);

	public void setModifSelector(Command c);

	public void setRemoveSelect(Command c);

	public void setInsertText(Command c);

	public int getSelectStart();

	public int getSelectEnd();

	public void setStartRecording(Command c);

	public void setStopRecording(Command c);

	public void setPlayRecording(Command c);
	
	public void launchIHM();
	
	public String getText();

	public void setText(String str);

}
