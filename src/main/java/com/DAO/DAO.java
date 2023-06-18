package com.DAO;

import com.Entities.Customers;
import com.Entities.Orders;
import com.Entities.Products;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DAO {

    JdbcTemplate jdbcTemplate;


    /*Customers*/
    public int saveCustomers(Customers customers){
        String sql="insert into customers(" +
                "registration_code," +
                "full_name," +
                "email," +
                "telephone) " +
                "values('"+customers.getRegistration_code()+"','"
                +customers.getFull_name()+"','"
                +customers.getEmail()+"',"+
                "'"+customers.getTelephone()+"')";
        return jdbcTemplate.update(sql);
    }

    public List<Customers> getAllCustomers(){
        return jdbcTemplate.query("select * from customers",new RowMapper<Customers>(){
            public Customers mapRow(ResultSet rs, int row) throws SQLException {
                Customers customers=new Customers();
                customers.setId(rs.getInt(1));
                customers.setRegistration_code(rs.getString(2));
                customers.setFull_name(rs.getString(3));
                customers.setEmail(rs.getString(4));
                customers.setTelephone(rs.getString(5));
                return customers;
            }
        });
    }

    public int deleteCustomers(int id){
        String sql="delete from customers where id="+id+"";
        return jdbcTemplate.update(sql);
    }


    /*Products*/
    public int saveProduct(Products products){
        String sql="insert into products(product_name,sku_code,unit_price) " +
                "values('"+products.getProduct_name()+"'," +
                "'"+products.getSku_code()+"'," +
                "'"+products.getUnit_price()+"')";
        return jdbcTemplate.update(sql);
    }

    public List<Products> getAllProducts(){
        return jdbcTemplate.query("select * from products",new RowMapper<Products>(){
            public Products mapRow(ResultSet rs, int row) throws SQLException {
                Products products = new Products();
                products.setId(rs.getInt(1));
                products.setProduct_name(rs.getString(2));
                products.setSku_code(rs.getString(3));
                products.setUnit_price(rs.getInt(4));
                return products;
            }
        });
    }

    public int deleteProduct(int id){
        String sql="delete from products where id="+id+"";
        return jdbcTemplate.update(sql);
    }



    /*orders*/
    public int saveOrders(Orders order){
        String sql="insert into orders(product_name,customer_name,quantity,submission_date) " +
                "values('"+order.getProduct_name()+"','"+order.getCustomer_name()+"','"+order.getQuantity()+"','"+order.getSubmission_date()+"')";
        return jdbcTemplate.update(sql);
    }
    public List<Orders> getAllOrders(){
        return jdbcTemplate.query("select * from orders",new RowMapper<Orders>(){
            public Orders mapRow(ResultSet rs, int row) throws SQLException {
                Orders orders = new Orders();
                orders.setId(rs.getInt(1));
                orders.setProduct_name(rs.getString(2));
                orders.setCustomer_name(rs.getString(3));
                orders.setQuantity(rs.getInt(4));
                orders.setSubmission_date(rs.getString(5));

                return orders;

            }
        });
    }
    public int deleteOrder(int id){
        String sql="delete from orders where id='"+id+"'";
        return jdbcTemplate.update(sql);
    }

    public List<Orders> searchOrder(String product , String customer , String date){
        return jdbcTemplate.query("select * from orders where product_name='"+product+"' OR customer_name='"+customer+"' OR submission_date='"+date+"'",new RowMapper<Orders>(){
            public Orders mapRow(ResultSet rs, int row) throws SQLException {
                Orders orders = new Orders();
                orders.setId(rs.getInt(1));
                orders.setProduct_name(rs.getString(2));
                orders.setCustomer_name(rs.getString(3));
                orders.setQuantity(rs.getInt(4));
                orders.setSubmission_date(rs.getString(5));

                return orders;

            }
        });
    }


    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
