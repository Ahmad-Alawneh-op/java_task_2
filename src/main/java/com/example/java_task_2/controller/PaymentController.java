package com.example.java_task_2.controller;

import com.example.java_task_2.data.Book;
import com.example.java_task_2.data.Customer;
import com.example.java_task_2.data.SimpleJsonResponse;
import com.example.java_task_2.service.BookService;
import com.example.java_task_2.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@RestController
@RequestMapping("payment")
public class PaymentController {
    @Autowired
    CustomerService customerService;

    @Autowired
    BookService bookService;

    @PostMapping("/purchase/{bookId}")
    public ResponseEntity<SimpleJsonResponse> purchaseBook (@RequestBody Map<String, String> customerData, @PathVariable String bookId) {
        try {
            Book fullBookData = bookService.getBook(bookId);
            if (fullBookData == null) {
                SimpleJsonResponse noBookResponse = new SimpleJsonResponse("Invalid book ID", 400, true);
                return new ResponseEntity<>(noBookResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST);
            }
            if (fullBookData.getQuantity() == 0) {
                SimpleJsonResponse bookOutOfStockResponse = new SimpleJsonResponse("Book is out of stock", 400, true);
                return new ResponseEntity<>(bookOutOfStockResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST);
            }

            Customer fullCustomerData = customerService.getCustomer(customerData.get("customerId"));

            if (fullCustomerData == null) {
                SimpleJsonResponse noCustomerResponse = new SimpleJsonResponse("Invalid customer ID", 400, true);
                return new ResponseEntity<>(noCustomerResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST);
            }

            for(Book customerBook: fullCustomerData.getPurchasedBooks()) {
                if (Objects.equals(customerBook.getId(), bookId)) { // For simplicity assume user can't purchase the same book twice
                    SimpleJsonResponse customerOwnsBookResponse = new SimpleJsonResponse("Customer already owns book", 400, true);
                    return new ResponseEntity<>(customerOwnsBookResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST);
                }
            }

            fullBookData.setQuantity(fullBookData.getQuantity() - 1);
            fullCustomerData.getPurchasedBooks().add(fullBookData);
            bookService.updateBook(fullBookData);
            customerService.updateCustomer(fullCustomerData);
            SimpleJsonResponse successfulPurchase = new SimpleJsonResponse("Purchase successful", 200, false);

            return new ResponseEntity<>(successfulPurchase, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            SimpleJsonResponse failedResponse = new SimpleJsonResponse(e.getMessage(), 200, true);

            return new ResponseEntity<>(failedResponse, new HttpHeaders(), HttpStatus.OK);
        }
    }

    @GetMapping("/receipt/{customerId}")
    public ResponseEntity<SimpleJsonResponse> purchaseBook (@PathVariable String customerId) {
        try {
            Customer customer = customerService.getCustomer(customerId);
            if (customer == null) {
                SimpleJsonResponse noCustomerResponse = new SimpleJsonResponse("Invalid customer ID", 400, true);
                return new ResponseEntity<>(noCustomerResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST);
            }
            int totalPrice = 0;
            for (Book book: customer.getPurchasedBooks()) {
                totalPrice += book.getPrice();
            }

            SimpleJsonResponse successfulPurchase = new SimpleJsonResponse(
                    "Total books: " + customer.getPurchasedBooks().size() + ", Total price: " + totalPrice,
                    200, false);

            return new ResponseEntity<>(successfulPurchase, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            SimpleJsonResponse failedResponse = new SimpleJsonResponse(e.getMessage(), 200, true);

            return new ResponseEntity<>(failedResponse, new HttpHeaders(), HttpStatus.OK);
        }

    }
}
