package net.kzn.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dto.Category;

@Repository("categoryDAO") 
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> categories=new ArrayList<>();
	@Autowired
	private SessionFactory sessionFactory;
	//this was for static
	/*static{
		Category category=new Category();
		category.setId(1);
		category.setName("television");
		category.setDescription("Description for television");
		category.setImageUrl("CAT_1.png");
		categories.add(category);
		
		category=new Category();
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("Description for Mobile");
		category.setImageUrl("CAT_2.png");
		categories.add(category);
		
		category=new Category();
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("Description for Laptop");
		category.setImageUrl("CAT_3.png");
		categories.add(category);
		
	}*/
	@Override
	public List<Category> list() {
		String selectActiveCategory="FROM Category WHERE active=:active";
		Query query=sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		query.setParameter("active", true);
		return query.getResultList();
		//return categories;
	}
	//getting single category based on id
	@Override
	public Category get(int id) {
		// TODO Auto-generated method stub
		//this was for static
		/*for(Category category:categories)
		{
			if(category.getId()==id) return category;
		}*/
		return sessionFactory.getCurrentSession().get(Category.class,Integer.valueOf(id));
	}
	/*
	 * add the category
	 * */
	@Override	
	public boolean add(Category category) {
				
		try
		{
			sessionFactory.getCurrentSession().persist(category);
			return true;
		}
		catch(Exception ex)
		{
			return false;
		}
		
	}
	/*
	 * update the category
	 * */
	@Override
	public boolean update(Category category) {
		
		try
		{
			sessionFactory.getCurrentSession().update(category);
			return true;
		}
		catch(Exception ex)
		{
			return false;
		}
	}
	@Override
	public boolean delete(Category category) {
		category.setActive(false);
		try
		{
			sessionFactory.getCurrentSession().update(category);
			return true;
		}
		catch(Exception ex)
		{
			return false;
		}
	}

}
