package net.kzn.onlineshopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
@RequestMapping(value={"/","/home","/index"})
public ModelAndView index()
{
	ModelAndView mv=new ModelAndView("page");
	mv.addObject("userClickHome", true);
	mv.addObject("title", "Home");
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
