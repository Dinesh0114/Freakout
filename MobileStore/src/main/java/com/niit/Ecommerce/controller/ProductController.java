package com.niit.Ecommerce.controller;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.DAO.CategoryDAO;
import com.niit.DAO.ProductDAO;
import com.niit.model.Category;
import com.niit.model.Product;



@Controller
public class ProductController {
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private CategoryDAO categoryDAO;

 	@RequestMapping(value="/all/getallproducts")
public ModelAndView getAllProducts(){
	List<Product> products=productDAO.getAllProducts();
	//System.out.println(products.get(0).getProductName());
	//productlist - logical view name [productlist.jsp]
	//products - model attribute [use this attribute in jsp]
	//products - List<Product> data 
	return new ModelAndView("viewProducts","productsAttr",products);
	//JSTL and EL 
}
	@RequestMapping("all/viewallproducts")
	public ModelAndView selectByCategory(@RequestParam String searchCondition,Model model){

	List<Product> listproduct = productDAO.getProductsbasedonCatId(Integer.parseInt(searchCondition));
	model.addAttribute("listproduct", listproduct);
	return new ModelAndView("viewProducts");
}
	
	@RequestMapping(value="/admin/addpro")
public String addProducts(@RequestParam("proname") String proname, @RequestParam("prodesc") String prodesc,  @RequestParam("procost") int procost,@RequestParam("stock") int stock,@RequestParam("categoryId") int catid,@RequestParam("img") MultipartFile filedet,ModelMap model) {
	Product product=new Product();
	product.setProductName(proname);
	product.setProductDesc(prodesc);
	product.setProductCost(procost);
	product.setProductStock(stock);
	product.setImg(filedet);
	product.setCategory(categoryDAO.getCategory(catid));
	
	productDAO.addProduct(product);
	
	String imagePath="C:\\Users\\sangeethkumar\\eclipse-workspace\\MobileStore\\src\\main\\webapp\\resources\\image";
	imagePath=imagePath+String.valueOf(product.getProductId())+".jpg";
	File image=new File(imagePath);
	
	if(!filedet.isEmpty())
	{			
		try 
		{
			byte[] fileBuffer=filedet.getBytes();	
			FileOutputStream fos=new FileOutputStream(image);
			BufferedOutputStream bs=new BufferedOutputStream(fos);
			bs.write(fileBuffer);
			bs.close();
		} catch (Exception e)
		{
			System.out.println("Exception Arised:"+e);
			e.printStackTrace();
		}		
	}
	else
	{
		System.out.println("Problem Occured in File Uploading");
	}
	
	List<Product> listProducts = productDAO.getAllProducts();
	List<Category> listCategories=categoryDAO.getCategories();
	model.addAttribute("listCategories", listCategories);
	model.addAttribute("listProducts", listProducts);
	return "addpro";			
}

@RequestMapping(value="/admin/add")
public String showProduct(Model m) {
	List<Product> listProducts = productDAO.getAllProducts();		
	List<Category> listCategories=categoryDAO.getCategories();
	m.addAttribute("listCategories", listCategories);
	m.addAttribute("listProducts", listProducts);
	return "addpro";
}
@RequestMapping(value="/admin/UpdateProduct",method=RequestMethod.POST)
public String updateProductInDB(@RequestParam("proid") int productId,@RequestParam("proname") String proname,@RequestParam("prodesc") String prodesc,@RequestParam("procost") int procost,@RequestParam("stock") int stock,Model m)
{
	Product product=productDAO.getProduct(productId);
	product.setProductName(proname);
	product.setProductDesc(prodesc);
	product.setProductCost(procost);
	product.setProductStock(stock);
	
	productDAO.updateProduct(product);
	List<Product> listProducts=productDAO.getAllProducts();
	m.addAttribute("listProducts",listProducts);
	return "addpro";
}

@RequestMapping(value="/admin/updateProduct/{productId}")
public String updateProduct(@PathVariable("productId") int productId,Model m)
{
	Product product=productDAO.getProduct(productId);		
	List<Product> listProducts=productDAO.getAllProducts();
	System.out.println("in product controller-------------");
	System.out.println(product.getProductName());
	System.out.println(listProducts.get(0).getProductDesc());
	m.addAttribute("listProducts",listProducts);
	m.addAttribute("productInfo",product);
	return "UpdateProduct";
}

@RequestMapping(value="/admin/deleteProduct/{productId}")
public String deleteProduct(@PathVariable("productId") int productId,Model m)
{	Product product=productDAO.getProduct(productId);		
	productDAO.deleteProduct(product);		
	List<Product> listProducts=productDAO.getAllProducts();
	m.addAttribute("listProducts",listProducts);
	return "addpro";
}
}
