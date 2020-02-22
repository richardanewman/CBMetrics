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

class PopularityRankTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private PopularityRank pop;

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
		pop = em.find(PopularityRank.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		pop = null;
	}

	@Test
	@DisplayName("Testing popularity rank entity mapping: get id")
	void test1() {
		assertNotNull(pop);
		assertEquals(1, pop.getId());
	}
	
	@Test
	@DisplayName("Testing popularity rank entity mapping: get date changed")
	void test2() {
		assertNotNull(pop);
		assertEquals(LocalDate.parse("2020-02-20"), pop.getDateCreated());
	}
	
	@Test
	@DisplayName("Testing popularity rank entity mapping: get popularity rank value")
	void test3() {
		assertNotNull(pop);
		assertEquals(0.0, pop.getRankValue());
	}
	
	@Test
	@DisplayName("Testing popularity rank entity mapping: get product get cb id")
	void test4() {
		assertNotNull(pop);
		assertEquals("defaultprod1", pop.getProduct().getCbID());
	}
	
	
	

}
