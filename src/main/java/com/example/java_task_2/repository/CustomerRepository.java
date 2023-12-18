package com.example.java_task_2.repository;

import com.example.java_task_2.data.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {
}
