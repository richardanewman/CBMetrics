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

class PercentPerSaleTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private PercentPerSale pps;

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
		pps = em.find(PercentPerSale.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		pps = null;
	}

	@Test
	@DisplayName("Testing percent per sale entity mapping: get id")
	void test1() {
		assertNotNull(pps);
		assertEquals(1, pps.getId());
	}
	
	@Test
	@DisplayName("Testing percent per sale entity mapping: get date changed")
	void test2() {
		assertNotNull(pps);
		assertEquals(LocalDate.parse("2020-02-20"), pps.getDateChanged());
	}
	
	@Test
	@DisplayName("Testing percent per sale entity mapping: get percentage value")
	void test3() {
		assertNotNull(pps);
		assertEquals(0.0, pps.getPercentageValue());
	}
	
	@Test
	@DisplayName("Testing percent per sale entity mapping: get product get cb id")
	void test4() {
		assertNotNull(pps);
		assertEquals("defaultprod1", pps.getProduct().getCbID());
	}
	
	
	

}
