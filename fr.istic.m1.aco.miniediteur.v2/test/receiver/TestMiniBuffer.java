package receiver;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMiniBuffer {

	MiniBuffer buf;

	@Test
	public void testMiniBuffer() {
		buf = new MiniBuffer();

		assertTrue(buf != null && buf.getBuffer() != null);
	}

	@Test
	public void testDelete() {
		buf = new MiniBuffer();
		String str = "TestString";
		buf.insert(0,str);		
		buf.delete(3,5);
		assertTrue(buf.toString().equals("Testring"));
		
	}

	@Test
	public void testCopy() {
		buf = new MiniBuffer();
		String str = "TestString";
		buf.insert(0,str);	
		buf.copy(3,5);
		assertTrue(buf.copy(3,5).equals("tS"));
	}

	@Test
	public void testInsert() {
		buf = new MiniBuffer();
		String str = "TestString";
		buf.insert(0,str);		
		assertTrue(buf.toString().equals(str));
	}

	@Test
	public void testReplace() {
		buf = new MiniBuffer();
		String str = "TestString";
		buf.insert(0,str);
		
		buf.replace(3,5,"AA");
		assertTrue(buf.toString().equals("TesAAtring"));
	}
	
	@Test
	public void testGetBuffer(){
		buf = new MiniBuffer();
		String str = "TestString";
		buf.insert(0, str);
		
		assertTrue(buf.getBuffer().toString().equals(str));
	}
	
	@Test
	public void testGetSize(){
		buf = new MiniBuffer();
		String str = "TestString";
		buf.insert(0, str);
		assertTrue(buf.getSize()==str.length());
	}

}
