/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ciclo4.g20.servicio;

import Ciclo4.g20.modelo.Product;
import Ciclo4.g20.repositorio.ProductRepositorio;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 
 */
@Service
public class ProductService {

    @Autowired
    private ProductRepositorio productRepositorio;

    public List<Product> getAll() {
        return productRepositorio.getAll();
    }

    public Optional<Product> getProduct(int id) {
        return productRepositorio.getProduct(id);
    }

    public Product save(Product product) {
        if (product.getId() == null) {
            return product;
        }
        return productRepositorio.save(product);
    }

    public Product update(Product product) {
        if (product.getId() != null) {
            Optional<Product> dbProduct = productRepositorio.getProduct(product.getId());
            if (!dbProduct.isEmpty()) {
                if (product.getBrand() != null) {
                    dbProduct.get().setBrand(product.getBrand());
                }
                if (product.getCategory() != null) {
                    dbProduct.get().setCategory(product.getCategory());
                }
                if (product.getPresentation() != null) {
                    dbProduct.get().setPresentation(product.getPresentation());
                }
                if (product.getDescription() != null) {
                    dbProduct.get().setDescription(product.getDescription());
                }
                if (product.getPrice() != 0) {
                    dbProduct.get().setPrice(product.getPrice());
                }
                if (product.getQuantity() != null) {
                    dbProduct.get().setQuantity(product.getQuantity());
                }
                if (product.getPhotography()!= null) {
                    dbProduct.get().setPhotography(product.getPhotography());
                }
                
                dbProduct.get().setAvailability(product.isAvailability());
                
                productRepositorio.update(dbProduct.get());
                return dbProduct.get();
            } else {
                return product;
            }
        } else {
            return product;
        }
    }
    
    public Boolean delete(int id){
        return getProduct(id).map(Product -> {
            productRepositorio.delete(Product);
            return true;
        }).orElse(false);
    }
}
