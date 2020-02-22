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

class ProductTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Product product;

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
		product = em.find(Product.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		product = null;
	}

	@Test
	@DisplayName("Testing product entity mapping: get id")
	void test1() {
		assertNotNull(product);
		assertEquals(1, product.getId());
	}
	
	@Test
	@DisplayName("Testing product entity mapping: get active date")
	void test2() {
		assertNotNull(product);
		assertEquals(LocalDate.parse("2020-02-20"), product.getActiveDate());
	}
	
	@Test
	@DisplayName("Testing product entity mapping: get average earnings per sale")
	void test3() {
		assertNotNull(product);
		assertEquals(0.0, product.getAvgEarningsPerSale());
	}
	
	@Test
	@DisplayName("Testing product entity mapping: get commission")
	void test4() {
		assertNotNull(product);
		assertEquals(0, product.getCommission());
	}
	
	@Test
	@DisplayName("Testing product entity mapping: get cb product id")
	void test5() {
		assertNotNull(product);
		assertEquals("defaultprod1", product.getCbID());
	}
	
	@Test
	@DisplayName("Testing product entity mapping: get cb product description")
	void test6() {
		assertNotNull(product);
		assertEquals("Testing product description.", product.getDescription());
	}
	
	@Test
	@DisplayName("Testing product entity mapping: get gravity")
	void test7() {
		assertNotNull(product);
		assertEquals(0.0, product.getGravity());
	}
	
	@Test
	@DisplayName("Testing product entity mapping: get initial earnings")
	void test8() {
		assertNotNull(product);
		assertEquals(0.0, product.getInitialEarningsPerSale());
	}
	
	@Test
	@DisplayName("Testing product entity mapping: get percent rebill")
	void test9() {
		assertNotNull(product);
		assertEquals(0.0, product.getPercentPerRebill());
	}
	
	@Test
	@DisplayName("Testing product entity mapping: get percent per sale")
	void test10() {
		assertNotNull(product);
		assertEquals(0.0, product.getPercentPerSale());
	}
	
	@Test
	@DisplayName("Testing product entity mapping: get popularity rank")
	void test11() {
		assertNotNull(product);
		assertEquals(0, product.getPopularityRank());
	}
	
	@Test
	@DisplayName("Testing product entity mapping: get referred")
	void test12() {
		assertNotNull(product);
		assertEquals(0.0, product.getReferred());
	}
	
	@Test
	@DisplayName("Testing product entity mapping: get referred")
	void test13() {
		assertNotNull(product);
		assertEquals("Default Product Title", product.getTitle());
	}
	
	@Test
	@DisplayName("Testing product entity mapping: get total rebill amount")
	void test14() {
		assertNotNull(product);
		assertEquals(0.0, product.getTotalRebillAmt());
	}
	
	@Test
	@DisplayName("Testing product entity mapping: get total rebill amount")
	void test15() {
		assertNotNull(product);
		assertEquals(false, product.isHasRecurringProducts());
	}
	
	
	

}
