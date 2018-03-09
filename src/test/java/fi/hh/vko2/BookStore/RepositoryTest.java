package fi.hh.vko2.BookStore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.hh.vko2.BookStore.model.Book;
import fi.hh.vko2.BookStore.model.BookRepository;
import fi.hh.vko2.BookStore.model.Category;
import fi.hh.vko2.BookStore.model.CategoryRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
public class RepositoryTest {
	
	@Autowired
	private BookRepository brepository;
	@Autowired
	private CategoryRepository crepository;

	@Test
	public void createNewBook() {
		Book book = new Book("Test", "test", 2018, 5959, 5.50, new Category("Horror"));
		brepository.save(book);
		assertThat(book.getId()).isNotNull();
	}
	@Test
	public void createNewCategory() {
		Category category = new Category("Testi");
		crepository.save(category);
		assertThat(category.getCategoryid()).isNotNull();
	}
	
	@Test
	public void findByTitleTest() {
		List<Book> books = brepository.findByTitle("Palvelinohjelmointi");
		
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getAuthor()).isEqualTo("juhani");
	}
}
