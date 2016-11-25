package receiver;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMiniState {
	private MiniState state;

	private MiniBuffer buf;
	private Selector sel;

	@Test
	public void testAddNext() {
		buf = new MiniBuffer();
		sel = new Selector();
		state = new MiniState(buf, sel);

		MiniBuffer bufTest = new MiniBuffer();
		Selector selTest = new Selector();
		state.addNext(bufTest,selTest);
		MiniState nextState = state.getNext();
		
		assertTrue(state.equals(nextState.getPre()));
	}
}
