package edu.mum.hbteam.sup.service;

import java.util.List;

import edu.mum.hbteam.sup.domain.Category;

public interface CategoryService {
	public void save(Category category);

	public void update(Category category);

	public List<Category> findAll();

	public Category findOne(Long id);
}
