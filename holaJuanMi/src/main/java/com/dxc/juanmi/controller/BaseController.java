package com.dxc.juanmi.controller;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dxc.juanmi.calculator.Calculator;
import com.dxc.juanmi.calculator.ICalculator;

@Controller
public class BaseController {

	private static int counter = 0;
	private static final String VIEW_INDEX = "index";
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(BaseController.class);
	private static ICalculator calculator;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(ModelMap model) {

		int contador = ++counter;
		model.addAttribute("message", "Hello Juanmi!!");
		model.addAttribute("counter", contador);
		logger.debug("[welcome] counter : {}", contador);
		
		
		calculator = new Calculator();
		
		
		int suma = calculator.sum(contador, 1);
		model.addAttribute("suma", suma);
		logger.info("suma", suma);
		
		
		int resta = calculator.subtraction(contador, 1);
		model.addAttribute("resta", resta);
		logger.info("resta", resta);
		
		
		int multiplicacion = calculator.multiplication(contador, 2);
		model.addAttribute("multiplicacion", multiplicacion);
		logger.info("multiplicacion", multiplicacion);
		
		
		int division;
		try {
			division = calculator.divison(contador, 2);
			model.addAttribute("division", division);
			logger.info("division", division);				
		} catch (Exception e) {
			model.addAttribute("division", "ERROR");
			logger.info("division", "ERROR");	
		}
		
		// Spring uses InternalResourceViewResolver and return back index.jsp
		return VIEW_INDEX;

	}

	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public String welcomeName(@PathVariable String name, ModelMap model) {

		model.addAttribute("message", "Welcome " + name);
		model.addAttribute("counter", ++counter);
		logger.debug("[welcomeName] counter : {}", counter);
		return VIEW_INDEX;

	}

	/*
	@RequestMapping(value = "/operacion/{valor}", method = RequestMethod.GET)
	public String operacion(@PathVariable String valor, ModelMap model) {

		System.out.println("VALOR: " + valor);
		
		calculator = new Calculator();
		
		
		int suma = calculator.sum(counter, 1);
		model.addAttribute("suma", suma);
		logger.info("suma", suma);
		
		
		int resta = calculator.subtraction(counter, 1);
		model.addAttribute("resta", resta);
		logger.info("resta", resta);
		
		
		int multiplicacion = calculator.multiplication(counter, 2);
		model.addAttribute("multiplicacion", multiplicacion);
		logger.info("multiplicacion", multiplicacion);
		
		
		int division;
		try {
			division = calculator.divison(counter, 2);
			model.addAttribute("division", division);
			logger.info("division", division);				
		} catch (Exception e) {
			model.addAttribute("division", "ERROR");
			logger.info("division", "ERROR");	
		}
	
		model.addAttribute("counter", ++counter);
		
		return VIEW_INDEX;

	}	*/
	
}
