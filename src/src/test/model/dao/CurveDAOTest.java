package test.model.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.dao.CircuitoDAO;
import model.dao.CurvaDAO;
import model.dao.RettilineoDAO;
import model.entity.Circuito;
import model.entity.Curva;

class CurveDAOTest {
	Circuito c;
	Circuito c2;
	
	@BeforeEach
	void setUp() throws Exception {
		c = new Circuito(10, "Spa-Francorchamps","Belgio",7004, "Pioggia", (long)110.5876, (long)108.564, 55, 67);
		Collection<Curva> curve = new ArrayList<Curva>();
		curve.add(new Curva(10, "La Source", (long)90));
		curve.add(new Curva(11, "Raidillon de L'Eau Rouge", 38));
		curve.add(new Curva(12, "Les Combes", 45));
		curve.add(new Curva(13, "Bruxelles", 45));
		curve.add(new Curva(14, "Pouhoun 1", 67));
		curve.add(new Curva(15, "Pouhoun 2", 68));
		curve.add(new Curva(16, "Fagnes", 69));
		curve.add(new Curva(17, "Campus", 45));
		curve.add(new Curva(18, "Blanchimont", 45));
		c.setCurve(curve);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testDoRetrieveByCircuito() {
		try {
			c2 = CircuitoDAO.doRetrieveByKey(10);
			c2.setRettilinei(RettilineoDAO.doRetrieveAllByCircuito(10));
			c2.setCurve(CurvaDAO.doRetrieveAllByCircuito(10));
			assertEquals(c2.getCurve().containsAll(c.getCurve()), true);
		} catch (SQLException e) {
			fail();
		}
	}

}
