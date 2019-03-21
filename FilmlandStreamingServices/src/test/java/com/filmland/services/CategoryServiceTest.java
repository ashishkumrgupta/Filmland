package com.filmland.services;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.filmland.dbrepository.CategoryRepository;
import com.filmland.dbrepository.SubscriptionRepository;
import com.filmland.dto.AvailableCategories;
import com.filmland.dto.SubscribedCategories;

@RunWith(SpringRunner.class)
public class CategoryServiceTest {

	@TestConfiguration
	static class CategoryServiceImplTestContextConfiguration {

		@Bean
		public CategoryService categoryService() {
			return new CategoryService();
		}
	}

	@Autowired
	private CategoryService categoryService;

	@MockBean
	private SubscriptionRepository subscriptionRepository;

	@MockBean
	private CategoryRepository categoryRepository;

	@Before
	public void setUp() {
		SubscribedCategories subscribedCategories = new SubscribedCategories("testEmail", "testCategory", "4", "8", "Y",
				LocalDate.now(), "Y");
		AvailableCategories availableCategories1 = new AvailableCategories("testCategory1", "4", "8");
		AvailableCategories availableCategories2 = new AvailableCategories("testCategory2", "4", "8");

		Mockito.when(categoryRepository.findById("testCategory1")).thenReturn(Optional.of(availableCategories1));

		Mockito.when(subscriptionRepository.findByemailId("testEmail"))
				.thenReturn((Arrays.asList(subscribedCategories)));

		Mockito.when(categoryRepository.findAll())
				.thenReturn(Arrays.asList(availableCategories1, availableCategories2));
	}

	@Test
	public void test_GetUserSubscribedCategories() {
		List<SubscribedCategories> result = categoryService.getUserSubscribedCategories("testEmail");
		assertThat(result.size()).isEqualTo(1);
	}

	@Test
	public void test_AvailableCategories() {
		List<AvailableCategories> result = categoryService.getAllAvailableCategories();
		assertThat(result.size()).isEqualTo(2);
	}

	@Test
	public void test_GetCategoryDetailsBasedOnCategory() {
		AvailableCategories result = categoryService.getCategoryDetailsBasedOnCategory("testCategory1");
		assertThat(result.getCategoryName()).isEqualTo("testCategory1");
		assertThat(result.getAvaialbleContent()).isEqualTo("4");
		assertThat(result.getPrice()).isEqualTo("8");
	}
}
