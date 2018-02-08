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
	
	//Luo listan, johon voi tallentaa useampia luokka olioita 
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
	
    //Komento ohjaa addbook.html sivulle, jonka kautta voi lisätä kirjan
	@RequestMapping(value="/add")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		return "addBook";
	}
	
	//addbook.html sivulla kun on lisännut kirjan se lisää tiedot pääsivulle ja repositoryyn, sen jälkeen se ohjaa takaisin pää sivulle eli /index
	@PostMapping(value="/save")
	public String saveBook(Book book) {
		repository.save(book);
		return "redirect:index";
	}
	
	//poistaa listatun kirjan
	@RequestMapping(value= "/delete/{id}", method = RequestMethod.GET)
	public String DeleteBook(@PathVariable("id") Long bookId, Model model) {
		repository.delete(bookId);
		return "redirect:../index";
	}
	//muokkaa tallennetun luokka olion tietoja
	@RequestMapping(value= "/edit/{id}")
	public String editBook(@PathVariable("id") Long bookId, Model model) {
		model.addAttribute("book", repository.findOne(bookId));
		return "editbook";
	}
}
