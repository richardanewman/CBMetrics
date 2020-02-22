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

class TotalRebillAmountTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private TotalRebillAmount tra;

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
		tra = em.find(TotalRebillAmount.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		tra = null;
	}

	@Test
	@DisplayName("Testing total rebill amount entity mapping: get id")
	void test1() {
		assertNotNull(tra);
		assertEquals(1, tra.getId());
	}
	
	@Test
	@DisplayName("Testing total rebill amount entity mapping: get date changed")
	void test2() {
		assertNotNull(tra);
		assertEquals(LocalDate.parse("2020-02-20"), tra.getDateCreated());
	}
	
	@Test
	@DisplayName("Testing total rebill amount entity mapping: get total rebill value")
	void test3() {
		assertNotNull(tra);
		assertEquals(0.0, tra.getTotalRebillValue());
	}
	
	@Test
	@DisplayName("Testing total rebill amount entity mapping: get product get cb id")
	void test4() {
		assertNotNull(tra);
		assertEquals("defaultprod1", tra.getProduct().getCbID());
	}
	
	
	

}
