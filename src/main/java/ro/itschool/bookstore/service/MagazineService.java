package ro.itschool.bookstore.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import ro.itschool.bookstore.entity.Book;
import ro.itschool.bookstore.entity.Magazine;
import ro.itschool.bookstore.repository.MagazineRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class MagazineService {

    private final MagazineRepository magazineRepository;


    public Magazine saveNewMagazine(Magazine magazine) {
        log.info("Saving magazine: {}", magazine.getName());
        return magazineRepository.save(magazine);
    }

    public Optional<Magazine> findMagazineById(Integer id) {
        return magazineRepository.findById(id);
    }

    public Optional<Magazine> findMagazineByName(String name) {
        return magazineRepository.findByName(name);
    }

    public List<Magazine> findAllMagazinesByPublisher(String publisher) {
        return magazineRepository.findByPublisher(publisher);
    }

    public List<Magazine> findAllMagazines() {
        return magazineRepository.findAll();
    }

//    @Query("DELETE FROM Magazine m WHERE m.id = :id")
    public void deleteMagazineById(Integer id) {
        if (magazineRepository.existsById(id)) {
            magazineRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("magazine with id {} was not found");
        }
    }
}
