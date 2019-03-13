package com.filmland.springbootstarter.dbrepository;

import org.springframework.data.repository.CrudRepository;

import com.filmland.springbootstarter.dto.SharedCategory;

public interface ShareCategoryRepository extends CrudRepository<SharedCategory, String> {

}
