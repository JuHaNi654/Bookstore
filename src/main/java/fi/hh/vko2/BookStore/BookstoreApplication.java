package fi.hh.vko2.BookStore;


import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import ch.qos.logback.classic.Logger;
import fi.hh.vko2.BookStore.model.Book;
import fi.hh.vko2.BookStore.model.BookRepository;
import fi.hh.vko2.BookStore.model.Category;
import fi.hh.vko2.BookStore.model.CategoryRepository;
import fi.hh.vko2.BookStore.model.User;
import fi.hh.vko2.BookStore.model.UserRepository;


@SpringBootApplication
public class BookstoreApplication {
	 private static final Logger log = (Logger) LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
		
	}
	@Bean
	public CommandLineRunner demo(BookRepository brepository, CategoryRepository crepository, UserRepository urepository) {
		return (args)-> {
		log.info("Getting books");
			User user1 = new User("user", "$2a$04$oheZMjsyInGoMrrpzcTAbO76ru1XC7w.DUgb5.QMPBYjCUkOGSI/K", "user@user.fi", "USER");
			User user2 = new User("admin", "$2a$04$fGOyAorfsG6PzTjiZG1GkueAzli1cvd.Jc5fBcOIarQ9mC8Iv2FI.", "admin@admin.fi", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			crepository.save(new Category("Studying"));
			crepository.save(new Category("Comedy"));
			crepository.save(new Category("Horror"));
			
			brepository.save(new Book("Palvelinohjelmointi", "juhani", 2015, 2123546, 25.20, crepository.findByName("Horror").get(0)));
			brepository.save(new Book("Mobiiliohjelmointi", "juhani", 2018, 54984198, 50.75, crepository.findByName("Horror").get(0)));

		for(Book book : brepository.findAll()) {
				log.info(book.toString());
			}
		};
	}
}
