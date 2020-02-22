package dev.richardnewman.cbmetrics.entities;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserAccountTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private UserAccount user;

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
		user = em.find(UserAccount.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		user = null;
	}

	@Test
	@DisplayName("Testing user account entity mapping: get email")
	void test1() {
		assertNotNull(user);
		assertEquals("rick@richardnewman.dev", user.getEmail());
	}
	
	@Test
	@DisplayName("Testing user account entity mapping: get id")
	void test2() {
		assertNotNull(user);
		assertEquals(1, user.getId());
	}
	@Test
	@DisplayName("Testing user account entity mapping: get password")
	void test3() {
		assertNotNull(user);
		assertEquals("$2y$10$qxijAYpoT7SFIOxoSj66F.CHyh51ZNxXc2EtLKu9hmmfSBLWeoT/i", user.getPassword());
	}
	@Test
	@DisplayName("Testing user account entity mapping: get timestamp")
	void test4() {
		assertNotNull(user);
		assertEquals(Timestamp.valueOf("2020-02-20 00:00:01"), user.getRegistrationTimestamp());
	}
	@Test
	@DisplayName("Testing user account entity mapping: get role")
	void test5() {
		assertNotNull(user);
		assertEquals("ADMIN", user.getRole());
	}
	@Test
	@DisplayName("Testing user account entity mapping: isEnabled")
	void test6() {
		assertNotNull(user);
		assertEquals(true, user.isEnabled());
	}

}
