package com.messi.springbootmall.dao;

import com.messi.springbootmall.model.Product;

public interface ProductDao {

    Product getProductById(Integer productId);
}
