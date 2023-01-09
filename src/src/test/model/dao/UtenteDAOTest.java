package test.model.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.Collection;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.dao.UtenteDAO;
import model.entity.Mailbox;
import model.entity.Tecnico;
import model.entity.Utente;

class UtenteDAOTest {
	Utente u1;
	Utente u2;
	Collection<Utente> utenti;
	Collection<Tecnico> tecnici;
	
	@BeforeEach
	void setUp() throws Exception {
		u1 = new Utente("AAAAAAAAAAAAAA", "passwordProva1?+", "tecnico", "Pietro", "Negri",
				new Mailbox());
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testMatch() {
		try {
			assertEquals(UtenteDAO.match("AAAAAAAAAAAAAA"), true);
		} catch (SQLException e) {
			fail();
		}
	}
	@Test
	void testMatchNull() {
		try {
			assertEquals(UtenteDAO.match("AAAAAAAAAAAAAP"), false);
		}
		catch(SQLException e) {
			fail();
		}
	}
	@Test
	void testDoValidate() {
			try {
				assertEquals(UtenteDAO.doValidate(u1.getId(), u1.getPassword()), true);
			} catch (SQLException e) {
				fail();
			}
	}
	@Test
	void testDoValidateNull() {
		try {
			assertEquals(UtenteDAO.doValidate(u1.getId(), "AAAASDASKCLASCAMKCA"), false);
		} catch (SQLException e) {
			fail();
		}
	}
	@Test
	void testDoRetrieveByKey() {
		try {
			u2 = UtenteDAO.doRetrieveByKey(u1.getId());
			assertEquals(u1.getId(), u2.getId());
		} catch (SQLException e) {
			fail();
		}
	}
	@Test
	void testDoRetrieveByKeyNull() {
		try {
			u2 = UtenteDAO.doRetrieveByKey(null);
			assertNotEquals(u1, u2);
		}catch (SQLException e) {
			fail();
		}
	}
	@Test
	void testDoRetrieveAll() {
		try {
			utenti = UtenteDAO.doRetrieveAll();
			assertNotEquals(utenti, null);
		}catch (SQLException e) {
			fail();
		}
	}
	@Test
	void testDoRetrieveAllTecnico() {
		try {
			tecnici = UtenteDAO.doRetrieveAllTecnico();
			assertNotEquals(tecnici, null);
		}catch (SQLException e) {
			fail();
		}
	}
}
