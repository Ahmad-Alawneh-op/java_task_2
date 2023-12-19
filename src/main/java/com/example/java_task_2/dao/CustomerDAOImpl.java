package com.example.java_task_2.dao;

import com.example.java_task_2.data.Customer;
import com.example.java_task_2.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    CustomerRepository customerRepo;

    @Override
    public Customer findCustomer(String email) {
        Optional<Customer> value = customerRepo.findById(email);
        return value.orElse(null);
    }

    @Override
    public List<Customer> findCustomers() {
        return customerRepo.findAll();
    }

    @Override
    public boolean createCustomer(Customer customer) {
        try {
            customerRepo.insert(customer);
            return true;
        } catch (Exception exception) {
            System.out.println("Error creating customer!: " + exception.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        try {
            customerRepo.save(customer);
            return true;
        } catch (Exception exception) {
            System.out.println("Error updating customer!: " + exception.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteCustomer(String email) {
        try {
            customerRepo.deleteById(email);
            return true;
        } catch (Exception exception) {
            System.out.println("Error deleting customer!: " + exception.getMessage());
            return false;
        }
    }
}
