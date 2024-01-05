package com.example.java_task_2.service;

import com.example.java_task_2.dao.BillDao;
import com.example.java_task_2.data.Bill;
import com.example.java_task_2.data.Book;
import com.example.java_task_2.data.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class BillServiceImpl implements BillService {
    @Autowired
    BillDao billDao;

    @Autowired
    BookService bookService;

    @Autowired
    CustomerService customerService;

    @Override
    public Bill getBill(String id) {
        return billDao.findBill(id);
    }

    @Override
    public List<Bill> getAllBills() {
        return billDao.findAllBills();
    }

    @Override
    public List<Book> getPurchasedBooks(String customerId) {
        List<Bill> customerBills = billDao.findBillsByCustomer(customerId);
        List<Book> customerBooks = new ArrayList<>();

        for(Bill customerBill: customerBills) {
            customerBooks.addAll(customerBill.getBooks());
        }

        return customerBooks;
    }

    @Override
    public int getTotalSpending(String customerId) {
        List<Bill> customerBills = billDao.findBillsByCustomer(customerId);
        int total = 0;

        for(Bill customerBill: customerBills) {
            total += customerBill.getTotalPrice();
        }

        return total;
    }

    @Override
    public Bill completePurchase(String customerId, List<String> bookIds) throws Exception {
        Customer customer = customerService.getCustomer(customerId);

        if (customer == null) { // @TODO: Maybe move this to the controller?
           throw new Exception("Customer not found");
        }
        List<Book> books = new ArrayList<>();
        List<String> bookIdsWithErrors = new ArrayList<>(); // @TODO: Would be nice to return this with the response, keeping here so I don't forget about it

        int totalPrice = 0;

        for (String bookId: bookIds) {
            Book book = bookService.getBook(bookId); // @TODO: Maybe let the to the controller prepare the list of books?
            if (book != null && book.getQuantity() > 0) {
                books.add(book);
                totalPrice += book.getPrice();

                book.setQuantity(book.getQuantity() - 1);
                bookService.updateBook(book);
            } else {
                bookIdsWithErrors.add(bookId);
            }
        }

        if (books.size() == 0) {
            throw new Exception("No books to purchase");
        }

        Bill bill = new Bill(customer, books, totalPrice);
        bill.setId(UUID.randomUUID().toString());

        billDao.createBill(bill);

        return bill;
    }

    @Override
    public void refundBill(String id) {
        Bill bill = billDao.findBill(id);

        for (Book book: bill.getBooks()) {
            book.setQuantity(book.getQuantity() + 1);
            bookService.updateBook(book);
        }

        billDao.deleteBill(id);
    }

    @Override
    public void refundBook(String billId, String bookId) throws Exception {
        Bill bill = billDao.findBill(billId);
        if (bill == null) {
            throw new Exception("Bill not found");
        }
        Book targetBook = bookService.getBook(bookId);

        if (targetBook == null) {
            throw new Exception("Book not found");
        }

        List<Book> filteredBooks = new ArrayList<>();

        for (Book book: bill.getBooks()) {
            if (!Objects.equals(book.getId(), targetBook.getId())) {
                filteredBooks.add(book);
            }
        }

        if (filteredBooks.size() == bill.getBooks().size()) {
            throw new Exception("Book is not part of provided bill");
        }

        bill.setBooks(filteredBooks);
        bill.setTotalPrice(bill.getTotalPrice() - targetBook.getPrice());
        billDao.updateBill(bill);

        targetBook.setQuantity(targetBook.getQuantity() + 1);
        bookService.updateBook(targetBook);
    }
}
