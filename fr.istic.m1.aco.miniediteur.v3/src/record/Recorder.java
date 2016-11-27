package record;

import java.util.ArrayList;
import java.util.List;
import memento.MementoSave;
import command.recordable.RecordableCommand;

public class Recorder {
	private boolean isRecording;
	private List<CommandMemento> listCommand;

	public Recorder() {
		listCommand = new ArrayList<>();
		isRecording = false;
	}

	public void add(RecordableCommand c) {
		if (isRecording) {
			listCommand.add(new CommandMemento(c, new MementoSave(c.createMemento())));
		}
	}

	public void startRecord() {
		listCommand = new ArrayList<>();
		isRecording = true;
	}

	public void stopRecord() {
		isRecording = false;
	}

	public void playRecord() {
		for (CommandMemento commandMemento : listCommand) {
			commandMemento.getCommand().executeRecord(commandMemento.getMemento().getState());
		}
	}

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
