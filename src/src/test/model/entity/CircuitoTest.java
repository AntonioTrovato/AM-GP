package test.model.entity;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.entity.*;

class CircuitoTest {
	private Circuito circuito;
	private ArrayList<Curva> curve;
	private ArrayList<Rettilineo> rettilinei;

	@BeforeEach
	void setUp() throws Exception {
		curve= new ArrayList<Curva>();
		curve.add(new Curva(1,"curva1", 30.0f));
		curve.add(new Curva(2,"curva2", 35.0f));
		curve.add(new Curva(3,"curva3", 35.0f));
		rettilinei= new ArrayList<Rettilineo>();
		rettilinei.add(new Rettilineo(1,"rettilineo1", 100.0));
		rettilinei.add(new Rettilineo(2,"rettilineo2", 500.0));
		rettilinei.add(new Rettilineo(3,"rettilineo3", 700.0));
		circuito= new Circuito("Red Bull Ring","Austria", 4318,"sole", 30, 50, 12,71,curve,rettilinei);
	}

	@AfterEach
	void tearDown() throws Exception {
		curve.clear();
		rettilinei.clear();
	}

	
	
	@Test
	public void testSetNome() {
		try {
			circuito.setNome("Hungaroring");
			assertEquals("Hungaroring",circuito.getNome());	
		}	
		catch(IllegalArgumentException e) {}
	}
	

	@Test
	public void testGetNome() {
		try {
			String exp= "Red Bull Ring";
			String act= circuito.getNome();
			assertEquals(exp,act);	
		}
		catch(IllegalArgumentException e) {}
	}
	
	@Test
	public void testGetSede() {
		try {
			String exp= "Austria";
			String act= circuito.getSede();
			assertEquals(exp,act);	
		}
		catch(IllegalArgumentException e) {}
	}
	
	@Test
	public void testSetSede() {
		try {
			circuito.setSede("Ungheria");
			assertEquals("Ungheria",circuito.getSede());	
		}	
		catch(IllegalArgumentException e) {}
	}
	
	@Test
	public void testSedeNull() {
		try{
			circuito.setSede(null);
			fail();
		}
		catch(IllegalArgumentException e) {}
	}


	@Test
	public void testSedeEmpty() {
		try{
			circuito.setSede("");
			fail();
		}
		catch(IllegalArgumentException e) {}
	}
	
	

	@Test
	public void testGetLunghezza() {
		try {
			int exp= 4318;
			long act= circuito.getLunghezza();
			assertEquals(exp,act);	
		}
		catch(IllegalArgumentException e) {}
	}
	
	@Test
	public void testSetLunghezza() {
		try {
			circuito.setLunghezza(4500);
			assertEquals(4500,circuito.getLunghezza());	
		}	
		catch(IllegalArgumentException e) {}
	}
	
	public void testLunghezzaRange() {
		try{
			circuito.setLunghezza(-5000);
			fail();
		}
		catch(IllegalArgumentException e) {}
	}
	
	
	@Test
	public void testGetMeteo() {
		try {
			String exp= "sole";
			String act= circuito.getMeteo();
			assertEquals(exp,act);	
		}
		catch(IllegalArgumentException e) {}
	}
	
	@Test
	public void testSetMeteo() {
		try {
			circuito.setMeteo("pioggia");
			assertEquals("pioggia",circuito.getMeteo());	
		}	
		catch(IllegalArgumentException e) {}
	}
	
	@Test
	public void testMeteoNull() {
		try{
			circuito.setMeteo(null);
			fail();
		}
		catch(IllegalArgumentException e) {}
	}


	@Test
	public void testMeteoEmpty() {
		try{
			circuito.setMeteo("");
			fail();
		}
		catch(IllegalArgumentException e) {}
	}
	
	

	@Test
	public void testGetTPM() {
		try {
			int exp= 30;
			long act= circuito.getTpm();
			assertEquals(exp,act);	
		}
		catch(IllegalArgumentException e) {}
	}
	
	@Test
	public void testSetTPM() {
		try {
			circuito.setTpm(50);
			assertEquals(50,circuito.getTpm());	
		}	
		catch(IllegalArgumentException e) {}
	}
	
	public void testTPMRange() {
		try{
			circuito.setTpm(-40);
			fail();
		}
		catch(IllegalArgumentException e) {}
	}
	
	
	@Test
	public void testGetRPM() {
		try {
			int exp= 50;
			long act= circuito.getRpm();
			assertEquals(exp,act);	
		}
		catch(IllegalArgumentException e) {}
	}
	
