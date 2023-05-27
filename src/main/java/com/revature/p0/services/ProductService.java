package com.revature.p0.services;

import com.revature.p0.daos.ProductDAO;

public class ProductService {

    private final ProductDAO productDao;

    public ProductService(ProductDAO productDao) {
        this.productDao = productDao;
    }



}
