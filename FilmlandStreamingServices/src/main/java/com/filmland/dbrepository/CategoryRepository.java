package com.filmland.dbrepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.filmland.dto.AvailableCategories;

@Repository
public interface CategoryRepository extends CrudRepository<AvailableCategories, String> {
}
