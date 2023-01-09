package test.model.entity;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.entity.Mailbox;
import model.entity.Messaggio;
import model.entity.Utente;

public class MailboxTest {
	Mailbox m;

	@BeforeEach
	void setUp() throws Exception {
		ArrayList<Messaggio> ricevuti = new ArrayList<Messaggio>();
		ArrayList<Messaggio> inviati = new ArrayList<Messaggio>();
		m = new Mailbox(ricevuti, inviati);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testSetMessaggiInviati() {
		ArrayList<Messaggio> newInviati = new ArrayList<Messaggio>();
		newInviati.add(new Messaggio(1, "oggettoProva", "corpoProva", new Utente(), new Utente()));
		m.setMessaggiInviati(newInviati);
		assertNotEquals(m.getMessaggiInviati(), null);
	}
	
	@Test
	void testSetMessaggiInviatiException() {
		try {
			m.setMessaggiInviati(null);
			fail();
		}
	    catch(IllegalArgumentException e){
	    }	
	}
	
	@Test
	void testSetMessaggiRicevuti() {
		ArrayList<Messaggio> newRicevuti = new ArrayList<Messaggio>();
		newRicevuti.add(new Messaggio(1, "oggettoProva", "corpoProva", new Utente(), new Utente()));
		m.setMessaggiInviati(newRicevuti);
		assertNotEquals(m.getMessaggiInviati(), null);
	}
	
	@Test
	void testSetMessaggiRicevutiException() {
		try {
			m.setMessaggiRicevuti(null);
			fail();
		}
	    catch(IllegalArgumentException e){
	    }	
	}
	

}
