package test.model.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.entity.Mailbox;
import model.entity.Utente;

class UtenteTest {
	Utente u;

	@BeforeEach
	void setUp() throws Exception {
		u = new Utente("AAAAAAAAAAAAAA", "balubabbalucCacC1?+", "tecnico", "Pietro", "Negri", new Mailbox());
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testIDVuoto() {
		try {
			u.setId(null);
			fail();
		}
		catch(IllegalArgumentException e) {
			
		}
	}
	
	@Test
	void testIDLunghezza() {
		try {
			u.setId("AA");
			fail();
		}
		catch(IllegalArgumentException e) {
			
		}
		
	}
	
	@Test
	void testID() {
			u.setId("AAAAAAAAAAAAAA");
			u.getId().equals("AAAAAAAAAAAAAA");
	}
	
	@Test
	void testPasswordVuota() {
		try {
			u.setPassword(null);
			fail();
		}
		catch(IllegalArgumentException e) {
			
		}
	}
	
	@Test
	void testPasswordLunghezza() {
		try {
			u.setPassword("AAAA");
			fail();
		}
		catch(IllegalArgumentException e) {
			
		}
	}
	
	@Test
	void testPasswordFormato() {
		try {
			u.setPassword("aaaaaaaaaaaaaaaaa");
			fail();
		}
		catch(IllegalArgumentException e) {
			
		}
	}
	
	@Test
	void testPassword() {
		try {
			u.setPassword("passwordProvaCorretta1?+");
		}
		catch(IllegalArgumentException e) {
			fail();
		}
	}
	
	@Test
	void testRuoloPilota() {
		try {
			u.setRuolo("pilota");
		}
		catch(IllegalArgumentException e) {
			fail();
		}
	}
	
	@Test
	void testRuoloTecnico() {
		try {
			u.setRuolo("tecnico");
		}
		catch(IllegalArgumentException e) {
			fail();
		}
	}

	@Test
	void testRuoloDiverso() {
		try {
			u.setRuolo("tecnicoCC");
			fail();
		}
		catch(IllegalArgumentException e) {
		}
	}
	
	@Test
	void testRuoloNull() {
		try {
			u.setRuolo(null);
			fail();
		}
		catch(IllegalArgumentException e) {
		}
	}
	
	@Test
	void testNomeNull() {
		try {
			u.setNome(null);
			fail();
		}
		catch(IllegalArgumentException e) {
		}
	}
	
	@Test
	void testNomeEmpty() {
		try {
			u.setNome("");
			fail();
		}
		catch(IllegalArgumentException e) {
		}
	}
	@Test
	void testNome() {
		try {
			u.setNome("Pietro");
			
		}
		catch(IllegalArgumentException e) {
			fail();
		}
	}
	
	@Test
	void testCognomeEmpty() {
		try {
			u.setNome("");
			fail();
		}
		catch(IllegalArgumentException e) {
		}
	}
	
	@Test
	void testCognomeNull() {
		try {
			u.setNome("");
			fail();
		}
		catch(IllegalArgumentException e) {
		}
	}
	
	@Test
	void testCognome() {
		try {
			u.setCognome("Negri");
		}
		catch(IllegalArgumentException e) {
			fail();
		}
	}
	@Test
	void testMailbox() {
		try {
			u.setMailbox(new Mailbox());
			assertNotEquals(u.getMailbox(), null);
		}
		catch(IllegalArgumentException e) {
			fail();
		}
	}

}
