package memento;

public interface Memento<T> {
	public T getMemento();
	public void setMemento(T s);
}
