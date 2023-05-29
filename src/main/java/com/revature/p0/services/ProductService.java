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

    public List<Product> getProductByCategory(String category) {
        return productDao.findProductByCategory(category);
    }

    public List<Product> getProductByName(String name) {
        return productDao.findProductByName(name);
    }

    public List<Product> getProductByPriceRange(double priceLower, double priceUpper) {
        return productDao.findProductByPriceRange(priceLower, priceUpper);
    }


}
