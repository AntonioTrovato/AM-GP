package test.model.entity;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.entity.Circuito;
import model.entity.Curva;
import model.entity.Mailbox;
import model.entity.Rettilineo;
import model.entity.Setup;
import model.entity.Tecnico;

class SetupTest {
	private Setup setup;
	private Tecnico autore;
	private Circuito circuito;

	@BeforeEach
	void setUp() throws Exception {
		Collection<Curva> curve = new ArrayList<Curva>();
		Collection<Rettilineo> rettilinei = new ArrayList<Rettilineo>();
		curve.add(new Curva());
		rettilinei.add(new Rettilineo());
		autore = new Tecnico("AAAAAAAAAAAAAA","passwordE3@","tecnico","Giovanni","Renzulli",new Mailbox());
		circuito = new Circuito("Circuito","Paese",7700,"Sole",112123,102123,34,45,curve,rettilinei);
		setup = new Setup(1,5.3,5.2,1.5,1.3,0.6,0.3,50,5.5,5.8,autore,circuito,"10-10-2021");
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	public void testGetDate() {
		try {
			String exp= "10-10-2021";
			String act= setup.getDate();
			assertEquals(exp,act);	
		}
		catch(IllegalArgumentException e) {}
	}
	
	@Test
	public void testSetDate() {
		try {
			setup.setDate("11-11-2021");
			assertEquals("11-11-2021",setup.getDate());	
		}	
		catch(IllegalArgumentException e) {}
	}
	
	@Test
	public void testGetId() {
		try {
			int exp= 1;
			int act= setup.getId();
			assertEquals(exp,act);	
		}
		catch(IllegalArgumentException e) {}
	}
	
	@Test
	public void testSetId() {
		try {
			setup.setId(2);
			assertEquals(2,setup.getId());	
		}	
		catch(IllegalArgumentException e) {}
	}
	
	@Test
	public void testGetCaricoAreodinamicoAnteriore() {
		try {
			double exp= 5.3;
			double act= setup.getCaricoAerodinamicoAnteriore();
			assertEquals(exp,act);	
		}
		catch(IllegalArgumentException e) {}
	}
	
	@Test
	public void testSetCaricoAreodinamicoAnteriore() {
		try {
			setup.setCaricoAerodinamicoAnteriore(2);
			assertEquals(2,setup.getCaricoAerodinamicoAnteriore());	
		}	
		catch(IllegalArgumentException e) {}
	}
	
	@Test
	public void testCaricoAreodinamicoAnterioreRange() {
		try{
			setup.setCaricoAerodinamicoAnteriore(-5000);
			fail();
		}
		catch(IllegalArgumentException e) {}
	}
	
	@Test
	public void testGetCaricoAreodinamicoPosteriore() {
		try {
			double exp= 5.2;
			double act= setup.getCaricoAerodinamicoPosteriore();
			assertEquals(exp,act);	
		}
		catch(IllegalArgumentException e) {}
	}
	
	@Test
	public void testSetCaricoAreodinamicoPosteriore() {
		try {
			setup.setCaricoAerodinamicoPosteriore(2);
			assertEquals(2,setup.getCaricoAerodinamicoPosteriore());	
		}	
		catch(IllegalArgumentException e) {}
	}
	
	@Test
	public void testCaricoAreodinamicoPosterioreRange() {
		try{
			setup.setCaricoAerodinamicoPosteriore(-5000);
			fail();
		}
		catch(IllegalArgumentException e) {}
	}
	
	@Test
	public void testGetCampanaturaAnteriore() {
		try {
			double exp= 1.5;
			double act= setup.getCampanaturaAnteriore();
			assertEquals(exp,act);	
		}
		catch(IllegalArgumentException e) {}
	}
	
	@Test
	public void testSetCampanaturaAnteriore() {
		try {
			setup.setCampanaturaAnteriore(1);
			assertEquals(1,setup.getCampanaturaAnteriore());	
		}	
		catch(IllegalArgumentException e) {}
	}
	
	@Test
	public void testCampanaturaAnterioreRange() {
		try{
			setup.setCampanaturaAnteriore(-5000);
			fail();
		}
		catch(IllegalArgumentException e) {}
	}
	
	@Test
	public void testGetCampanaturaPosteriore() {
		try {
			double exp= 1.3;
			double act= setup.getCampanaturaPosteriore();
			assertEquals(exp,act);	
		}
		catch(IllegalArgumentException e) {}
	}
	
	@Test
	public void testSetCampanaturaPosteriore() {
		try {
			setup.setCampanaturaPosteriore(1);
			assertEquals(1,setup.getCampanaturaPosteriore());	
		}	
		catch(IllegalArgumentException e) {}
	}
	
	@Test
	public void testCampanaturaPosterioreRange() {
		try{
			setup.setCampanaturaPosteriore(-5000);
			fail();
		}
		catch(IllegalArgumentException e) {}
	}
	
	@Test
	public void testGetConvergenzaAnteriore() {
		try {
			double exp= 0.6;
			double act= setup.getConvergenzaAnteriore();
			assertEquals(exp,act);	
		}
		catch(IllegalArgumentException e) {}
	}
	
	@Test
	public void testSetConvergenzaAnteriore() {
		try {
			setup.setConvergenzaAnteriore(0);
			assertEquals(0,setup.getConvergenzaAnteriore());	
		}	
		catch(IllegalArgumentException e) {}
	}
	
	@Test
	public void testConvergenzaAnterioreRange() {
		try{
			setup.setConvergenzaAnteriore(-5000);
			fail();
		}
		catch(IllegalArgumentException e) {}
	}
	
	@Test
	public void testGetConvergenzaPosteriore() {
		try {
			double exp= 0.3;
			double act= setup.getConvergenzaPosteriore();
			assertEquals(exp,act);	
		}
		catch(IllegalArgumentException e) {}
	}
	
	@Test
	public void testSetConvergenzaPosteriore() {
		try {
			setup.setConvergenzaPosteriore(0);
			assertEquals(0,setup.getConvergenzaPosteriore());	
		}	
		catch(IllegalArgumentException e) {}
	}
	
	@Test
	public void testConvergenzaPosterioreRange() {
		try{
			setup.setConvergenzaPosteriore(-5000);
			fail();
		}
		catch(IllegalArgumentException e) {}
	}
	
	@Test
	public void testGetPressioneFreni() {
		try {
			double exp= 50;
			double act= setup.getPressioneFreni();
			assertEquals(exp,act);	
		}
		catch(IllegalArgumentException e) {}
	}
	
	@Test
	public void testSetPressioneFreni() {
		try {
			setup.setPressioneFreni(15);
			assertEquals(15,setup.getPressioneFreni());	
		}	
		catch(IllegalArgumentException e) {}
	}
	
	@Test
	public void testPressioneFreniRange() {
		try{
			setup.setPressioneFreni(-5000);
			fail();
		}
		catch(IllegalArgumentException e) {}
	}
	
	@Test
	public void testGetBarraAntirollioAnteriore() {
		try {
			double exp= 5.8;
			double act= setup.getBarraAntirollioAnteriore();
			assertEquals(exp,act);	
		}
		catch(IllegalArgumentException e) {}
	}
	
	@Test
	public void testSetBarraAntirollioAnteriore() {
		try {
			setup.setBarraAntirollioAnteriore(5);
			assertEquals(5,setup.getBarraAntirollioAnteriore());	
		}	
		catch(IllegalArgumentException e) {}
	}
	
	@Test
	public void testBarraAntirollioAnterioreRange() {
		try{
			setup.setBarraAntirollioAnteriore(-5000);
			fail();
		}
		catch(IllegalArgumentException e) {}
	}
	
	@Test
	public void testGetBarraAntirollioPosteriore() {
		try {
			double exp= 5.5;
			double act= setup.getBarraAntirollioPosteriore();
			assertEquals(exp,act);	
		}
		catch(IllegalArgumentException e) {}
	}
	
	@Test
	public void testSetBarraAntirollioPosteriore() {
		try {
			setup.setBarraAntirollioPosteriore(5.5);
			assertEquals(5.5,setup.getBarraAntirollioPosteriore());	
		}	
		catch(IllegalArgumentException e) {}
	}
	
	@Test
	public void testBarraAntirollioPosterioreRange() {
		try{
			setup.setBarraAntirollioPosteriore(-5000);
			fail();
		}
		catch(IllegalArgumentException e) {}
	}

}
