package test.model.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.dao.MessaggioDAO;
import model.dao.PilotaDAO;
import model.dao.UtenteDAO;
import model.entity.Messaggio;
import model.entity.Pilota;
import model.entity.Utente;

class MessaggioDAOTest {
	private Messaggio messaggio;
	private Messaggio messaggio2;
	private Utente mittente;
	private Utente destinatario;

	@BeforeEach
	void setUp() throws Exception {
		mittente = UtenteDAO.doRetrieveByKey("AAAAAAAAAAAAAA");
		destinatario = UtenteDAO.doRetrieveByKey("AAAAAAAAAAAAAB");
		messaggio = new Messaggio(1,"Oggetto","Corpo",mittente,destinatario);
		messaggio2 = new Messaggio();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testDoSave() {
		try {
			MessaggioDAO.doSave(messaggio);
		} catch (SQLException e) {
			fail();
		}
		
	}
	
	@Test
	void testDoSaveError() {
		try {
			MessaggioDAO.doSave(messaggio2);
			fail();
		} catch (Exception e) {
		}
		
	}

	@Test
	void testDoRetrieveByKey() {
		try {
			messaggio2 = MessaggioDAO.doRetrieveByKey(7);
			assertEquals(messaggio2.getId(), 7);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	void testDoRetrieveByKeyError() {
		try {
			messaggio2 = MessaggioDAO.doRetrieveByKey(-1);
			assertNotEquals(messaggio2.getId(), -1);
		} catch (SQLException e) {
			fail();
		}
		
	}
	
	@Test
	void testDoRetrieveAllBySender() {
		try {
			messaggio.setId(7);
			ArrayList<Messaggio> messaggi = MessaggioDAO.doRetrieveAllBySender(mittente);
			assertEquals(messaggi.contains(messaggio),true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	void testDoRetrieveAllByReceiver() {
		try {
			messaggio.setId(7);
			ArrayList<Messaggio> messaggi = MessaggioDAO.doRetrieveAllByReceiver(destinatario);
			assertEquals(messaggi.contains(messaggio),true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
