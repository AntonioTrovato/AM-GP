package test.model.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.Collection;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.dao.CircuitoDAO;
import model.dao.PilotaDAO;
import model.dao.SetupDAO;
import model.entity.Circuito;
import model.entity.Mailbox;
import model.entity.Pilota;

class PilotaDAOTest {
	private Pilota pilota;
	private Pilota pilota2;
	private Mailbox mailbox;

	@BeforeEach
	void setUp() throws Exception {
		mailbox = new Mailbox();
		pilota = new Pilota("qweratsderture","password1@E","pilota","Antonio","Trovato",mailbox,498,6,7,14,0);
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	void testDoRetrieveByKey() {
		try {
			pilota2 = PilotaDAO.doRetrieveByPilota(pilota);
			assertEquals(pilota2.getId(), pilota.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	void testDoRetrieveByKeyError() {
		try {
			pilota2 = PilotaDAO.doRetrieveByPilota(new Pilota("qweratsderturp","password1@E","pilota","Antonio","Trovato",mailbox,498,6,7,14,0));
			assertNotEquals(pilota2.getId(), "KKKKKKKKKKKKKKK");
		} catch (SQLException e) {
			fail();
		}
		
	}
	
	@Test
	void testDoRetrieveAllNull() {
		try {
			Collection<Pilota> piloti = PilotaDAO.doRetrieveAll();
			assertNotEquals(piloti, null);
		} catch (SQLException e) {
			fail();
		}
	}

}
