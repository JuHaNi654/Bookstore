package fi.hh.vko2.BookStore.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource
public interface BookRepository extends CrudRepository<Book, Long>
{
	List<Book> findByTitle(String title);
	
	List<Book> findByauthor(@Param("author") String author);
	
	List<Book> findByyear(@Param("year") int year);

}
