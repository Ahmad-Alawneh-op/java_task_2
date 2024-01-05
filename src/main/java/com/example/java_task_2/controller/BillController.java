package com.example.java_task_2.controller;

import com.example.java_task_2.data.Bill;
import com.example.java_task_2.data.Book;
import com.example.java_task_2.data.SimpleJsonResponse;
import com.example.java_task_2.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("bill")
public class BillController {

    @Autowired
    BillService billService;

    @GetMapping("/byId")
    public Bill getBillById(@RequestParam(defaultValue = "") String id) {
        return billService.getBill(id);
    }

    @GetMapping("/all")
    public List<Bill> getAllBills() {
        return billService.getAllBills();
    }

    @GetMapping("/customerPurchases")
    public List<Book> getCustomerPurchases(@RequestParam(defaultValue = "") String customerId) {
        return billService.getPurchasedBooks(customerId);
    }

    @GetMapping("/customerSpending")
    public ResponseEntity<SimpleJsonResponse> getCustomerSpending(@RequestParam(defaultValue = "") String customerId) {
        int total = billService.getTotalSpending(customerId);

        SimpleJsonResponse response = new SimpleJsonResponse("Total: " + total, 200, true);

        return new ResponseEntity<>(response, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping("/completePurchase")
    public Bill completePurchase(@PathVariable String customerId, @RequestBody Map<String, List<String>> body) throws Exception {
        return billService.completePurchase(customerId, body.get("books")); // Bad requestBody practice, will update if there's enough time
    }

    @DeleteMapping("/refundBill")
    public ResponseEntity<SimpleJsonResponse> refundBill (@RequestParam(defaultValue = "") String id) {
        billService.refundBill(id);

        SimpleJsonResponse response = new SimpleJsonResponse("Bill refunded", 200, true);
        return new ResponseEntity<>(response, new HttpHeaders(), HttpStatus.OK);
    }

    @PatchMapping("/refundBook")
    public ResponseEntity<SimpleJsonResponse> refundBook(@PathVariable String bookId, @RequestBody Map<String, String> body) throws Exception {
        billService.refundBook(bookId, body.get("billId"));

        SimpleJsonResponse response = new SimpleJsonResponse("Book refunded", 200, true);
        return new ResponseEntity<>(response, new HttpHeaders(), HttpStatus.OK);
    }

}
