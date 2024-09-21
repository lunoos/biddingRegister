package com.bidding.register.service;

import java.util.List;
import java.util.Optional;

import com.bidding.register.Entity.Product;

public interface ProductService {

	public Product createProduct(Product product);

    public Optional<Product> getProductById(Long productId);

    public List<Product> getProductsByVendorId(Long vendorId);

    public Product updateProduct(Product product);

    public void deleteProduct(Long productId);
}
