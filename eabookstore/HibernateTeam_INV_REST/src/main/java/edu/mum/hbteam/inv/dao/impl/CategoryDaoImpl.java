package edu.mum.hbteam.inv.dao.impl;


import org.springframework.stereotype.Repository;

import edu.mum.hbteam.inv.dao.CategoryDao;
import edu.mum.hbteam.inv.domain.Category;

@Repository
public class CategoryDaoImpl extends GenericDaoImpl<Category> implements CategoryDao
{	
	public CategoryDaoImpl() {
		super.setDaoType(Category.class );
	}  
}

