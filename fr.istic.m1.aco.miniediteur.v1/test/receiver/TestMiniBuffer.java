package receiver;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMiniBuffer {

	MiniBuffer buf;

	@Test
	public void testMiniBuffer() {
		buf = new MiniBuffer();

		assertNotNull(buf);
		assertNotNull(buf.getBuffer());
	}

	@Test
	public void testDelete() {
		buf = new MiniBuffer();
		String str = "TestString";
		buf.insert(0, str);
		buf.delete(3, 5);

		MiniBuffer bufResult = new MiniBuffer();
		bufResult.getBuffer().insert(0, str);
		bufResult.getBuffer().delete(3, 5);

		assertEquals(buf, bufResult);
	}

	@Test
	public void testCopy() {
		buf = new MiniBuffer();
		String str = "TestString";
		buf.insert(0, str);
		buf.copy(3, 5);

		MiniBuffer bufResult = new MiniBuffer();
		bufResult.getBuffer().insert(0, str);

		assertEquals(buf.copy(3, 5), (bufResult.getBuffer().substring(3, 5)));
	}

	@Test
	public void testInsert() {
		buf = new MiniBuffer();
		String str = "TestString";
		buf.insert(0, str);

		MiniBuffer bufResult = new MiniBuffer();
		bufResult.getBuffer().insert(0, str);

		assertEquals(buf, bufResult);
	}

	@Test
	public void testReplace() {
		buf = new MiniBuffer();
		String str = "TestString";
		buf.insert(0, str);

		buf.replace(3, 5, "AA");

		MiniBuffer bufResult = new MiniBuffer();
		bufResult.getBuffer().insert(0, str);
		bufResult.getBuffer().replace(3, 5, "AA");

		assertEquals(buf, bufResult);
	}

	@Test
	public void testGetSize() {
		buf = new MiniBuffer();
		String str = "TestString";
		buf.insert(0, str);

		MiniBuffer bufResult = new MiniBuffer();
		bufResult.getBuffer().insert(0, str);

		assertEquals(buf.getSize(), bufResult.getBuffer().length());
	}

}
