package com.filmland.dbrepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.filmland.dto.FilmlandUser;

@Repository
public interface UserRepository extends CrudRepository<FilmlandUser, String> {

}
