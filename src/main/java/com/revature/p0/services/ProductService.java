package com.revature.p0.services;

import com.revature.p0.daos.ProductDAO;
import com.revature.p0.models.CartItems;
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

    //for checkout - product onhand check
    public boolean isValidCheckout(List<CartItems> sessionCart) {
        for(CartItems item : sessionCart) {
            if(item.getQuantity() > productDao.checkOnHand(item.getProductId())) {
                return false;
            }
        }
        return true;
    }

    public void removeItemsFromOnHand(List<CartItems> sessionCart) {
        for(CartItems item : sessionCart) {
           int onHand = productDao.checkOnHand(item.getProductId());
           int newQuantity = onHand - item.getQuantity();
           productDao.updateByQuantity(newQuantity, item.getProductId());
        }
    }


}
