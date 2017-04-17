package pl.mamisoft.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.mamisoft.frontend.dao.ProductRepository;
import pl.mamisoft.frontend.model.Product;

/**
 * Created by jarek on 16.04.17.
 */
@Controller
@RequestMapping(value = "/index")
public class IndexController {

    @Autowired
    private ProductRepository repository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public @ResponseBody String create() {

        this.repository.deleteAll();

        // insert some products
        this.repository.save(new Product("1", "Nintendo Entertainment System"));
        this.repository.save(new Product("2", "Sega Megadrive"));
        this.repository.save(new Product("3", "Sony Playstation"));

        // fetch all
        System.out.println("Products found by findAll():");
        System.out.println("----------------------------");
        for (Product product : this.repository.findAll()) {
            System.out.println(product);
        }
        System.out.println();

        // fetch a single product
        System.out.println("Products found with findByNameStartingWith('So'):");
        System.out.println("--------------------------------");
        for (Product product : this.repository.findByNameStartingWith("So")) {
            System.out.println(product);
        }
        System.out.println();
        return "OK";
    }
}
