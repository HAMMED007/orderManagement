package com.Controller;

import com.Entities.Orders;
import com.Entities.Products;
import com.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class OrderController {
    @Autowired
    Service service;

    @RequestMapping("/create_order")
    public String create_order(Model model){
        model.addAttribute("getAllProducts",service.getAllProducts());
        model.addAttribute("getCustomers",service.getAllCustomers());
        model.addAttribute("getAllOrders",service.getAllOrders());
        return "create_order";
    }

    @RequestMapping(value = "/save_order",method = RequestMethod.POST)
    public String saveOrders(@ModelAttribute("orders") Orders orders){
        service.saveOrders(orders);
        return "redirect:/create_order";
    }

    @RequestMapping("/deleteOrder/{id}")
    public String deleteOrder(@PathVariable("id") int id){
        service.deleteOrder(id);
        return "redirect:/create_order";
    }

    @RequestMapping("/searchOrder")
    public String searchOrder(@ModelAttribute("orders") Orders orders , Model model){
        List<Orders> list = service.searchOrder(orders.getProduct_name()
        ,orders.getCustomer_name()
        ,orders.getSubmission_date());

        if(!list.isEmpty()) {
            model.addAttribute("getAllOrders", list);
        }
        else{
            model.addAttribute("getAllOrders",service.getAllOrders());
        }

        model.addAttribute("getAllProducts",service.getAllProducts());
        model.addAttribute("getCustomers",service.getAllCustomers());
        return "create_order";
    }


}
