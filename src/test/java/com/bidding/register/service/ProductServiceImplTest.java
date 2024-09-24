package com.bidding.register.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bidding.register.Entity.Product;
import com.bidding.register.exception.ProductUpdateException;
import com.bidding.register.repository.ProductRepository;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    private Product product;

    @BeforeEach
    void setUp() {
        product = new Product();
        product.setProductId(1L);
        product.setVendorId(1L);
    }

    @Test
    void testCreateProduct() {
        when(productRepository.save(product)).thenReturn(product);

        Product result = productService.createProduct(product);

        assertNotNull(result);
        assertEquals(product.getProductId(), result.getProductId());
        verify(productRepository).save(product);
    }

    @Test
    void testGetProductById() {
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));

        Optional<Product> result = productService.getProductById(1L);

        assertTrue(result.isPresent());
        assertEquals(product.getProductId(), result.get().getProductId());
    }

    @Test
    void testGetProductsByVendorId() {
        List<Product> products = Arrays.asList(product);
        when(productRepository.findByVendorId(1L)).thenReturn(products);

        List<Product> result = productService.getProductsByVendorId(1L);

        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
        assertEquals(product.getProductId(), result.get(0).getProductId());
    }

    @Test
    void testUpdateProduct() {
        when(productRepository.getById(1L)).thenReturn(product);
        when(productRepository.save(product)).thenReturn(product);

        Product result = productService.updateProduct(product);

        assertNotNull(result);
        assertEquals(product.getProductId(), result.getProductId());
        verify(productRepository).save(product);
    }

    @Test
    void testUpdateProductThrowsException() {
        Product existingProduct = new Product();
        existingProduct.setProductId(1L);
        existingProduct.setVendorId(2L);

        when(productRepository.getById(1L)).thenReturn(existingProduct);

        assertThrows(ProductUpdateException.class, () -> productService.updateProduct(product));
    }

    @Test
    void testDeleteProduct() {
        productService.deleteProduct(1L);

        verify(productRepository).deleteById(1L);
    }
}
