package dev.cathalhanley.core;

import dev.cathalhanley.product.Product;
import dev.cathalhanley.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseLoader implements ApplicationRunner {
    private final ProductRepository productRepository;
    List<Product> productList;

    @Autowired
    public DatabaseLoader(ProductRepository orders){
        this.productRepository = orders;
        productList = new ArrayList<>();
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        createData();
        productRepository.saveAll(productList);

    }

    // This is only done to have data on load time for browsing. This usually wouldn't be done in a prod env.
    private void createData() {
        Product product =  new Product("Barbie Doll",25.99);
        Product productTwo =  new Product("LEGO Harry Potter Set",199.99);
        Product productThree =  new Product("Action Man",29.99);
        productList.add(product);
        productList.add(productTwo);
        productList.add(productThree);
    }
}
