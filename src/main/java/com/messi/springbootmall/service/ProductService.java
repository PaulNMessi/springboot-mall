package com.messi.springbootmall.service;

import com.messi.springbootmall.dto.ProductRequest;
import com.messi.springbootmall.model.Product;

public interface ProductService {

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);
}
