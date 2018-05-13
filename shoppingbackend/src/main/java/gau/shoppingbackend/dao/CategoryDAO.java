package gau.shoppingbackend.dao;

import java.util.List;

import gau.shoppingbackend.dto.Category;

public interface CategoryDAO {
	List<Category>list();
	Category get(int id);
}
