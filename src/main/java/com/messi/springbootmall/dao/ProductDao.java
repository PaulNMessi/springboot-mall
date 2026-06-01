package com.messi.springbootmall.dao;

import com.messi.springbootmall.constant.ProductCategory;
import com.messi.springbootmall.dto.ProductQueryParams;
import com.messi.springbootmall.dto.ProductRequest;
import com.messi.springbootmall.model.Product;

import java.util.List;

public interface ProductDao {

    Integer countProduct(ProductQueryParams productQueryParams);

    List<Product> getProducts(ProductQueryParams  productQueryParams);

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void updateStock(Integer productId, Integer stock);

    void deleteProductById(Integer productId);
}
