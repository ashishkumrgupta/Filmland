package com.filmland.dbrepository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.filmland.dto.AvailableCategories;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryTest {

	@Autowired
	private TestEntityManager testEntityManager;

	@Autowired
	private CategoryRepository categoryRepository;

	@Test
	public void test_findCategoryName() {
		AvailableCategories availableCategories = new AvailableCategories("testCategory", "10", "6");
		testEntityManager.persist(availableCategories);
		testEntityManager.flush();

		Optional<AvailableCategories> result = categoryRepository.findById(availableCategories.getCategoryName());

		assertThat(result.get()).isEqualTo(availableCategories);
	}

}
