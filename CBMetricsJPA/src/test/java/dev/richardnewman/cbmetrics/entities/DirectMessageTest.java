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

class DirectMessageTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private DirectMessage dm;

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
		dm = em.find(DirectMessage.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		dm = null;
	}

	@Test
	@DisplayName("Testing direct message entity mapping: get id")
	void test1() {
		assertNotNull(dm);
		assertEquals(1, dm.getId());
	}
	
	@Test
	@DisplayName("Testing direct message entity mapping: get composer's first name")
	void test2() {
		assertNotNull(dm);
		assertEquals("Richard", dm.getComposerProfile().getFirstName());
	}
	
	@Test
	@DisplayName("Testing direct message entity mapping: get recipient's first name")
	void test3() {
		assertNotNull(dm);
		assertEquals("John", dm.getRecipientProfile().getFirstName());
	}
	
	@Test
	@DisplayName("Testing direct message entity mapping: get recipient's first name")
	void test4() {
		assertNotNull(dm);
		assertEquals(LocalDate.parse("2020-02-20"), dm.getDatePosted());
	}
	
	@Test
	@DisplayName("Testing direct message entity mapping: get message")
	void test5() {
		assertNotNull(dm);
		assertEquals("Hey John! Good to have you here.", dm.getMessage());
	}
	
	

}
