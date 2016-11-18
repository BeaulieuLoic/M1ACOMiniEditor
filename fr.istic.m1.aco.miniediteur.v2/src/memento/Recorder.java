package memento;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import command.Command;
import command.CommandMemento;
import command.recordable.RecordableCommand;

public class Recorder {

	private String nom;
	private boolean isRecording;
	private List<CommandMemento> listCommand;

	public Recorder() {
		listCommand = new ArrayList<>();
		nom = "";
		isRecording = false;
	}

	public void add(RecordableCommand c) {
		if (isRecording) {
			listCommand.add(new CommandMemento(c, c.getMemento()));
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
			commandMemento.getCommand().executeRecord(
					commandMemento.getMemento());
		}
	}
}
