package com.example.java_task_2.dao;

import com.example.java_task_2.data.Customer;

import java.util.List;

public interface CustomerDAO {
    Customer findCustomer(String id);
    List<Customer> findCustomers();
    Customer createCustomer(Customer customer);
    Customer updateCustomer(Customer customer);
    void deleteCustomer(String id);
}
