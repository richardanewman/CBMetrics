package dev.richardnewman.cbmetrics.entities;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserProfileTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private UserProfile userProfile;

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
		userProfile = em.find(UserProfile.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		userProfile = null;
	}

	@Test
	@DisplayName("Testing user profile entity mapping: get bio")
	void test1() {
		assertNotNull(userProfile);
		assertEquals("Time to #makebank with ClickBank!", userProfile.getBio());
	}
	
	@Test
	@DisplayName("Testing user profile entity mapping: get id")
	void test2() {
		assertNotNull(userProfile);
		assertEquals(1, userProfile.getId());
	}
	@Test
	@DisplayName("Testing user profile entity mapping: get business name")
	void test3() {
		assertNotNull(userProfile);
		assertEquals("#MakeBank", userProfile.getBusiness());
	}
	@Test
	@DisplayName("Testing user profile entity mapping: get city")
	void test4() {
		assertNotNull(userProfile);
		assertEquals("Boise", userProfile.getCity());
	}
	@Test
	@DisplayName("Testing user profile entity mapping: get role")
	void test5() {
		assertNotNull(userProfile);
		assertEquals("Idaho", userProfile.getState());
	}
	@Test
	@DisplayName("Testing user profile entity mapping: ")
	void test6() {
		assertNotNull(userProfile);
		assertEquals("Richard", userProfile.getFirstName());
	}
	@Test
	@DisplayName("Testing user profile entity mapping: ")
	void test7() {
		assertNotNull(userProfile);
		assertEquals("Newman", userProfile.getLastName());
	}
	@Test
	@DisplayName("Testing user profile entity mapping: ")
	void test8() {
		assertNotNull(userProfile);
		assertEquals("https://avatars0.githubusercontent.com/u/17536735?s=400&u=566cc933a34bf6f72cc9e68b34968dcf182222e8&v=4", userProfile.getProfilePic());
	}
	@Test
	@DisplayName("Testing user profile entity mapping: ")
	void test9() {
		assertNotNull(userProfile);
		assertEquals("rick@richardnewman.dev", userProfile.getUser().getEmail());
	}

}
