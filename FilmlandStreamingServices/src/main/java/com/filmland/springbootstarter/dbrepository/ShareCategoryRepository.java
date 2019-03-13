package com.filmland.springbootstarter.dbrepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.filmland.springbootstarter.dto.SharedCategory;

@Repository
public interface ShareCategoryRepository extends CrudRepository<SharedCategory, String> {

}
