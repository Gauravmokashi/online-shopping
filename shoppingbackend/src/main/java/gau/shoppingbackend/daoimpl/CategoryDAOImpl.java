package gau.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import gau.shoppingbackend.dao.CategoryDAO;
import gau.shoppingbackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {
	private static List<Category> categories = new ArrayList<>();
	
	static {
		Category category = new Category();
		
		//adding 1st category
		category.setId(1);
		category.setName("Television");
		category.setDescription("1080*1020 full HD");
		category.setImageURL("cat1.png");
		
		categories.add(category);
		
		//adding 2nd category
		category = new Category();
		category.setId(2);
		category.setName("Mobile");
		category.setDescription("Android");
		category.setImageURL("cat2.png");
		
		categories.add(category);
		
		//adding 3rd category
		category = new Category();
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("intel i7");
		category.setImageURL("cat3.png");
		
		categories.add(category);
	}
	
	
	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}


	@Override
	public Category get(int id) {
		//enhanced for loop
		for(Category category : categories) {
			if(category.getId()==id) return category;
		}
		return null;
		}
	}


