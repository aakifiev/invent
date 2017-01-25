package ru.aakifiev.dao;

import org.springframework.stereotype.Component;
import ru.aakifiev.model.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by aakifiev on 22.01.2017.
 */
@Component
public class ProductDao {

    @PersistenceContext
    private EntityManager em;

    public void persist(Product product){
        em.persist(product);
    }

    public List<Product> findAll(){
        return em.createQuery("Select p FROM Product p").getResultList();
    }
}
