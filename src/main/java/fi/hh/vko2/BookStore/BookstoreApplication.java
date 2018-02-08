package fi.hh.vko2.BookStore;


import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import ch.qos.logback.classic.Logger;
import fi.hh.vko2.BookStore.model.Book;
import fi.hh.vko2.BookStore.model.BookRepository;


@SpringBootApplication
public class BookstoreApplication {
	 private static final Logger log = (Logger) LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
		
	}
	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args)-> {
		log.info("Getting books");
			repository.save(new Book("Palvelinohjelmointi", "juhani", 2015, 2123546, 25.20));
			repository.save(new Book("Mobiiliohjelmointi", "juhani", 2018, 54984198, 50.75));
		for(Book book : repository.findAll()) {
				log.info(book.toString());
			}
		};
	}
}
