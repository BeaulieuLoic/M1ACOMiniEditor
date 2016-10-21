package receiver;

/**
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */

public class MiniEditorStub implements MiniEditor {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */

	public MiniBuffer buffer;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */

	public Selector selector;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */

	public MiniClipboard clipboard;
	
	
	

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public MiniEditorStub() {
		super();
		buffer = new MiniBuffer();
		clipboard = new MiniClipboard();
		selector = new Selector();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */

	public void editorCopy() {
		clipboard.setClip(buffer.copy(selector.getStart(), selector.getEnd()));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */

	public void editorCut() {
		this.editorCopy();
		buffer.delete(selector.getStart(), selector.getEnd());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */

	public void editorPaste() {
		buffer.replace(selector.getStart(), selector.getEnd(), clipboard.getClip());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */

	public void editorInsert(String str) {
		int lengthStr = str.length();
		if (selector.getStart() == selector.getEnd()) {
			buffer.insert(selector.getStart(), str);
			editorSelect(selector.getStart()+lengthStr, selector.getEnd()+lengthStr);
		}else{
			buffer.replace(selector.getStart(),selector.getEnd(), str);
			editorSelect(selector.getStart()+lengthStr, selector.getStart()+lengthStr);
		}	
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */

	public void editorSelect(int start, int end) {
		selector.setStart(start);
		selector.setEnd(end);
	}
	
	
}
