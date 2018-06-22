package net.kzn.shoppingbackend.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dto.Category;

public class CategoryTestCase {
	private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDAO;
	private Category category;
	@BeforeClass
	public static void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("net.kzn.shoppingbackend");
		context.refresh();
		categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
	}
	/*@Test
	public void testAddCategory()
	{
		category=new Category();
		category.setName("television");
		category.setDescription("Description for television");
		category.setImageUrl("CAT_1.png");
		assertEquals("Successfully added",true,categoryDAO.add(category));
	}*/
	
	/*@Test
	public void testGetCategory()
	{
		category=categoryDAO.get(1);
		assertEquals("television",category.getName());
	}*/
	/*@Test
	public void testUpdateCategory()
	{
		category=categoryDAO.get(1);
		category.setName("TV");
		assertEquals(true,categoryDAO.update(category));
	}*/
	/*@Test
	public void testDeleteCategory()
	{
		category=categoryDAO.get(1);		
		assertEquals(true,categoryDAO.delete(category));
	}*/
	/*@Test
	public void testListCategory()
	{
			
		assertEquals(2,categoryDAO.list().size());
	}*/
	
	@Test
	public void testCRUD()
	{
		//adding
		category=new Category();
		category.setName("Lapotp");
		category.setDescription("Description for Laptop");
		category.setImageUrl("CAT_2.png");
		assertEquals("Successfully added",true,categoryDAO.add(category));
		
		category=new Category();
		category.setName("television");
		category.setDescription("Description for television");
		category.setImageUrl("CAT_1.png");
		assertEquals("Successfully added",true,categoryDAO.add(category));
		
		
		//fetching
		category=categoryDAO.get(2);
		category.setName("TV");
		assertEquals(true,categoryDAO.update(category));
		
		//deleting
		category=categoryDAO.get(2);		
		assertEquals(true,categoryDAO.delete(category));
		
		//list
		assertEquals(1,categoryDAO.list().size());
	}
}
