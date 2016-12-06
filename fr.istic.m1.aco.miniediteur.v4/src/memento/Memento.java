package memento;

public class Memento {

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Memento other = (Memento) obj;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		return true;
	}

	private MementoState state;
	
	public Memento(MementoState s){
		state = s;
	}

	public MementoState getState() {
		return state;
	}

	public void setState(MementoState state) {
		this.state = state;
	}
	
	
}
