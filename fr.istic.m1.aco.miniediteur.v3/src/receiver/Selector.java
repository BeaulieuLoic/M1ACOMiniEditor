package receiver;

/** 
 * @author Loic_Beaulieu Valentin_Duron
 * 
 * */
public class Selector {

	@Override
	public String toString() {
		return "Selector [start=" + start + ", end=" + end + "]";
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */

	private int start;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */

	private int end;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
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
	 * 
	 * @generated
	 * @ordered
	 */

	public int getStart() {
		return start;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */

	public void setStart(int start) {
		this.start = start;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */

	public int getEnd() {
		return end;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */

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
