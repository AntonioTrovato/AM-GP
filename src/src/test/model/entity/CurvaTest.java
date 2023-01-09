package test.model.entity;



import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import junit.framework.TestCase;
import model.entity.Curva;

class CurvaTest extends TestCase{
	private Curva curva;

	@BeforeEach
	protected void setUp() throws Exception {
		curva = new Curva(1,"curva1", 30.0f);
	}

	@AfterEach
	protected void tearDown() throws Exception {
	}

	
	@Test
	public void testGetID() {
		try {
			int exp= 1;
			int act= curva.getId();
			assertEquals(exp,act);	
		}
			catch(IllegalArgumentException e) {}
	}
	
	@Test
	public void testGetNome() {
		try {
			String exp= "curva1";
			String act= curva.getNome();
			assertEquals(exp,act);	
		}
		catch(IllegalArgumentException e) {}
	}
	
	
	@Test
	public void testGetAngolo() {
		try {
			Float exp= 30.0f;
			Float act= curva.getAngolo();
			assertEquals(exp,act);	
		}
		catch(IllegalArgumentException e) {}
	}
	
	
	
	@Test
	public void testSetAngolo() {
		try {
			curva.setAngolo(23.0f);
			assertEquals(23.0f,curva.getAngolo());	
		}
		catch(IllegalArgumentException e) {}
		
	}
	
	@Test
	public void testSetNome() {
		try {
			curva.setNome("curva2");
			assertEquals("curva2",curva.getNome());	
		}	
		catch(IllegalArgumentException e) {}
	}
	
	
	
	@Test
	public void testSetID() {
		try{
			curva.setId(2);
			assertEquals(2,curva.getId());	
	}		
	catch(IllegalArgumentException e) {}
	}

	
	@Test
	public void testNomeNull() {
		try{
			curva.setNome(null);
			fail();
		}
		catch(IllegalArgumentException e) {}
	}


	@Test
	public void testNomeEmpty() {
		try{
			curva.setNome("");
			fail();
		}
		catch(IllegalArgumentException e) {}
	}
	
	
	@Test
	public void testAngoloRange() {
		try{
			curva.setAngolo(-50.0f);
			fail();
		}
		catch(IllegalArgumentException e) {}
	}
	

}
