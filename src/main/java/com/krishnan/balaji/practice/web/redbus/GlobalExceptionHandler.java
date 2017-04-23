package com.krishnan.balaji.practice.web.redbus;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	  @ExceptionHandler(value = Throwable.class)
	  public ModelAndView defaultErrorHandler(HttpServletRequest req, Throwable e) {
	    /*if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null)
	      throw e;*/
	    // Otherwise setup and send the user to a default error-view.
	    ModelAndView mav = new ModelAndView();
	    mav.getModelMap().put("exception", e);
	    mav.getModelMap().put("url", req.getRequestURL());
	    mav.setViewName("error_page");
	    return mav;
	  }

}
