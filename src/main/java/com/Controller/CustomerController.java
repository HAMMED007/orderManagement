package com.Controller;

import com.Entities.Customers;
import com.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CustomerController {

    @Autowired
    Service service;


    @RequestMapping({"/","/index"})
    public String Home(Model model){
        model.addAttribute("getCustomers",service.getAllCustomers());
        return "index";
    }

    @RequestMapping(value = "/save_customer",method = RequestMethod.POST)
    public String save_customer(@ModelAttribute("customers") Customers customers,Model model){
        service.saveCustomers(customers);
        return "redirect:/index";
    }

    @RequestMapping("/deleteCustomer/{id}")
    public String deleteCustomer(@PathVariable("id") int id,Model model){
        service.deleteCustomers(id);
        return "redirect:/index";
    }

}
