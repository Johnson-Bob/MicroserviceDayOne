package org.it.discovery.monolith.controller;

import java.util.List;

import org.it.discovery.monolith.domain.Book;
import org.it.discovery.monolith.domain.Customer;
import org.it.discovery.monolith.domain.Order;
import org.it.discovery.monolith.repository.BookRepository;
import org.it.discovery.monolith.repository.CustomerRepository;
import org.it.discovery.monolith.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ShopController {
	
	private String libraryName = "IT-Discovery library";
	
	private BookRepository bookRepository;
	
	private CustomerRepository customerRepository;
	
	private OrderService orderService;

	@GetMapping("/library")
	public String getLibraryName() {
		return libraryName;
	}

	public List<Book> getBooks() {
		return bookRepository.getBooks();				
	}

	public Book getBook(int id) {
		return bookRepository.findBookById(id);				
	}

	public void saveBook(Book book) {
		bookRepository.saveBook(book);				
	}

	public void updateBook(Book book) {
		bookRepository.saveBook(book);				
	}
	
	public int createOrder(int bookId, int number, int customerId) {
		return orderService.createOrder(bookId, number, customerId).getId();		
	}
	
	public void saveCustomer(Customer customer) {
		customerRepository.save(customer);				
	}

	public List<Customer> findCustomers() {
		return customerRepository.findAll();				
	}

	public void addBook(int orderId, int bookId, int number) {
		orderService.addBook(orderId, bookId, number);
	}
	
	public void completeOrder(int orderId) {
		orderService.complete(orderId);
	}
	
	public void deliver(int orderId) {
		orderService.deliver(orderId);			
	}
	
	public void cancel(int orderId) {
		orderService.cancel(orderId);
	}
	
	public List<Order> findOrders() {
		return orderService.findOrders();
	}

}
