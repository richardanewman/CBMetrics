package dev.richardnewman.cbmetrics.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GravityTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Gravity gravity;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("CBMetricsPU");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		gravity = em.find(Gravity.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		gravity = null;
	}

	@Test
	@DisplayName("Testing gravity entity mapping: get id")
	void test1() {
		assertNotNull(gravity);
		assertEquals(1, gravity.getId());
	}
	
	@Test
	@DisplayName("Testing gravity entity mapping: get date changed")
	void test2() {
		assertNotNull(gravity);
		assertEquals(LocalDate.parse("2020-02-20"), gravity.getDateCreated());
	}
	
	@Test
	@DisplayName("Testing gravity entity mapping: get gravity value")
	void test3() {
		assertNotNull(gravity);
		assertEquals(0.0, gravity.getGravityValue());
	}
	
	@Test
	@DisplayName("Testing gravity entity mapping: get product get cb id")
	void test4() {
		assertNotNull(gravity);
		assertEquals("defaultprod1", gravity.getProduct().getCbID());
	}
	
	
	

}
