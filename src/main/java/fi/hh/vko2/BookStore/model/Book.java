package fi.hh.vko2.BookStore.model;

public class Book {
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
}
