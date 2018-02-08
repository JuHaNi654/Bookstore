package fi.hh.vko2.BookStore.webControll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.hh.vko2.BookStore.model.Book;
import fi.hh.vko2.BookStore.model.BookRepository;

@Controller
public class BookController {
	
	@Autowired
	private BookRepository repository;
	
    @RequestMapping(value="/index")
    public String booklist(Model model) {	
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }
	@GetMapping(value="/add")
	public String listbook(Model model) {
		model.addAttribute("book", new Book());
		return "addBook";
	}
	
    
	@RequestMapping(value="/add")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		return "addBook";
	}
	
	@PostMapping(value="/save")
	public String saveBook(Book book) {
		repository.save(book);
		return "redirect:index";
	}
	
	@RequestMapping(value= "/delete/{id}", method = RequestMethod.GET)
	public String DeleteBook(@PathVariable("id") Long bookId, Model model) {
		repository.delete(bookId);
		return "redirect:../index";
	}
}
