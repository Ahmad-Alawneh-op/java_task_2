package com.example.java_task_2.repository;

import com.example.java_task_2.data.Bill;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface BillRepository extends MongoRepository<Bill, String> {

    @Query
    List<Bill> findBillsByCustomer (String customerId);
}
