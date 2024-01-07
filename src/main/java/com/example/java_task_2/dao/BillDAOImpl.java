package com.example.java_task_2.dao;

import com.example.java_task_2.data.Bill;
import com.example.java_task_2.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BillDAOImpl implements BillDao {

    @Autowired
    BillRepository billRepo;

    @Override
    public Bill findBill(String id) {
        return billRepo.findById(id).orElse(null);
    }

    @Override
    public List<Bill> findAllBills() {
        return billRepo.findAll();
    }

    @Override
    public List<Bill> findBillsByCustomer(String customerId) {
        return billRepo.findBillsByCustomer(customerId);
    }

    @Override
    public Bill createBill(Bill bill) {
        return billRepo.insert(bill);
    }

    @Override
    public Bill updateBill(Bill bill) {
        return billRepo.save(bill);
    }

    @Override
    public void deleteBill(String id) {
        billRepo.deleteById(id);
    }
}
