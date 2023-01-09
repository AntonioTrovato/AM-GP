package test.model.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.dao.CircuitoDAO;
import model.dao.SetupDAO;
import model.dao.UtenteDAO;
import model.entity.Circuito;
import model.entity.Curva;
import model.entity.Mailbox;
import model.entity.Rettilineo;
import model.entity.Setup;
import model.entity.Tecnico;
import model.entity.Utente;

class SetupDAOTest {
	Setup s1;
	Setup s2;
	Tecnico autore;
	
	@BeforeEach
	void setUp() throws Exception {
		autore = new Tecnico("AAAAAAAAAAAAAA", "passwordProva1?+", "tecnico", "Pietro", "Negri", new Mailbox());
		Circuito circuito = CircuitoDAO.doRetrieveByKey(10);
		s1 = new Setup(50,5.3,5.2,1.5,1.3,0.6,0.3,50,5.5,5.8,autore,circuito,"10-10-2021");
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	void testDoSave() {
		try {
			SetupDAO.doSave(s1);
		} catch (SQLException e) {
			fail();
		}
		
	}
	
	@Test
	void testDoSaveError() {
		try {
			SetupDAO.doSave(s2);
			fail();
		} catch (Exception e) {
		}
		
	}
	
	@Test
	void testDoUpdate() {
		try {
			s2 = SetupDAO.doRetrieveByKey(1);
			s2.setAutore(autore);
			s2.setPressioneFreni(43);
			SetupDAO.doUpdate(s2);
			Setup test = SetupDAO.doRetrieveByKey(1);
			assertEquals(test.getPressioneFreni(), s2.getPressioneFreni());
		}
		catch(SQLException e) {
			fail();
		}
	}
	
	@Test
	void testDoUpdateError() {
		try {
			SetupDAO.doUpdate(null);
			fail();
		}
		catch(Exception e) {
		
		}
	}
	
	@Test
	void testDoRetrieveByKey() {
		try {
			s2= SetupDAO.doRetrieveByKey(1);
			assertEquals(s2.getId(), 1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	void testDoRetrieveByKeyError() {
		try {
			s2= SetupDAO.doRetrieveByKey(-1);
			assertNotEquals(s2.getId(), 1);
		} catch (SQLException e) {
			fail();
		}
		
	}
	
	@Test
	void testDoDelete() {
		try {
			Setup cancella = SetupDAO.doRetrieveByKey(50);
			SetupDAO.doDelete(cancella.getId());
		} catch (SQLException e) {
			fail();
		}
	}

}
