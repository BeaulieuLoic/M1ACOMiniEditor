package Annulator;

import java.util.ArrayList;
import java.util.List;

import Annulator.exception.RedoException;
import Annulator.exception.UndoException;
import memento.MementoSave;
import record.CommandMemento;
import command.recordable.RecordableCommand;

public class Annulator {
	private int stateIndex;
	private int maxIndex;
	private List<CommandMemento> listCommand;

	public Annulator() {
		stateIndex = 0;
		maxIndex = 0;
		listCommand = new ArrayList<>();
	}

	public void add(RecordableCommand c) {

		listCommand.add(stateIndex, new CommandMemento(c, new MementoSave(c.createMemento())));
		stateIndex++;
		maxIndex++;

		if (stateIndex != maxIndex) {
			maxIndex = stateIndex;
			System.out.println("Suppr de " + (stateIndex+1) + " " + (listCommand.size()-1));
			listCommand.subList(stateIndex, listCommand.size()).clear();
		}

		//System.out.println("State index : " + stateIndex);
		//System.out.println("Max index : " + maxIndex);
		//System.out.println(listCommand + " " + listCommand.size());
	}

	public void undo() throws UndoException {
		if (stateIndex > 0) {
			stateIndex--;
			for (int i = 0; i < stateIndex; i++) {
				CommandMemento commandMemento = listCommand.get(i);
				commandMemento.getCommand().executeRecord(commandMemento.getMemento().getState());
			}
		} else {
			throw new UndoException("No previous state");
		}

		//System.out.println("State index : " + stateIndex);
		//System.out.println("Max index : " + maxIndex);
		//System.out.println(listCommand + " " + listCommand.size());
	}

	public void redo() throws RedoException {

		try {
			if (stateIndex < maxIndex) {
				CommandMemento commandMemento = listCommand.get(stateIndex);
				commandMemento.getCommand().executeRecord(commandMemento.getMemento().getState());
				stateIndex++;
			}else {
				throw new RedoException("No next state");
			}
		} catch (Exception e) {
			throw new RedoException("No next state");
		}
		System.out.println("State index : " + stateIndex);
		System.out.println("Max index : " + maxIndex);
		System.out.println(listCommand + " " + listCommand.size());
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
		Annulator other = (Annulator) obj;
		if (listCommand == null) {
			if (other.listCommand != null)
				return false;
		} else if (!listCommand.equals(other.listCommand))
			return false;
		return true;
	}
}
