package com.filmland.springbootstarter.dbrepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.filmland.springbootstarter.dto.AvailableCategories;

@Repository
public interface CategoryRepository extends CrudRepository<AvailableCategories, String> {
}
