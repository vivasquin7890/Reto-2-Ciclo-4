/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ciclo4.g20.repositorio.crud;

import Ciclo4.g20.modelo.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author 
 */
public interface ProductCrudRepositorio extends MongoRepository<Product, Integer>{
    
}
