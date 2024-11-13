package ro.itschool.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.itschool.bookstore.entity.Magazine;

import java.util.List;
import java.util.Optional;

@Repository
public interface MagazineRepository extends JpaRepository<Magazine, Integer> {
    Optional<Magazine> findByName(String name);

    List<Magazine> findByPublisher(String publisher);
}
