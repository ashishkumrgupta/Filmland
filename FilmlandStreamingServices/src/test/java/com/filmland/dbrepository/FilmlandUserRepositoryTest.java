package com.filmland.dbrepository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.filmland.dto.FilmlandUser;

@RunWith(SpringRunner.class)
@DataJpaTest
public class FilmlandUserRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private FilmlandUserRepository filmlandUserRepository;

	@Test
	public void test_FindByEmail() {
		FilmlandUser user = new FilmlandUser("testEmail", "testPassword");
		entityManager.persist(user);
		entityManager.flush();

		Optional<FilmlandUser> result = filmlandUserRepository.findById(user.getEmail());

		assertThat(result.get()).isEqualTo(user);
	}

}
