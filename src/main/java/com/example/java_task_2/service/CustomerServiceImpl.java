package com.example.java_task_2.service;

import com.example.java_task_2.dao.CustomerDAO;
import com.example.java_task_2.data.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerDAO customerDAO;

    @Override
    public Customer getCustomer(String id) {
        return customerDAO.findCustomer(id);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerDAO.findCustomers();
    }

    @Override
    public Customer addCustomer(Customer customer) {
        return customerDAO.createCustomer(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return customerDAO.updateCustomer(customer);
    }

    @Override
    public void deleteCustomer(String id) {
        customerDAO.deleteCustomer(id);
    }
}
