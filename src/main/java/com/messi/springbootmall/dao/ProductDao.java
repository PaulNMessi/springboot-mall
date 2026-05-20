package com.messi.springbootmall.dao;

import com.messi.springbootmall.dto.ProductRequest;
import com.messi.springbootmall.model.Product;

public interface ProductDao {

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

}
