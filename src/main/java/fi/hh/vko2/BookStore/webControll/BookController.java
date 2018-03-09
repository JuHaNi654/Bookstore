package fi.hh.vko2.BookStore.webControll;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.hh.vko2.BookStore.model.Book;
import fi.hh.vko2.BookStore.model.BookRepository;
import fi.hh.vko2.BookStore.model.CategoryRepository;
import fi.hh.vko2.BookStore.model.UserRepository;

@Controller
public class BookController {
	
	//Listaa lisättyjä olioita
	@Autowired
	private BookRepository repository;
	@Autowired
	private CategoryRepository crepository;

	
	@RequestMapping(value= {"/login", "/"})
	public String login() {
		return "login";
	}
	//Kirjalistan päänäkymä
    @RequestMapping(value="/index")
    public String booklist(Model model) {	
        model.addAttribute("books", repository.findAll());
        return "booklist";
    }
    //Tuo kirjalista näkymä muunettuna jsoniksi
    @GetMapping(value="/books")
    public @ResponseBody List<Book> bookListRest() {
    	return (List<Book>) repository.findAll();
    }
    
    //Tuo yksittäisen kirjan id avulla json muodossa
    @GetMapping(value="/book/{id}")
    public @ResponseBody Book findBookRest(@PathVariable("id") Long bookId) {
    	return repository.findOne(bookId);
    }
    //Mahdollisuus lisätä kirjan ja categoria
	@GetMapping(value="/add")
	public String listbook(Model model) {
		model.addAttribute("book", new Book()); 
		model.addAttribute("categorys", crepository.findAll());
		return "addBook";
	}
	
	@RequestMapping(value="/add")
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categorys", crepository.findAll());
		return "addBook";
	}
	
	//Tallentaa lisätyn kirjan tiedot
	@PostMapping(value="/save")
	public String saveBook(Book book) {
		repository.save(book);
		return "redirect:index";
	}
	
	//Mahodllisuus poistaa kirjan listasta
	@RequestMapping(value= "/delete/{id}", method = RequestMethod.GET)
	public String DeleteBook(@PathVariable("id") Long bookId, Model model) {
		repository.delete(bookId);
		return "redirect:../index";
	}
	
	//Mahdollisuus muokata listassa oleva kirjan ja categorian
	@RequestMapping(value= "/edit/{id}")
	public String editBook(@PathVariable("id") Long bookId, Model model) {
		model.addAttribute("book", repository.findOne(bookId));
		model.addAttribute("categorys", crepository.findAll());
		return "editbook";
	}
}
