package record;

import java.util.ArrayList;
import java.util.List;
import memento.MementoSave;
import command.recordable.RecordableCommand;


/** 
 * Class for add and play a list of recordable command
 * 
 * @author Loic_Beaulieu Valentin_Duron
 * @since 2.0
 * @version 2.0
 * */
public class Recorder {
	
	/**
	 * 
	 * when its true, the method add(c) add the recordable command into listCommand
	 * 
	 * */
	private boolean isRecording;
	
	/**
	 * contain a list of tuple (recordableCommand, MementoSave)
	 * */
	private List<CommandMemento> listCommand;

	public Recorder() {
		listCommand = new ArrayList<>();
		isRecording = false;
	}

	
	/**
	 * 
	 * Add a recordable command with its actual memento
	 * 
	 * @param c
	 * 			recordable command to add
	 * */
	public void add(RecordableCommand c) {
		if (isRecording) {
			listCommand.add(new CommandMemento(c, new MementoSave(c.createMemento())));
		}
	}

	/**
	 * Start the recording
	 * */
	public void startRecord() {
		listCommand = new ArrayList<>();
		isRecording = true;
	}

	/**
	 * Stop the recording
	 * */
	public void stopRecord() {
		isRecording = false;
	}

	/**
	 * Call method executeRecord for each RecordableCommand with its saved memento
	 * */
	public void playRecord() {
		for (CommandMemento commandMemento : listCommand) {
			commandMemento.getCommand().executeRecord(commandMemento.getMemento().getState());
		}
	}

	/**
	 * use only for test
	 * */
	protected List<CommandMemento> getListCommand() {
		return listCommand;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Recorder other = (Recorder) obj;
		if (isRecording != other.isRecording)
			return false;
		if (listCommand == null) {
			if (other.listCommand != null)
				return false;
		} else if (!listCommand.equals(other.listCommand))
			return false;
		return true;
	}
}
