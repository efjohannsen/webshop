package dk.kea.dat18c.webshop.Controller;

import dk.kea.dat18c.webshop.Model.Product;
import dk.kea.dat18c.webshop.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

//Dette er controller for WebShop
@Controller
public class WebShopController {

    //annoter service
    @Autowired
    ProductService productService;

    @GetMapping("/")
    public String index(Model model) {
        //put noget i model
        model.addAttribute("products", productService.getAll());
        //return side der skal vises
        return "index";
    }

    @GetMapping("/create")
    public String showCreate() {
        return "createProduct";
    }

    @PostMapping("/create")
    public String createProduct(@ModelAttribute Product product) {
        productService.create(product);
        return "redirect:/";
    }
}
