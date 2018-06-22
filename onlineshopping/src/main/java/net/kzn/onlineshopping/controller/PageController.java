package net.kzn.onlineshopping.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.kzn.onlineshopping.exception.ProductNotFoundException;
import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dao.ProductDAO;
import net.kzn.shoppingbackend.dto.Category;
import net.kzn.shoppingbackend.dto.Product;


@Controller
public class PageController {
	
	private static final Logger logger=LoggerFactory.getLogger(PageController.class);
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
@RequestMapping(value={"/","/home","/index"})
public ModelAndView index()
{
	logger.info("inside page controller methos Info");
	logger.debug("inside page controller methos debug");
	ModelAndView mv=new ModelAndView("page");
	mv.addObject("userClickHome", true);
	mv.addObject("title", "Home");
	mv.addObject("categories",categoryDAO.list());
	return mv;	
}
@RequestMapping(value="/about")
public ModelAndView about()
{
	ModelAndView mv=new ModelAndView("page");
	mv.addObject("userClickAbout", true);
	mv.addObject("title", "About us");
	return mv;	
}

@RequestMapping(value="/contact")
public ModelAndView contact()
{
	ModelAndView mv=new ModelAndView("page");
	mv.addObject("userClickContact", true);
	mv.addObject("title", "Contact Us");
	return mv;	
}

/*
 * mathods to load the products based on category
 * */
@RequestMapping(value="/show/all/products")
public ModelAndView showAllProducts()
{
	ModelAndView mv=new ModelAndView("page");
	mv.addObject("userClickAllProducts", true);
	mv.addObject("title", "All Products");
	mv.addObject("categories",categoryDAO.list());
	return mv;	
}
@RequestMapping(value="/show/category/{id}/products")
public ModelAndView showCategoryProducts(@PathVariable("id") int id)
{
	ModelAndView mv=new ModelAndView("page");
	
	//CategoryDAO to fetch category
	Category category=null;
	category=categoryDAO.get(id);
	
	mv.addObject("userClickCategoryProducts", true);
	mv.addObject("title", category.getName());
	mv.addObject("categories",categoryDAO.list());
	mv.addObject("category",category);
	return mv;	
}

/*
 * view single page
 * */
@RequestMapping(value="/show/{id}/product")
public ModelAndView showSingleProduct(@PathVariable int id) throws ProductNotFoundException
{
	ModelAndView mv=new ModelAndView("page");
	Product product=productDAO.get(id);
	
	if(product==null) throw new ProductNotFoundException();
	
	//update the view count
	product.setViews(product.getViews()+1);
	productDAO.update(product);
	mv.addObject("title",product.getName());
	mv.addObject("product",product);
	mv.addObject("userClickShowProduct",true);
	
	return mv;
}

/*@RequestMapping(value="/test")
public ModelAndView test(@RequestParam(value="greeting", required=false)String greeting)
{
	if(greeting==null)
	{
		greeting="hello";
	}
	ModelAndView mv=new ModelAndView("page");
	mv.addObject("greeting", greeting);
	return mv;	
}*/
/*@RequestMapping(value="/test/{greeting}")
public ModelAndView test(@PathVariable("greeting")String greeting)
{
	if(greeting==null)
	{
		greeting="hello";
	}
	ModelAndView mv=new ModelAndView("page");
	mv.addObject("greeting", greeting);
	return mv;	
}*/
}
