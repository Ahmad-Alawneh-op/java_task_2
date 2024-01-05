package com.example.java_task_2.dao;

import com.example.java_task_2.data.Bill;

import java.util.List;

public interface BillDao {
    Bill findBill(String id);
    List<Bill> findAllBills();
    List<Bill> findBillsByCustomer(String customerId);
    Bill createBill(Bill bill);
    Bill updateBill(Bill bill);
    void deleteBill(String id);
}
