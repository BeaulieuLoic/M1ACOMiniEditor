package receiver;


/**
 * <!-- begin-user-doc -->
 * <!--  end-user-doc  -->
 * @generated
 */

public class MiniClipboard //extends Clipboard
{

	private String clip;
	
	@Override
	public String toString() {
		return "\""+clip+"\"";
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!--  end-user-doc  -->
	 * @generated
	 */
	public MiniClipboard(){
		super();
		clip="";
	}
	
	public String getClip() {
		return clip;
	}
	public void setClip(String clip) {
		this.clip = clip;
	}

}
