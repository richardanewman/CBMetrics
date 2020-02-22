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

class ReferredTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Referred referred;

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
		referred = em.find(Referred.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		referred = null;
	}

	@Test
	@DisplayName("Testing referred entity mapping: get id")
	void test1() {
		assertNotNull(referred);
		assertEquals(1, referred.getId());
	}
	
	@Test
	@DisplayName("Testing referred entity mapping: get date changed")
	void test2() {
		assertNotNull(referred);
		assertEquals(LocalDate.parse("2020-02-20"), referred.getDateCreated());
	}
	
	@Test
	@DisplayName("Testing referred entity mapping: get referred value")
	void test3() {
		assertNotNull(referred);
		assertEquals(0.0, referred.getReferredValue());
	}
	
	@Test
	@DisplayName("Testing referred entity mapping: get product get cb id")
	void test4() {
		assertNotNull(referred);
		assertEquals("defaultprod1", referred.getProduct().getCbID());
	}
	
	
	

}
