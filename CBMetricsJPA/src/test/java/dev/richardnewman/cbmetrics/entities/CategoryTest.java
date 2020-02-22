package dev.richardnewman.cbmetrics.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CategoryTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Category cat;

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
		cat = em.find(Category.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		cat = null;
	}

	@Test
	@DisplayName("Testing category entity mapping: get id")
	void test1() {
		assertNotNull(cat);
		assertEquals(1, cat.getId());
	}
	
	@Test
	@DisplayName("Testing category entity mapping: get category name")
	void test2() {
		assertNotNull(cat);
		assertEquals("Test Category", cat.getName());
	}
	
	@Test
	@DisplayName("Testing category entity mapping: get product at index 0 and get cb id")
	void test3() {
		assertNotNull(cat);
		assertEquals("defaultprod1", cat.getProducts().get(0).getCbID());
	}
	
	
	
	

}
