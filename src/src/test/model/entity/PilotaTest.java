package test.model.entity;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.entity.Mailbox;
import model.entity.Messaggio;
import model.entity.Pilota;
import model.entity.Utente;

class PilotaTest {
	private Pilota pilota;
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
	public void testGetPunteggio() {
		try {
			int exp= 498;
			int act= pilota.getPunteggio();
			assertEquals(exp,act);	
		}
		catch(IllegalArgumentException e) {}
	}
	
	@Test
	public void testSetPunteggio() {
		try {
			pilota.setPunteggio(500);
			assertEquals(500,pilota.getPunteggio());	
		}	
		catch(IllegalArgumentException e) {}
	}
	
	@Test
	public void testPunteggioRange() {
		try{
			pilota.setPunteggio(-5000);
			fail();
		}
		catch(IllegalArgumentException e) {}
	}
	
	@Test
	public void testGetNumeroVittorie() {
		try {
			int exp= 6;
			int act= pilota.getNumeroVittorie();
			assertEquals(exp,act);	
		}
		catch(IllegalArgumentException e) {}
	}
	
	@Test
	public void testSetNumeroVittorie() {
		try {
			pilota.setNumeroVittorie(7);
			assertEquals(7,pilota.getNumeroVittorie());	
		}	
		catch(IllegalArgumentException e) {}
	}
	
	@Test
	public void testNumeroVittorieRange() {
		try{
			pilota.setNumeroVittorie(-5000);
			fail();
		}
		catch(IllegalArgumentException e) {}
	}
	
	@Test
	public void testGetNumeroPole() {
		try {
			int exp= 7;
			int act= pilota.getNumeroPole();
			assertEquals(exp,act);	
		}
		catch(IllegalArgumentException e) {}
	}
	
	@Test
	public void testSetNumeroPole() {
		try {
			pilota.setNumeroPole(7);
			assertEquals(7,pilota.getNumeroPole());	
		}	
		catch(IllegalArgumentException e) {}
	}
	
	@Test
	public void testNumeroPoleRange() {
		try{
			pilota.setNumeroPole(-5000);
			fail();
		}
		catch(IllegalArgumentException e) {}
	}
	
	@Test
	public void testGetNumeroPiazzamenti() {
		try {
			int exp= 14;
			int act= pilota.getNumeroPiazzamenti();
			assertEquals(exp,act);	
		}
		catch(IllegalArgumentException e) {}
	}
	
	@Test
	public void testSetNumeroPiazzamenti() {
		try {
			pilota.setNumeroPiazzamenti(15);
			assertEquals(15,pilota.getNumeroPiazzamenti());	
		}	
		catch(IllegalArgumentException e) {}
	}
	
	@Test
	public void testNumeroPiazzamentiRange() {
		try{
			pilota.setNumeroPiazzamenti(-5000);
			fail();
		}
		catch(IllegalArgumentException e) {}
	}
	
	@Test
	public void testGetNumeroRitiri() {
		try {
			int exp= 0;
			int act= pilota.getNumeroRitiri();
			assertEquals(exp,act);	
		}
		catch(IllegalArgumentException e) {}
	}
	
	@Test
	public void testSetNumeroRitri() {
		try {
			pilota.setNumeroRitiri(1);
			assertEquals(1,pilota.getNumeroRitiri());	
		}	
		catch(IllegalArgumentException e) {}
	}
	
	@Test
	public void testNumeroRitiri() {
		try{
			pilota.setNumeroRitiri(-5000);
			fail();
		}
		catch(IllegalArgumentException e) {}
	}
	

}
