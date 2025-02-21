package com.albumsecommerse.albums.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.albumsecommerse.albums.models.Album;
import com.albumsecommerse.albums.repositories.AlbumRepository;

@RestController
@RequestMapping("/api/albums")
public class AlbumController {
    @Autowired
    private AlbumRepository albumRepository;

    @GetMapping
    public List<Album> getAlbums() {
        return albumRepository.findAll();
    }

    @PostMapping
    public Album addAlbum (@RequestBody Album album) {
        return albumRepository.save(album);
    }

    @PutMapping("/{id}")
    public Album updateAlbum (@RequestParam Long id, @RequestBody Album upAlbum) {
        Album album = albumRepository.findById(id).orElseThrow(() -> new RuntimeException("Album not found"));
        album.setAlb_name(upAlbum.getAlb_name());
        album.setAlb_releaseDate(upAlbum.getAlb_releaseDate());
        album.setAlb_genre(upAlbum.getAlb_genre());
        return albumRepository.save(album);
    }
        
    @DeleteMapping("/{id}")
    public void deleteAlbum (@PathVariable Long id) {
        albumRepository.deleteById(id);
    }
}
