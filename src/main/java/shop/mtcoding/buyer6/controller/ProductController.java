package shop.mtcoding.buyer6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import shop.mtcoding.buyer6.model.Product;
import shop.mtcoding.buyer6.model.ProductRepository;

@Controller
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping({ "/", "/product" })
    public String home(Model model) {
        List<Product> productList = productRepository.findAll();
        model.addAttribute("productList", productList);

        return "product/list";

    }
}
