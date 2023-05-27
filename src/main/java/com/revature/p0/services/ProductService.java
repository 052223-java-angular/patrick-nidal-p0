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


}
