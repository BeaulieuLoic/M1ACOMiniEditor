package receiver;

/**
 * Selector represent the selection 
 * 
 * @author Loic_Beaulieu Valentin_Duron
 * @since 1.0
 * @version 1.0
 * */
public class Selector {

	@Override
	public String toString() {
		return "Selector [start=" + start + ", end=" + end + "]";
	}

	/**
	 * 
	 * position of the start of the selection
	 * 
	 * */
	private int start;

	/**
	 * 
	 * position of the end of the selection
	 * 
	 * */
	private int end;

	public Selector() {
		super();
		start = 0;
		end = 0;
	}

	public Selector(int s, int e) {
		super();
		start = s;
		end = e;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *  return the start position of the cursor
	 * 
	 * 
	 * @return return the start position of the cursor
	 */
	public int getStart() {
		return start;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * Define the start of the position of the selector
	 * 
	 * 
	 * @param start position
	 * */
	public void setStart(int start) {
		this.start = start;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *  return the end position of the cursor
	 * 
	 * 
	 * @return return the end position of the cursor
	 */
	public int getEnd() {
		return end;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * Define the end of the position of the selector
	 * 
	 * 
	 * @param end position
	 * */
	public void setEnd(int end) {
		this.end = end;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Selector other = (Selector) obj;
		if (end != other.end)
			return false;
		if (start != other.start)
			return false;
		return true;
	}

}
