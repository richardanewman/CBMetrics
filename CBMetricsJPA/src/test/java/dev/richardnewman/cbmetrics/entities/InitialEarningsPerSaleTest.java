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

class InitialEarningsPerSaleTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private InitialEarningsPerSale ieps;

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
		ieps = em.find(InitialEarningsPerSale.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		ieps = null;
	}

	@Test
	@DisplayName("Testing initial earnings per sale entity mapping: get id")
	void test1() {
		assertNotNull(ieps);
		assertEquals(1, ieps.getId());
	}
	
	@Test
	@DisplayName("Testing initial earnings per sale entity mapping: get date changed")
	void test2() {
		assertNotNull(ieps);
		assertEquals(LocalDate.parse("2020-02-20"), ieps.getDateCreated());
	}
	
	@Test
	@DisplayName("Testing initial earnings per sale entity mapping: get commission value")
	void test3() {
		assertNotNull(ieps);
		assertEquals(0.0, ieps.getInitialEarningsValue());
	}
	
	@Test
	@DisplayName("Testing initial earnings per sale entity mapping: get product get cb id")
	void test4() {
		assertNotNull(ieps);
		assertEquals("defaultprod1", ieps.getProduct().getCbID());
	}
	
	
	

}
