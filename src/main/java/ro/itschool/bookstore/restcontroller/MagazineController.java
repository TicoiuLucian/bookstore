package ro.itschool.bookstore.restcontroller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.itschool.bookstore.entity.Book;
import ro.itschool.bookstore.entity.Magazine;
import ro.itschool.bookstore.service.MagazineService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/magazines")
@RequiredArgsConstructor
public class MagazineController {

    private final MagazineService magazineService;

    @GetMapping("/all")
    public List<Magazine> getAllMagazines() {
        return magazineService.findAllMagazines();
    }

    @GetMapping("/name-{magazineName}")
    public ResponseEntity<Optional<Magazine>> findByName(@PathVariable String magazineName) {
        return new ResponseEntity<>(magazineService.findMagazineByName(magazineName), HttpStatus.OK);
    }

    @PostMapping("/save-new-magazine")
    public ResponseEntity<Magazine> saveNewMagazine(@RequestBody Magazine magazine) {
        return new ResponseEntity<>(magazineService.saveNewMagazine(magazine), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Optional<Magazine> findMagazineById(@PathVariable Integer id) {
        return magazineService.findMagazineById(id);
    }

    @GetMapping("/publisher-{publisherName}")
    public List<Magazine> magazinesBySpecificPublisher(@PathVariable String publisherName) {
        return magazineService.findAllMagazinesByPublisher(publisherName);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMagazine(@PathVariable Integer id) {
        magazineService.deleteMagazineById(id);
    }
}
