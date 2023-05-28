package com.revature.p0.services;

import com.revature.p0.daos.ProductDAO;
import com.revature.p0.models.Product;

import java.util.List;

public class ProductService {

    private final ProductDAO productDao;


    public ProductService(ProductDAO productDao) {
        this.productDao = productDao;
    }

    public List<Product> getAllProducts() {
        return productDao.findAll();
    }

    //searching by category, name, price range
    public List<Product> getProductByCategory(String category) {
        return productDao.findProductByCategory(category);
    }

    public List<Product> getProductByName(String name) {
        System.out.println("Printing!");
        return productDao.findProductByName(name);
    }

    public List<Product> getProductByPriceRange(double priceLower, double priceUpper) {
        return productDao.findProductByPriceRange(priceLower, priceUpper);
    }



}
