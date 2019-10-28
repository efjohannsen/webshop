package dk.kea.dat18c.webshop.Repository;

import dk.kea.dat18c.webshop.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {

    //annoter JdbcTemplate
    @Autowired
    JdbcTemplate template;

    public List<Product> getAll() {
        //sql der returnerer alt
        String sql = "SELECT * FROM Products";

        //brug rowmapper til mapping til java objekter
        RowMapper<Product> rowMapper = new BeanPropertyRowMapper<>(Product.class);

        //kald template og returner resultat
        return template.query(sql, rowMapper);
    }

    public void create(Product product) {
        //sql til indsættelse
        String sql = "INSERT INTO products (id, name, price, description) " +
                "VALUES (?,?,?,?)";
        //brug template update på SQL
        template.update(sql, product.getId(), product.getName(), product.getPrice(), product.getDescription());
    }
}
