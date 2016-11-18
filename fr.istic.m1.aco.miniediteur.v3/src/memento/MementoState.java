package memento;

public class MementoState{



	private int selStart;
	private int selEnd;
	private String buf;
	
	public MementoState(int s,int e,String b){
		selStart=s;
		selEnd=e;
		buf=b;
	}

	public int getSelStart() {
		return selStart;
	}



	public int getSelEnd() {
		return selEnd;
	}



	public String getBuf() {
		return buf;
	}
}
