package edu.mum.hbteam.inv.service;

import java.util.List;

import edu.mum.hbteam.inv.domain.Category;

public interface CategoryService {

	List<Category> getAllCategorys();

  	void save(Category category);

	Category findOne(long id);
 
	void add(Category category);
	
	void update(Category category);

}
