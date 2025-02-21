package com.albumsecommerse.albums.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.albumsecommerse.albums.models.Artist;
import com.albumsecommerse.albums.repositories.ArtistRepository;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/artists")
public class ArtistController {
    @Autowired
    private ArtistRepository artistRepository;

    @GetMapping
    public List<Artist> getArtists() {
        return artistRepository.findAll();
    }

    @PostMapping
    public Artist addArtist (@Validated @RequestBody Artist artist) {
        return artistRepository.save(artist);
    }

    @GetMapping("/{id}")
    public Artist getArtistById(@PathVariable Long id) {
        return artistRepository.findById(id).orElseThrow(() -> new RuntimeException("Artist not found"));
    }

    @PutMapping("/{id}")
    public Artist updateArtist (@PathVariable Long id, @RequestBody Artist upArtist) {
        Artist artist = artistRepository.findById(id).orElseThrow(( () -> new RuntimeException("Artist not found")));
        artist.setArt_name(upArtist.getArt_name());
        artist.setArt_desc(upArtist.getArt_desc());
        artist.setArt_img(upArtist.getArt_img());
        return artistRepository.save(artist);
    }

    @DeleteMapping("/{id}")
    public void deleteArtist (@PathVariable Long id) {
        artistRepository.deleteById(id);
    } 

    @GetMapping("/search")
    public List<Artist> searchArtist(@RequestParam String name) {
        return artistRepository.findByNameArtContaining(name);
    }
}
