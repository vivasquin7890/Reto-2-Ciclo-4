package Ciclo4.g20.repositorio;

import Ciclo4.g20.modelo.Product;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import Ciclo4.g20.repositorio.crud.ProductCrudRepositorio;

/**
 *
 * @author 
 */
@Repository
public class ProductRepositorio {

    @Autowired
    private ProductCrudRepositorio prodCrudRepositorio;

    public List<Product> getAll() {
        return prodCrudRepositorio.findAll();
    }

    public Optional<Product> getProduct(int id) {
        return prodCrudRepositorio.findById(id);
    }

    public Product save(Product product){
        return prodCrudRepositorio.save(product);
    }
    
    public void update(Product product){
        prodCrudRepositorio.save(product);
    }
    
    public void delete(Product product){
        prodCrudRepositorio.delete(product);
    }
}
