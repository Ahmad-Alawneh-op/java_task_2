package com.example.java_task_2.dao;

import com.example.java_task_2.data.Customer;

import java.util.List;

public interface CustomerDAO {
    Customer findCustomer(String email);
    List<Customer> findCustomers();
    boolean createCustomer(Customer customer);
    boolean updateCustomer(Customer customer);
    boolean deleteCustomer(String email);
}
