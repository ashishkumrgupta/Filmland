package com.filmland.dbrepository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.filmland.dto.SubscribedCategories;

@Repository
public interface SubscriptionRepository extends CrudRepository<SubscribedCategories, String> {
	public List<SubscribedCategories> findByemailId(String emailId);

	public List<SubscribedCategories> findByemailIdAndCategoryName(String emailId, String categoryName);
	
	public List<SubscribedCategories> findBySubscriptionStatus(String status);
}
