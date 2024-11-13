package ro.itschool.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.itschool.bookstore.entity.MusicDisc;

import java.util.List;
import java.util.Optional;

@Repository
public interface MusicDiscRepository extends JpaRepository<MusicDisc, Integer> {
    Optional<MusicDisc> findByName(String name);

    List<MusicDisc> findByBandName(String bandName);
}
