package receiver;


/** 
 * @author Loic_Beaulieu Valentin_Duron
 * @since 1.0
 * @version 1.0
 * */
public class MiniClipboard //extends Clipboard
{


	private String clip;
	
	@Override
	public String toString() {
		return "\""+clip+"\"";
	}
	
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
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MiniClipboard other = (MiniClipboard) obj;
		if (clip == null) {
			if (other.clip != null)
				return false;
		} else if (!clip.equals(other.clip))
			return false;
		return true;
	}

}
