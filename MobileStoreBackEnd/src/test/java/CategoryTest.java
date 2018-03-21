import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.CategoryDAO;
import com.niit.model.Category;

public class CategoryTest {
	static CategoryDAO categoryDAO;
	@BeforeClass
	public static void executeFirst()
	{
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
	}
	
	@Test
	public void addCategoryTest()
	{
		Category category=new Category();
		category.setCategoryName("Iphone");
		category.setCategoryDesc("Iplanet");
		
		assertTrue("Problem in Category Insertion",categoryDAO.addCategory(category));
	}
	
	
	@Test
	public void getCategoryTest()
	{
		assertNotNull("Problem in get Category",categoryDAO.getCategory(4));
	
	}
	
	
	@Test
	public void deleteCategoryTest()
	{
		Category category=categoryDAO.getCategory(1);
		assertTrue("Problem in Deletion:",categoryDAO.deleteCategory(category));
		
	}

	@Test
	public void updateCategoryTest()
	{

		Category category=categoryDAO.getCategory(3);
		category.setCategoryName("L Sofa Model");
		assertTrue("Problem in Updation",categoryDAO.updateCategory(category));
		
	}
	
	@Test
	public void listCategoriesTest()
	{
		List<Category> listCategories=categoryDAO.getCategories();
		assertNotNull("No Categories",listCategories);
		
		for(Category category:listCategories)
		{
			System.out.print(category.getCategoryId()+":::");
			System.out.print(category.getCategoryName()+":::");
			System.out.println(category.getCategoryDesc());
		}
		
	}
}
