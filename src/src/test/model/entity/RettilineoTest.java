package test.model.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.entity.Rettilineo;

class RettilineoTest {
	private Rettilineo rettilineo;

	@BeforeEach
	void setUp() throws Exception {
		rettilineo= new Rettilineo(1,"rettilineo1", 400.0);
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	public void testGetID() {
		try {
			int exp= 1;
			int act= rettilineo.getId();
			assertEquals(exp,act);	
		}
			catch(IllegalArgumentException e) {}
	}
	
	@Test
	public void testGetNome() {
		try {
			String exp= "rettilineo1";
			String act= rettilineo.getNome();
			assertEquals(exp,act);	
		}
		catch(IllegalArgumentException e) {}
	}
	
	
	@Test
	public void testGetLunghezza() {
		try {
			double exp= 400.0;
			double act= rettilineo.getLunghezza();
			assertEquals(exp,act);	
		}
		catch(IllegalArgumentException e) {}
	}
	
	
	
	
	@Test
	public void testSetLunghezza() {
		try {
			rettilineo.setLunghezza(700.0);
			assertEquals(700.0,rettilineo.getLunghezza());	
		}
		catch(IllegalArgumentException e) {}
		
	}
	
	@Test
	public void testSetNome() {
		try {
			rettilineo.setNome("rettilineo2");
			assertEquals("rettilineo2",rettilineo.getNome());	
		}	
		catch(IllegalArgumentException e) {}
	}
	
	
	
	@Test
	public void testSetID() {
		try{
			rettilineo.setId(2);
			assertEquals(2,rettilineo.getId());	
		}	
		catch(IllegalArgumentException e) {}
		}
	
	
	@Test
	public void testNomeNull() {
		try{
			rettilineo.setNome(null);
			fail();
		}
		catch(IllegalArgumentException e) {}
	}


	@Test
	public void testNomeEmpty() {
		try{
			rettilineo.setNome("");
			fail();
		}
		catch(IllegalArgumentException e) {}
	}
	
	
	@Test
	public void testLunghezzaRange() {
		try{
			rettilineo.setLunghezza(-500.0);
			fail();
		}
		catch(IllegalArgumentException e) {}
	}
	
	
	
	
}
