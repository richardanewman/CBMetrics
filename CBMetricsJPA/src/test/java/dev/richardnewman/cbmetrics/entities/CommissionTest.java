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

class CommissionTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Commission comm;

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
		comm = em.find(Commission.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		comm = null;
	}

	@Test
	@DisplayName("Testing commission entity mapping: get id")
	void test1() {
		assertNotNull(comm);
		assertEquals(1, comm.getId());
	}
	
	@Test
	@DisplayName("Testing commission entity mapping: get date changed")
	void test2() {
		assertNotNull(comm);
		assertEquals(LocalDate.parse("2020-02-20"), comm.getDateChanged());
	}
	
	@Test
	@DisplayName("Testing commission entity mapping: get commission value")
	void test3() {
		assertNotNull(comm);
		assertEquals(0.0, comm.getCommissionValue());
	}
	
	@Test
	@DisplayName("Testing commission entity mapping: get product get cb id")
	void test4() {
		assertNotNull(comm);
		assertEquals("defaultprod1", comm.getProduct().getCbID());
	}
	
	
	

}
