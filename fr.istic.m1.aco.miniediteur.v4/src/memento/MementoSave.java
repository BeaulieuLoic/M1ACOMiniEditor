package memento;

public class MementoSave {
	
	private Memento memento;

	public Memento getMemento() {
		return memento;
	}

	public void setMemento(Memento mem) {
		this.memento = mem;
	}

	public MementoSave(Memento memento) {
		super();
		this.memento = memento;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MementoSave other = (MementoSave) obj;
		if (memento == null) {
			if (other.memento != null)
				return false;
		} else if (!memento.equals(other.memento))
			return false;
		return true;
	}

}