	@Test
	public void testSetRPM() {
		try {
			circuito.setRpm(60);
			assertEquals(60,circuito.getRpm());	
		}	
		catch(IllegalArgumentException e) {}
	}
	
	public void testRPMRange() {
		try{
			circuito.setRpm(-40);
			fail();
		}
		catch(IllegalArgumentException e) {}
	}

	
	@Test
	public void testGetUmidita() {
		try {
			int exp= 12;
			long act= circuito.getUmidita();
			assertEquals(exp,act);	
		}
		catch(IllegalArgumentException e) {}
	}
	
	@Test
	public void testSetUmidita() {
		try {
			circuito.setUmidita(23);
			assertEquals(23,circuito.getUmidita());	
		}	
		catch(IllegalArgumentException e) {}
	}
	
	public void testUmiditaRange() {
		try{
			circuito.setRpm(-12);
			fail();
		}
		catch(IllegalArgumentException e) {}
	}

	
	
	@Test
	public void testGetNumeroGiri() {
		try {
			int exp= 71;
			long act= circuito.getNumeroGiri();
			assertEquals(exp,act);	
		}
		catch(IllegalArgumentException e) {}
	}
	
	@Test
	public void testSetNumeroGiri() {
		try {
			circuito.setNumeroGiri(91);
			assertEquals(91,circuito.getNumeroGiri());	
		}	
		catch(IllegalArgumentException e) {}
	}
	
	public void testNumeroGiriRange() {
		try{
			circuito.setNumeroGiri(-50);
			fail();
		}
		catch(IllegalArgumentException e) {}
	}

	
	
	@Test
	public void testGetCurve() {
		try {
			ArrayList<Curva> exp= new ArrayList<Curva>();
			exp.add(new Curva(1,"curva1", 30.0f));
			exp.add(new Curva(2,"curva2", 35.0f));
			exp.add(new Curva(3,"curva3", 35.0f));
			assertTrue(exp.equals(circuito.getCurve()));
		}
		catch(IllegalArgumentException e) {}
	}
	
	@Test
	public void testSetCurve() {
		try {
			ArrayList<Curva> exp= new ArrayList<Curva>();
			exp.add(new Curva(5,"curva4", 45.0f));
			exp.add(new Curva(6,"curva5", 55.0f));
			exp.add(new Curva(7,"curva6", 75.0f));
			circuito.setCurve(exp);
			assertEquals(exp, circuito.getCurve());	
		}	
		catch(IllegalArgumentException e) {}
	}
	
	public void testCurveNull() {
		try{
			circuito.setCurve(null);
			fail();
		}
		catch(IllegalArgumentException e) {}
	}
	
	public void testCurveEmpty() {
		try{
			ArrayList<Curva> curve2= new ArrayList<Curva>();
			circuito.setCurve(curve2);
			fail();
		}
		catch(IllegalArgumentException e) {}
	}


	
	
	@Test
	public void testGetRettilinei() {
		try {
			ArrayList<Rettilineo>  exp= new ArrayList<Rettilineo>();
			exp.add(new Rettilineo(1,"rettilineo1", 100.0));
			exp.add(new Rettilineo(2,"rettilineo2", 500.0));
			exp.add(new Rettilineo(3,"rettilineo3", 700.0));
			ArrayList<Rettilineo> act= (ArrayList<Rettilineo>) circuito.getRettilinei();
			assertTrue(exp.equals(act));	
		}
		catch(IllegalArgumentException e) {}
	}
	
	@Test
	public void testSetRettilinei() {
		try {
			ArrayList<Rettilineo> exp= new ArrayList<Rettilineo>();
			exp.add(new Rettilineo(1,"rettilineo2", 230.0));
			exp.add(new Rettilineo(2,"rettilineo3", 340.0));
			exp.add(new Rettilineo(3,"rettilineo4", 450.0));
			circuito.setRettilinei(exp);
			assertEquals(exp, circuito.getRettilinei());	
		}	
		catch(IllegalArgumentException e) {}
	}
	
	public void testRettilineiNull() {
		try{
			circuito.setRettilinei(null);
			fail();
		}
		catch(IllegalArgumentException e) {}
	}
	
	public void testRettilineiEmpty() {
		try{
			ArrayList<Rettilineo> rettilineo2= new ArrayList<Rettilineo>();
			circuito.setRettilinei(rettilineo2);
			fail();
		}
		catch(IllegalArgumentException e) {}
	}


	
	
}
