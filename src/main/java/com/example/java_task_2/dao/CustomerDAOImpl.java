package com.example.java_task_2.dao;

import com.example.java_task_2.data.Customer;
import com.example.java_task_2.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CustomerDAOImpl implements CustomerDAO {
    @Autowired
    CustomerRepository customerRepo;

    @Override
    public Customer findCustomer(String id) {
        Optional<Customer> value = customerRepo.findById(id);
        return value.orElse(null);
    }

    @Override
    public List<Customer> findCustomers() {
        return customerRepo.findAll();
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepo.insert(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    @Override
    public void deleteCustomer(String id) {
        customerRepo.deleteById(id);
    }
}
