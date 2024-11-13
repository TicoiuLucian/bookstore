package ro.itschool.bookstore.restcontroller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.itschool.bookstore.entity.MusicDisc;
import ro.itschool.bookstore.service.MusicDiscService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/music/disc")
@RequiredArgsConstructor
public class MusicDiscController {

    private final MusicDiscService musicDiscService;

    @GetMapping("/all")
    public List<MusicDisc> getAllMusicDiscs() {
        return musicDiscService.findAllMusicDiscs();
    }

    @GetMapping("/name-{discName}")
    public ResponseEntity<Optional<MusicDisc>> findByName(@PathVariable String discName) {
        return new ResponseEntity<>(musicDiscService.findMusicDiscsByName(discName), HttpStatus.OK);
    }

    @PostMapping("/save-new-disc")
    public ResponseEntity<MusicDisc> saveNewDisc(@RequestBody MusicDisc musicDisc) {
        return new ResponseEntity<>(musicDiscService.saveNewMusicDisc(musicDisc), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Optional<MusicDisc> findDiscById(@PathVariable Integer id) {
        return musicDiscService.findMusicDiscsById(id);
    }

    @GetMapping("/artist-{bandName}")
    public List<MusicDisc> booksBySpecificAuthor(@PathVariable String bandName) {
        return musicDiscService.findAllMusicDiscsByAuthor(bandName);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMusicDisc(@PathVariable Integer id) {
        musicDiscService.deleteMusicDiscById(id);
    }
}
