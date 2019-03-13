package com.filmland.dbrepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.filmland.dto.SharedCategory;

@Repository
public interface ShareCategoryRepository extends CrudRepository<SharedCategory, String> {

}
