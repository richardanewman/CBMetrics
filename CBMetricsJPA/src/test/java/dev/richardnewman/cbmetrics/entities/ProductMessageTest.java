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

class ProductMessageTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private ProductMessage pm;

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
		pm = em.find(ProductMessage.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		pm = null;
	}

	@Test
	@DisplayName("Testing product message entity mapping: get id")
	void test1() {
		assertNotNull(pm);
		assertEquals(1, pm.getId());
	}
	
	@Test
	@DisplayName("Testing product message entity mapping: get date posted")
	void test2() {
		assertNotNull(pm);
		assertEquals(LocalDate.parse("2020-02-20"), pm.getDatePosted());
	}
	
	@Test
	@DisplayName("Testing product message entity mapping: get product message")
	void test3() {
		assertNotNull(pm);
		assertEquals("This looks like an interesting product. Has anyone promoted this lately?", pm.getMessage());
	}
	
	@Test
	@DisplayName("Testing product message entity mapping: get product get title")
	void test4() {
		assertNotNull(pm);
		assertEquals("Default Product Title", pm.getProduct().getTitle());
	}
	
	@Test
	@DisplayName("Testing product message entity mapping: get replied to user profile")
	void test5() {
		assertNotNull(pm);
		assertEquals(" ", pm.getRepliedToProfile().getFirstName());
	}
	
	@Test
	@DisplayName("Testing product message entity mapping: get user profile get first name")
	void test6() {
		assertNotNull(pm);
		assertEquals("Richard", pm.getUserProfile().getFirstName());
	}
	
	
	
	
	
	

}
