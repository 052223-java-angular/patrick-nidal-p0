package com.revature.p0.services;

import com.revature.p0.daos.CategoryDAO;
import com.revature.p0.models.Category;

import java.util.List;

public class CategoryService {

    private final CategoryDAO categoryDAO;

    public CategoryService(CategoryDAO categoryDAO){
        this.categoryDAO = categoryDAO;
    }

    public List<Category> getAllCategories() {
        return categoryDAO.getAllCategories();
    }
}
