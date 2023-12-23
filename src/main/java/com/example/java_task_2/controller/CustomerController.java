package com.example.java_task_2.controller;

import com.example.java_task_2.data.Customer;
import com.example.java_task_2.data.SimpleJsonResponse;
import com.example.java_task_2.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/byId")
    public Customer getCustomerById(@RequestParam(defaultValue = "") String id) {
        return customerService.getCustomer(id);
    }

    @GetMapping("/all")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @PostMapping("/create")
    public ResponseEntity<SimpleJsonResponse> createCustomer (@RequestBody Customer customer) {
        try {
            customer.setId(UUID.randomUUID().toString());
            customerService.addCustomer(customer);
            SimpleJsonResponse successfulResponse = new SimpleJsonResponse("Customer created successfully: " + customer.getId(), 201, false);
            return new ResponseEntity<>(successfulResponse, new HttpHeaders(), HttpStatus.CREATED);
        } catch (Exception e) {
            SimpleJsonResponse failedResponse = new SimpleJsonResponse(e.getMessage(), 200, true);

            return new ResponseEntity<>(failedResponse, new HttpHeaders(), HttpStatus.OK);
        }
    }

    @PatchMapping("/update")
    public ResponseEntity<SimpleJsonResponse> updateCustomer (@RequestBody Customer customer) {
        if (customer.getId() == null) {
            SimpleJsonResponse noIdResponse = new SimpleJsonResponse("Id must be provided", 200, true);

            return new ResponseEntity<>(noIdResponse, new HttpHeaders(), HttpStatus.OK);
        }
        try {
            customerService.updateCustomer(customer);
            SimpleJsonResponse successfulResponse = new SimpleJsonResponse("Customer updated successfully", 200, false);
            return new ResponseEntity<>(successfulResponse, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            SimpleJsonResponse failedResponse = new SimpleJsonResponse(e.getMessage(), 200, true);

            return new ResponseEntity<>(failedResponse, new HttpHeaders(), HttpStatus.OK);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<SimpleJsonResponse> deleteCustomer (@RequestBody Customer customer) {
        if (customer.getId() == null) {
            SimpleJsonResponse noIdResponse = new SimpleJsonResponse("Id must be provided", 200, true);

            return new ResponseEntity<>(noIdResponse, new HttpHeaders(), HttpStatus.OK);
        }
        try {
            customerService.deleteCustomer(customer.getId());
            SimpleJsonResponse successfulResponse = new SimpleJsonResponse("Author deleted successfully", 200, false);
            return new ResponseEntity<>(successfulResponse, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            SimpleJsonResponse failedResponse = new SimpleJsonResponse(e.getMessage(), 200, true);

            return new ResponseEntity<>(failedResponse, new HttpHeaders(), HttpStatus.OK);
        }
    }
}
