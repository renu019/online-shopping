package net.kzn.onlineshopping.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {

	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFoundException()
	{
		ModelAndView mv=new ModelAndView("error");
		mv.addObject("errorTitle","The page is not constructed");
		mv.addObject("errorDescription","The page you are looking for is not available");
		mv.addObject("title","404 error page");
		return mv;
	}
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handlerProductNotFoundException()
	{
		ModelAndView mv=new ModelAndView("error");
		mv.addObject("errorTitle","The product is not constructed");
		mv.addObject("errorDescription","The product you are looking for is not available");
		mv.addObject("title","page unavialable");
		return mv;
	}
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception ex)
	{
		ModelAndView mv=new ModelAndView("error");
		mv.addObject("errorTitle","Error!!! contact your administer");
		mv.addObject("errorDescription",ex.toString());
		mv.addObject("title","page Error");
		return mv;
	}
}
