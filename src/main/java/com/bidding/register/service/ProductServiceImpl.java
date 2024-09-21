package com.bidding.register.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bidding.register.Entity.Product;
import com.bidding.register.exception.ProductUpdateException;
import com.bidding.register.repository.ProductRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;

	@Transactional
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Optional<Product> getProductById(Long productId) {
        return productRepository.findById(productId);
    }

    public List<Product> getProductsByVendorId(Long vendorId) {
        return productRepository.findByVendorId(vendorId);
    }

    /**
     * Vendor cannot be updated in a product.
     */
    @Transactional
    public Product updateProduct(Product product) {
    	Product extProdt = productRepository.getById(product.getProductId());
    	if(extProdt.getVendorId()!=product.getProductId())
    		throw new ProductUpdateException("A vendor cannot be updated for a existing product");
        return productRepository.save(product);
    }

    @Transactional
    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }
}