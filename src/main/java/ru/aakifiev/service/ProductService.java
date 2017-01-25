package ru.aakifiev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.aakifiev.dao.ProductDao;
import ru.aakifiev.model.Product;

import java.util.List;

/**
 * Created by aakifiev on 22.01.2017.
 */

@Component
public class ProductService {

    @Autowired
    private ProductDao productDao;

    @Transactional
    public void add(Product product){
        productDao.persist(product);
    }

    @Transactional
    public void addAll(List<Product> products){
        for (Product product : products){
            productDao.persist(product);
        }
    }

    @Transactional(readOnly = true)
    public List<Product> listAll(){
        return productDao.findAll();
    }
}
