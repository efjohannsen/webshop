package dk.kea.dat18c.webshop.Service;

import dk.kea.dat18c.webshop.Model.Product;
import dk.kea.dat18c.webshop.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//annoter som service
@Service
public class ProductService {

    //annoter med autowired til repository
    @Autowired
    ProductRepository productRepository;

    public List<Product> getAll() {
        //kald repo.getall og returner
        return productRepository.getAll();
    }

    public void create(Product product) {
        productRepository.create(product);
    }

}
