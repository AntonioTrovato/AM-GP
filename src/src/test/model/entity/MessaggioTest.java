package test.model.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.entity.Mailbox;
import model.entity.Messaggio;
import model.entity.Utente;

class MessaggioTest {
	Messaggio m;
	Utente mittente;
	Utente destinatario;
	
	@BeforeEach
	void setUp() throws Exception {
		mittente = new Utente("AAAAAAAAAAAAAA", "balubabbalucCacC1?+", "tecnico", "Pietro", "Negri", new Mailbox());
		destinatario = new Utente("AAAAAAAAAAAAAB", "balubabbaaazlucCacC2?+", "pilota", "Charles", "LeClerc", new Mailbox());
		m = new Messaggio(1, "Oggetto Prova", "Corpo Prova", mittente, destinatario);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testMittenteNull() {
		try {
			m.setMittente(null);
			fail();
		}
		catch(IllegalArgumentException e) {
			
		}
	}
	
	@Test
	void testMittente() {
		try {
			Utente vecchioMittente = m.getMittente();
			m.setMittente(new Utente("AAAAAAAAAAAAAZ", "balubabbaaazlucCacC2?+", "pilota", "Carlos", "Sainz", new Mailbox()));
			assertNotEquals(m.getMittente(), vecchioMittente);
		}
		catch(IllegalArgumentException e) {
			fail();
		}
	}
	
	@Test
	void testDestinatario() {
		try {
			Utente vecchioDestinatario = m.getDestinatario();
			m.setDestinatario(new Utente("AAAAAAAAAAAAAZ", "balubabbaaazlucCacC2?+", "pilota", "Carlos", "Sainz", new Mailbox()));
			assertNotEquals(m.getDestinatario(), vecchioDestinatario);
		}
		catch(IllegalArgumentException e) {
			fail();
		}
	}
	
	@Test
	void testDestinatarioNull() {
		try {
			m.setDestinatario(null);
			fail();
		}
		catch(IllegalArgumentException e) {
			
		}
	}
	
	@Test
	void testOggettoNull() {
		try {
			m.setOggetto(null);
			fail();
		}
		catch(IllegalArgumentException e) {
			
		}
	}
	
	
	@Test
	void testOggettoEmpty() {
		try {
			m.setOggetto("");
			fail();
		}
		catch(IllegalArgumentException e) {
			
		}
	}
	
	
	@Test
	void testOggettoLength() {
		try {
			m.setOggetto("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
			fail();
		}
		catch(IllegalArgumentException e) {
			
		}
	}
	
	@Test
	void testCorpoNull() {
		try {
			m.setCorpo(null);
			fail();
		}
		catch(IllegalArgumentException e) {
			
		}
	}
	
	@Test
	void testCorpo() {
		String corpo = "Messaggio di prova per testare la lunghezza del corpo.";
		try {
			m.setCorpo(corpo);
			assertEquals(corpo, m.getCorpo());
		}
		catch(IllegalArgumentException e) {
			fail();
		}
	}


}
