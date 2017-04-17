package pl.mamisoft.frontend.dao;

import org.springframework.data.solr.repository.SolrCrudRepository;
import pl.mamisoft.frontend.model.Product;

import java.util.List;

/**
 * Created by jarek on 16.04.17.
 */
public interface ProductRepository extends SolrCrudRepository<Product, String> {

    List<Product> findByNameStartingWith(String name);

}