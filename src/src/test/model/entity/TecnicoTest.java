package test.model.entity;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.entity.Circuito;
import model.entity.Mailbox;
import model.entity.Setup;
import model.entity.Tecnico;

class TecnicoTest {
	private Tecnico tecnico;
	private Mailbox mailbox;
	private Collection<Setup> setupList;

	@BeforeEach
	void setUp() throws Exception {
		mailbox = new Mailbox();
		tecnico = new Tecnico("Aswertsf5rters","password3@W","tecnico","Antonio","Trovato",mailbox);
		setupList = new ArrayList<Setup>();
		setupList.add(new Setup(1,5.3,5.2,1.5,1.3,0.6,0.3,50,5.5,5.8,tecnico,new Circuito(),"10-10-2021"));
		setupList.add(new Setup(2,5.3,5.4,1.2,1.3,0.3,0.2,51,5.7,5.3,tecnico,new Circuito(),"10-11-2021"));
		setupList.add(new Setup(3,5.5,5.9,1.3,1.5,0.3,0.3,52,5.6,5.2,tecnico,new Circuito(),"10-12-2021"));
		setupList.add(new Setup(4,5.5,5.8,1.4,1.5,0.4,0.4,53,5.6,5.1,tecnico,new Circuito(),"10-1-2021"));
		setupList.add(new Setup(5,5.6,5.6,1.5,1.7,0.5,0.5,54,5.4,5.2,tecnico,new Circuito(),"10-2-2021"));
		tecnico.setSetupList(setupList);
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	public void testGetSetupList() {
		try {
			Collection<Setup> exp = setupList;
			Collection<Setup> act= tecnico.getSetupList();
			assertEquals(exp,act);	
		}
		catch(IllegalArgumentException e) {}
	}
	
	@Test
	public void testSetSetupList() {
		try {
			Collection<Setup> setupList2 = new ArrayList<Setup>();
			setupList2.add(new Setup(1,5.3,5.2,1.5,1.3,0.6,0.3,50,5.5,5.8,tecnico,new Circuito(),"10-10-2021"));
			setupList2.add(new Setup(2,5.3,5.4,1.2,1.3,0.3,0.2,51,5.7,5.3,tecnico,new Circuito(),"10-11-2021"));
			tecnico.setSetupList(setupList2);
			assertEquals(setupList2,tecnico.getSetupList());
			tecnico.setSetupList(setupList);//ritorniamo alla situazione di partenza
		}	
		catch(IllegalArgumentException e) {}
	}
	
	@Test
	public void testSetupListNull() {
		try{
			tecnico.setSetupList(null);
			tecnico.setSetupList(setupList);
			fail();
		}
		catch(IllegalArgumentException e) {}
	}
	
	@Test
	public void testAddSetup() {
		try {
			Setup setupToAdd = new Setup(2,5.3,5.4,1.2,1.3,0.3,0.2,51,5.7,5.3,tecnico,new Circuito(),"10-11-2021");
			tecnico.addSetup(setupToAdd);
			assertEquals(true,tecnico.getSetupList().contains(setupToAdd));
		}	
		catch(IllegalArgumentException e) {}
	}
	
	@Test
	public void testAddSetupNull() {
		try{
			tecnico.addSetup(null);
			fail();
		}
		catch(IllegalArgumentException e) {}
	}
	
	@Test
	public void testRemoveSetup() {
		try {
			Setup setupToRemove = new Setup(1,5.3,5.2,1.5,1.3,0.6,0.3,50,5.5,5.8,tecnico,new Circuito(),"10-10-2021");
			tecnico.removeSetup(setupToRemove);
			assertEquals(false,tecnico.getSetupList().contains(setupToRemove));
		}	
		catch(IllegalArgumentException e) {}
	}
	
	@Test
	public void testRemoveSetupNull() {
		try{
			tecnico.removeSetup(null);
			fail();
		}
		catch(IllegalArgumentException e) {}
	}

}
