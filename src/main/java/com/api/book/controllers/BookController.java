package com.api.book.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.Services.BookService;
import com.api.book.entities.Book;

@RestController
@RequestMapping("books")
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping
	public List<Book> getBooks() {
		return this.bookService.getAllBooks();
	}

	@GetMapping("{id}")
	public Book getBook(@PathVariable("id") int id) {
		return bookService.getBook(id);
	}

	@PostMapping
	public Book createBook(@RequestBody Book book) {
		return this.bookService.addBook(book);
	}

	@DeleteMapping("{id}")
	public void deleteBook(@PathVariable int id) {
		bookService.deleteBook(id);
	}
}
