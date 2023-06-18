package com.Controller;

import com.Entities.Products;
import com.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {
    @Autowired
    Service service;

    @RequestMapping("/create_product")
    public String create_product(Model model){
        model.addAttribute("getAllProducts",service.getAllProducts());
        return "create_product";
    }

    @RequestMapping(value = "/save_product",method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("products")Products products){
        service.saveProduct(products);
        return "redirect:/create_product";
    }

    @RequestMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable("id") int id, Model model){
        service.deleteProduct(id);
        return "redirect:/create_product";
    }


}
