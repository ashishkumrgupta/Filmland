package com.filmland.dbrepository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.filmland.dto.SharedCategory;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ShareCategoryRepositoryTest {

	@Autowired
	private TestEntityManager testEntityManager;

	@Autowired
	private ShareCategoryRepository shareCategoryRepository;

	@Test
	public void test_findById() {
		SharedCategory sharedCategory = new SharedCategory("testEmail", "testCustomer", "testCategory"); 
		testEntityManager.persist(sharedCategory);
		testEntityManager.flush();
		
		SharedCategory result = shareCategoryRepository.save(sharedCategory);
		
		assertThat(result).isEqualTo(sharedCategory);
	}
}
