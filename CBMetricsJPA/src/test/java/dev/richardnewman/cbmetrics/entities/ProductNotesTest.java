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

class ProductNotesTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private ProductNotes notes;

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
		notes = em.find(ProductNotes.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		notes = null;
	}

	@Test
	@DisplayName("Testing product notes entity mapping: get id")
	void test1() {
		assertNotNull(notes);
		assertEquals(1, notes.getId());
	}
	
	@Test
	@DisplayName("Testing product notes entity mapping: get date created")
	void test2() {
		assertNotNull(notes);
		assertEquals(LocalDate.parse("2020-02-20"), notes.getDateCreated());
	}
	
	@Test
	@DisplayName("Testing product notes entity mapping: get product notes")
	void test3() {
		assertNotNull(notes);
		assertEquals("Testing out product notes.", notes.getNotes());
	}
	
	@Test
	@DisplayName("Testing product notes entity mapping: get product get title")
	void test4() {
		assertNotNull(notes);
		assertEquals("Default Product Title", notes.getProduct().getTitle());
	}
	
	@Test
	@DisplayName("Testing product notes entity mapping: get user profile get first name")
	void test5() {
		assertNotNull(notes);
		assertEquals("Richard", notes.getUserProfile().getFirstName());
	}
	

}
