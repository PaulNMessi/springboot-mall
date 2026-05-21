package com.messi.springbootmall.dao;

import com.messi.springbootmall.constant.ProductCategory;
import com.messi.springbootmall.dto.ProductRequest;
import com.messi.springbootmall.model.Product;

import java.util.List;

public interface ProductDao {

    List<Product> getProducts(ProductCategory category, String search);

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);
}
