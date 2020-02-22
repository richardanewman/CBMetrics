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

class PercentPerRebillTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private PercentPerRebill ppr;

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
		ppr = em.find(PercentPerRebill.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		ppr = null;
	}

	@Test
	@DisplayName("Testing percent per rebill entity mapping: get id")
	void test1() {
		assertNotNull(ppr);
		assertEquals(1, ppr.getId());
	}
	
	@Test
	@DisplayName("Testing percent per rebill entity mapping: get date changed")
	void test2() {
		assertNotNull(ppr);
		assertEquals(LocalDate.parse("2020-02-20"), ppr.getDateChanged());
	}
	
	@Test
	@DisplayName("Testing percent per rebill entity mapping: get percent rebill value")
	void test3() {
		assertNotNull(ppr);
		assertEquals(0.0, ppr.getRebillValue());
	}
	
	@Test
	@DisplayName("Testing percent per sale entity mapping: get product get cb id")
	void test4() {
		assertNotNull(ppr);
		assertEquals("defaultprod1", ppr.getProduct().getCbID());
	}
	
	
	

}
