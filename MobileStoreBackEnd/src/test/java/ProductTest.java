import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.ProductDAO;
import com.niit.model.Product;



public class ProductTest {
	static ProductDAO productDAO;
	@BeforeClass
	public static void executeFirst()
	{
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		productDAO=(ProductDAO)context.getBean("productDAO");
	}
	
	@Test
	public void addProductTest()
	{
		Product product=new Product();
		product.setProductId(1);
		product.setProductName("Virat");
		product.setProductCost(2001);
		product.setProductStock(100);
		product.setProductDesc("find");
		assertTrue("Problem in Product Insertion",productDAO.addProduct(product));
	}
	

	@Test
	public void getProductTest()
	{
		assertNotNull("Problem in get Category",productDAO.getProduct(1));
	}
	
	
	@Test
	public void deleteProductTest()
	{
		Product product=productDAO.getProduct(3);
		assertTrue("Problem in Deletion:",productDAO.deleteProduct(product));
	}

	@Test
	public void updateProductTest()
	{
		Product product=productDAO.getProduct(1);
		product.setProductName("Headset");
		assertTrue("Problem in Updation",productDAO.updateProduct(product));
	}
	
	

	@Test
	public void listProductsTest()
	{
		List<Product> listProduct=productDAO.getAllProducts();
		assertNotNull("No Products",listProduct);
		
		for(Product product:listProduct)
		{
			System.out.print(product.getProductId()+":::");
			System.out.print(product.getProductName()+":::");
			System.out.println(product.getProductCost());
			System.out.println(product.getProductStock());
			System.out.println(product.getProductDesc());
		}
	}

}
