package org.generation.products.service;

import lombok.RequiredArgsConstructor;
import org.generation.products.model.Product;
import org.generation.products.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getAllProducts() {

        return productRepository.findAll();
    }

    public Product saveProduct(Product product) {

        return productRepository.save(product);
    }

    public Optional<Product> getProductoById(Long id){
        return  productRepository.findById(id);
    }

    public Product updateProduct(Long id, Product details){
        Product existing = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con id: " + id));
        existing.setName(details.getName());
        existing.setDescription(details.getDescription());
        existing.setPrice(details.getPrice());
        existing.setStock(details.getStock());
        return  productRepository.save(existing);
    }

    public void deleteProduct(long id){
        if (!productRepository.existsById(id)){
            throw new RuntimeException("Producto no encontrado con id: " + id);
        }
        productRepository.deleteById(id);
    }

}
