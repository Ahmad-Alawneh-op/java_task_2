package com.example.java_task_2.dao;

import com.example.java_task_2.data.Customer;

import java.util.ArrayList;

public interface CustomerDAO {
    Customer getCustomer(String email);
    ArrayList<Customer> getCustomers();
    boolean createCustomer(Customer customer);
    boolean updateCustomer(Customer customer);
    boolean updateCustomer(String customer);
}
