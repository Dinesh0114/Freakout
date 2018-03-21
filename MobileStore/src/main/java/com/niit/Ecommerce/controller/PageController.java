package com.niit.Ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.DAO.CategoryDAO;
import com.niit.model.Category;

@Controller
public class PageController {
	@Autowired
	private CategoryDAO categoryDAO;
	@RequestMapping(value="/Home")
	public String homePage(){
/*		System.out.println("this method is triggered");
		List<Category> listcategory = categoryservice.getCategories();
		System.out.println(listcategory);
		m.addAttribute("categories", listcategory);*/
		return "Home";
	}
	@RequestMapping("/LandingPage")
	public String Page(Model m){
		System.out.println("this method is triggered");
		List<Category> listcategory = categoryDAO.getCategories();
		System.out.println(listcategory);
		m.addAttribute("categories", listcategory);
		/*m.addAttribute("categories",categoryservice.getCategories());*/
		return "Home";
	}
	@RequestMapping("/Login")
	public String Login(){
		return "Login";
	}
		
		@RequestMapping("/Aboutus")
		public String showAboutUs()
		{
			return "AboutUs";
		}
		@RequestMapping("/ContactUs")
		public String showContactUs()
		{
			return "ContactUs";
		}
}
