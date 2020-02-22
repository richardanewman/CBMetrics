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

class AverageEarningsPerSaleTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private AverageEarningsPerSale aeps;

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
		aeps = em.find(AverageEarningsPerSale.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		aeps = null;
	}

	@Test
	@DisplayName("Testing average earnings per sale entity mapping: get id")
	void test1() {
		assertNotNull(aeps);
		assertEquals(1, aeps.getId());
	}
	
	@Test
	@DisplayName("Testing average earnings per sale entity mapping: get date changed")
	void test2() {
		assertNotNull(aeps);
		assertEquals(LocalDate.parse("2020-02-20"), aeps.getDateCreated());
	}
	
	@Test
	@DisplayName("Testing average earnings per sale entity mapping: get average earnings value")
	void test3() {
		assertNotNull(aeps);
		assertEquals(0.0, aeps.getAvgEarningsValue());
	}
	
	@Test
	@DisplayName("Testing average earnings per sale entity mapping: get product get cb id")
	void test4() {
		assertNotNull(aeps);
		assertEquals("defaultprod1", aeps.getProduct().getCbID());
	}
	
	
	

}
