package com.example.java_task_2.service;

import com.example.java_task_2.data.Customer;

import java.util.List;

public interface CustomerService {
    Customer getCustomer(String id);
    List<Customer> getAllCustomers();
    Customer addCustomer(Customer customer);
    Customer updateCustomer(Customer customer);
    void deleteCustomer(String id);
}
