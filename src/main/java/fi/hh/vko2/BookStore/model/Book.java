package fi.hh.vko2.BookStore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Book {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	
	public String title;
	public String author;
	public int year;
	public int isbn;
	public double price;
	
	public Book() {
		title = "";
		author = "";
		year = 0;
		isbn = 0;
		price = 0.00;
	}
	public Book(String title, String author, int year, int isbn, double price) {
		this.title = title;
		this.author = author;
		this.year = year;
		this.isbn = isbn;
		this.price = price;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String toString() {
		return  "Book id=" + id + "title=" + title + ", author=" + author 
				+", year=" + year + ", isbn=" + isbn + ", price=" + price;
	}
}