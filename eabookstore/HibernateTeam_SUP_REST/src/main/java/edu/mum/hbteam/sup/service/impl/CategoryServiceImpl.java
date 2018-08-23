package edu.mum.hbteam.sup.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.hbteam.sup.dao.CategoryDao;
import edu.mum.hbteam.sup.domain.Category;
import edu.mum.hbteam.sup.service.CategoryService;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryDao categoryDao;
	
	@Override
	public void save(Category category) {
		// TODO Auto-generated method stub
		categoryDao.save(category);
	}

	@Override
	public void update(Category category) {
		// TODO Auto-generated method stub
		categoryDao.update(category);
	}

	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return categoryDao.findAll();
	}

	@Override
	public Category findOne(Long id) {
		// TODO Auto-generated method stub
		return categoryDao.findOne(id);
	}

}
