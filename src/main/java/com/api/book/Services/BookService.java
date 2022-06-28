package com.api.book.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.api.book.entities.Book;
import com.google.common.base.Objects;

@Component
public class BookService {

	private final List<Book> books;

	public BookService() {
		this.books = getBooks();
	}

	private List<Book> getBooks() {
		List<Book> books = new ArrayList<>();
		books.add(new Book(101, "Java", "LMN"));
		books.add(new Book(102, "phyton", "MJNs"));
		books.add(new Book(103, "c++", "RJSS"));
		return books;
	}

	public List<Book> getAllBooks() {
		return books;
	}

	public Book getBook(int id) {
		Book book=null;
		try {
			book=books.stream().filter(book1 -> Objects.equal(book1.getId(), id)).findFirst().get();			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}

	public Book addBook(Book book) {
		books.add(book);
		return book;
	}

	public void deleteBook(int id) {
		books.removeIf(book -> Objects.equal(book.getId(), id));
	}
	
	public void updateBook(Book book, int bookId) {
		books.stream().map(b->{
			if(b.getId()==bookId) {
				b.setTitle(book.getTitle());
				b.setAuthor(book.getAuthor());
			}
			return	b;
		}).collect(Collectors.toList());
	}

}
