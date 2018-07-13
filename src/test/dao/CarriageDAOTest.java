package test.dao;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import dao.jdbc.CarriageDAO;

public class CarriageDAOTest {
	static CarriageDAO dao;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		 dao = new CarriageDAO();
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
