package test.model.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.dao.CircuitoDAO;
import model.dao.RettilineoDAO;
import model.entity.Circuito;
import java.util.Collection;
import java.sql.SQLException;
import java.util.ArrayList;
import model.entity.Rettilineo;

class RettilineoDAOTest {
	Circuito c1;
	Circuito c2;
	@BeforeEach
	void setUp() throws Exception {
		c1 = new Circuito(10, "Spa-Francorchamps","Belgio",7004, "Pioggia", (long)106.286, (long)0.564, 55, 67);	
		Collection<Rettilineo> rettilinei = new ArrayList<Rettilineo>();
		rettilinei.add(new Rettilineo(9, "Paul Frere", 340));
		rettilinei.add(new Rettilineo(10, "Kemmel", 770));
		c1.setRettilinei(rettilinei);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		try {
			c2 = CircuitoDAO.doRetrieveByKey(10);
			c2.setRettilinei(RettilineoDAO.doRetrieveAllByCircuito(10));
			assertEquals(c2.getRettilinei().containsAll(c1.getRettilinei()), true);
		} catch (SQLException e) {
			fail();
		}
	}

}
