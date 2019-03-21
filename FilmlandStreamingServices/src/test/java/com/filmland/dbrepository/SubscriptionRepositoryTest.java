package com.filmland.dbrepository;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.filmland.dto.SubscribedCategories;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SubscriptionRepositoryTest {

	@Autowired
	private TestEntityManager testEntityManager;

	@Autowired
	private SubscriptionRepository subscriptionRepository;

	private SubscribedCategories subscribedCategories;

	@Before
	public void setUp() {
		this.subscribedCategories = new SubscribedCategories("testEmail", "testCategory", "4", "8", "Y",
				LocalDate.now(), "Y");
		testEntityManager.persist(subscribedCategories);
		testEntityManager.flush();
	}

	@Test
	public void test_findByemailId() {

		List<SubscribedCategories> result = subscriptionRepository.findByemailId("testEmail");

		assertEquals(1, result.size());
		assertEquals(subscribedCategories, result.get(0));
	}

	@Test
	public void test_findByemailIdAndCategoryName() {

		List<SubscribedCategories> result = subscriptionRepository.findByemailIdAndCategoryName("testEmail",
				"testCategory");

		assertEquals(1, result.size());
		assertEquals(subscribedCategories, result.get(0));
	}

}
