package com.example.modeldemo;
import com.example.modeldemo.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private List<Product> productList = new ArrayList<>();
    @GetMapping
    public List<Product> getAllProducts() {
        return productList;
    }
    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        productList.add(product);
        return product;
    }
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        for(Product p : productList) {
            if(p.getId().equals(id)) {
                p.setName(product.getName());
                p.setPrice(product.getPrice());
                return p;
            }
        }
        return null;
    }
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {
        for(Product p : productList) {
            if(p.getId().equals(id)) {
                productList.remove(p);
                return "商品已删除";
            }
        }
        return "未找到商品";
    }
}
