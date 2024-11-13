package ro.itschool.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.itschool.bookstore.entity.Book;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    Optional<Book> findByName(String bookName);

    List<Book> findByAuthorName(String authorName);

    @Query("SELECT b FROM Book b WHERE b.isSuitableForChildren = true")
    List<Book> findAllPeekBooks();
}
