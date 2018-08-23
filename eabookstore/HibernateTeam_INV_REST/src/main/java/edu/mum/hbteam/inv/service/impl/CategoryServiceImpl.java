package edu.mum.hbteam.inv.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.hbteam.inv.dao.CategoryDao;
import edu.mum.hbteam.inv.domain.Category;
import edu.mum.hbteam.inv.service.CategoryService;

@Service
@Transactional 
public class CategoryServiceImpl implements CategoryService{
	
 	@Autowired
	private CategoryDao categoryDao;

	public List<Category> getAllCategorys() {
		return categoryDao.findAll();
	}

 
    @PreAuthorize("hasRole('ROLE_ADMIN')")
	public void save(Category category) {
		   categoryDao.save(category);
	}
	
	public Category findOne(long categoryID) {
		return categoryDao.findOne(categoryID);
	}

	@Override
	public void add(Category category) {
		categoryDao.save(category);
	}

	@Override
	public void update(Category category) {
		categoryDao.update(category);
	}

}
