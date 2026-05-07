package org.generation.products.controller;

import lombok.RequiredArgsConstructor;
import org.generation.products.model.Product;
import org.generation.products.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    // Ontener todos los productos
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // Ontener productos por id
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        return productService.getProductoById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Crear un nuevo producto
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product){
        try {
            Product updateProduct = productService.updateProduct(id, product);
            return ResponseEntity.ok(updateProduct);
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE - Eliminar producto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        try {
            productService.deleteProduct(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
