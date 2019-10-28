package dk.kea.dat18c.webshop.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//Dette er controller for WebShop
@Controller
public class WebShopController {

    @GetMapping("/")
    public String index(Model model) {
        //put noget i model
        //return side der skal vises
        return "index";
    }
}
