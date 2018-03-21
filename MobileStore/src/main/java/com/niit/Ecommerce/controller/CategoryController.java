package com.niit.Ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.DAO.CategoryDAO;
import com.niit.model.Category;
@Controller
public class CategoryController {
	@Autowired
	private CategoryDAO categoryDAO;
	/*@RequestMapping("/category")
	public String show() {
		return "Category";
	}*/
	@RequestMapping("/category")
	public String show(Model m){
		List<Category> listcategory = categoryDAO.getCategories();
        for (Category cat : listcategory) {
		System.out.println(cat.getCategoryName() + ",");
		}
		m.addAttribute("listCategory", listcategory);
		return "Category";
	}
	
	@RequestMapping("/InsertCategory")
	public String addProducts(@RequestParam("catname") String catname, @RequestParam("catdesc") String catdesc, ModelMap model) {
		Category category=new Category();
		category.setCategoryName(catname);
		category.setCategoryDesc(catdesc);
		categoryDAO.addCategory(category);
		List<Category> listcategory = categoryDAO.getCategories();
		model.addAttribute("listCategory", listcategory);
		return "Category";			
	}
	@RequestMapping("/updateCategory/{categoryId}")
	public String updateCategory(@PathVariable("categoryId") int categoryId,Model m)
	{
		Category category=categoryDAO.getCategory(categoryId);		
		List<Category> listCategories=categoryDAO.getCategories();
		m.addAttribute("listCategory",listCategories);
		m.addAttribute("categoryInfo",category);
		return "UpdateCategory";
	}

	
	@RequestMapping(value="/UpdateCategory",method=RequestMethod.POST)
	public String updateCategoryInDB(@RequestParam("catid") int categoryId,@RequestParam("catname") String catname,@RequestParam("catdesc") String catdesc,Model m)
	{
		Category category=categoryDAO.getCategory(categoryId);
		category.setCategoryName(catname);
        category.setCategoryDesc(catdesc);
		categoryDAO.updateCategory(category);
		List<Category> listCategories=categoryDAO.getCategories();
		m.addAttribute("listCategory",listCategories);
		return "Category";
	}
	@RequestMapping("/deleteCategory/{categoryId}")
	public String deleteCategory(@PathVariable("categoryId") int categoryId,Model m)
	{
		Category category=categoryDAO.getCategory(categoryId);		
		categoryDAO.deleteCategory(category);		
		List<Category> listCategories=categoryDAO.getCategories();
		m.addAttribute("listCategory",listCategories);
		return "Category";
	}
	
//	@RequestMapping("/category")
//	public String showCategory(Model m) {
//		List<Category> listcategory = categoryservice.getCategories();
//		for (Category cat : listcategory) {
//			System.out.println(cat.getCategoryName() + ",");
//		}
//		m.addAttribute("listcategory", listcategory);
//		return "Category";
//	}*/
	
}
