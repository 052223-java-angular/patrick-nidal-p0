package com.revature.p0.services;

import com.revature.p0.daos.CartDAO;
import com.revature.p0.daos.CartItemsDAO;
import com.revature.p0.models.CartItems;
import com.revature.p0.models.Product;
import java.util.List;

public class CartItemService {
    private final CartItemsDAO cartItemsDAO;

    public CartItemService(CartItemsDAO cartItemsDAO) {
        this.cartItemsDAO = cartItemsDAO;
    }

    public void insertItems(CartItems cartItems) {
        cartItemsDAO.createCartItems(cartItems);
    }

    public List<CartItems> getAllCartItems(String cartId) {
        return cartItemsDAO.findAllByCartId(cartId);
    }

    public void cartQuantityRemoval(int quantityChoice, double price, String Id) {
        cartItemsDAO.cartQuantityRemoval(quantityChoice, price, Id);
    }

    public void removeItemsFromCart(List<CartItems> sessionCart) {
        for(CartItems item : sessionCart) {
            cartItemsDAO.deleteByProductId(item.getProductId());
        }
    }

}
