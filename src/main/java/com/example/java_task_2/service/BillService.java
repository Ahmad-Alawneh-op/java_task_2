package com.example.java_task_2.service;

import com.example.java_task_2.data.Bill;
import com.example.java_task_2.data.Book;
import com.example.java_task_2.data.Customer;

import java.util.List;

public interface BillService {
    Bill getBill(String id);
    List<Bill> getAllBills();
    List<Book> getPurchasedBooks(String customerId);
    int getTotalSpending(String customerId);
    Bill completePurchase(String customerId, List<String> bookIds) throws Exception;
    void refundBill(String id);
    void refundBook(String billId, String bookId) throws Exception;
}
