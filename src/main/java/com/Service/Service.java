package com.Service;

import com.DAO.DAO;
import com.Entities.Customers;
import com.Entities.Orders;
import com.Entities.Products;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Service {

    @Autowired
    DAO dao;

    /*Customers*/
    public int saveCustomers(Customers customers){
        return dao.saveCustomers(customers);
    }
    public List<Customers> getAllCustomers(){
        return dao.getAllCustomers();
    }
    public int deleteCustomers(int id){
        return dao.deleteCustomers(id);
    }


    /*products*/
    public int saveProduct(Products products){
        return dao.saveProduct(products);
    }
    public List<Products> getAllProducts(){
        return dao.getAllProducts();
    }
    public int deleteProduct(int id){
        return dao.deleteProduct(id);
    }


    /*Orders*/
    public int saveOrders(Orders orders){
        return dao.saveOrders(orders);
    }
    public List<Orders> getAllOrders(){
        return dao.getAllOrders();
    }
    public int deleteOrder(int id){
        return dao.deleteOrder(id);
    }
    public List<Orders> searchOrder(String product , String customer , String date){
        return dao.searchOrder(product , customer , date);
    }
}
