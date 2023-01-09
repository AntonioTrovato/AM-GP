package test.model.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.Collection;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.dao.CircuitoDAO;
import model.entity.Circuito;

class CircuitoDAOTest {
	Circuito circuitoNonE;
	Circuito circuitoE;
	@BeforeEach
	void setUp() throws Exception {
		circuitoNonE =  new Circuito(4, "Sochi","Russia",6500, "Neve", 34312, 321, 60, 67);
		circuitoE = new Circuito(10, "Spa-Francorchamps","Belgio",7004, "Pioggia", (long)106.286, (long)0.564, 55, 67);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testDoRetrieve() {
		try {
			Circuito c = CircuitoDAO.doRetrieveByKey(10);
			assertEquals(c.getId(), circuitoE.getId());
		} catch (SQLException e) {
			fail();
		}
	}
	
	@Test
	void testDoRetrieveNull() {
		try {
			Circuito c = CircuitoDAO.doRetrieveByKey(circuitoNonE.getId());
			assertNotEquals(c.getId(), circuitoNonE.getId());
		} catch (SQLException e) {
			fail();
		}
	}
	
	@Test
	void testDoRetrieveAllNull() {
		try {
			Collection<Circuito> collection = CircuitoDAO.doRetrieveAll();
			assertNotEquals(collection, null);
		} catch (SQLException e) {
			fail();
		}
	}
	
	
	
	

}
