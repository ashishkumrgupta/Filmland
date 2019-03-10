package com.filmland.springbootstarter.dbrepository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.filmland.springbootstarter.dto.SubscribedCategories;

@Repository
public interface SubscriptionRepository extends CrudRepository<SubscribedCategories, String> {
	public List<SubscribedCategories> findByemailId(String emailId);

	public List<SubscribedCategories> findByemailIdAndCategoryName(String emailId, String categoryName);
}
