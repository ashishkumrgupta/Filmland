package com.filmland.springbootstarter.dbrepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.filmland.springbootstarter.dto.FilmlandUser;

@Repository
public interface FilmlandUserRepository extends CrudRepository<FilmlandUser, String> {

}
