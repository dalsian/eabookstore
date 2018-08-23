package edu.mum.hbteam.sup.dao.impl;

import org.springframework.stereotype.Repository;

import edu.mum.hbteam.sup.dao.CategoryDao;
import edu.mum.hbteam.sup.domain.Category;

@Repository
public class CategoryDaoImpl extends GenericDaoImpl<Category> implements CategoryDao{
	public CategoryDaoImpl() {
		super.setDaoType(Category.class);
	}
}
