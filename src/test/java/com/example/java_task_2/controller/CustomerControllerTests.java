package com.example.java_task_2.controller;

import com.example.java_task_2.data.Customer;
import com.example.java_task_2.service.CustomerService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.List;

import static org.mockito.Mockito.*;

public class CustomerControllerTests {
    private final CustomerController customerController = new CustomerController();

    private final CustomerService customerServiceSpy = spy(CustomerService.class);

    public Customer getMockCustomerInstance() {
        return new Customer("mockName", "mockEmail");
    }

    @BeforeEach
    public void prepare() {
        ReflectionTestUtils.setField(customerController, "customerService", customerServiceSpy);
    }

    @Test
    public void getCustomerById_whenIdIsProvided_thenServiceReturnsCustomer() {
        when(customerServiceSpy.getCustomer("mockId")).thenReturn(getMockCustomerInstance());

        customerController.getCustomerById("mockId");

        verify(customerServiceSpy).getCustomer("mockId");
    }

    @Test
    public void getAllCustomers_returnAllCustomers() {
        when(customerServiceSpy.getAllCustomers()).thenReturn(List.of(getMockCustomerInstance()));

        customerController.getAllCustomers();

        verify(customerServiceSpy).getAllCustomers();
    }

    @Test
    public void createCustomer_whenCustomerIsProvided_thenCreateCustomer() {
        when(customerServiceSpy.addCustomer(getMockCustomerInstance())).thenReturn(getMockCustomerInstance());

        customerController.createCustomer(getMockCustomerInstance());

        verify(customerServiceSpy).addCustomer(getMockCustomerInstance());
    }

    @Test
    public void updateCustomer_whenCustomerIsProvided_thenUpdateCustomer() {
        Customer customer = getMockCustomerInstance();
        customer.setId("mockId");

        when(customerServiceSpy.updateCustomer(customer)).thenReturn(customer);

        customerController.updateCustomer(customer);

        verify(customerServiceSpy).updateCustomer(customer);
    }

    @Test
    public void deleteCustomer_whenIdIsProvided_thenDeleteCustomer() {
        Customer customer = getMockCustomerInstance();
        customer.setId("mockId");
        customerController.deleteCustomer(customer);

        verify(customerServiceSpy).deleteCustomer("mockId");
    }
}
