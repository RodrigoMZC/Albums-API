package com.albumsecommerse.albums.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.albumsecommerse.albums.models.Artist;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
    List<Artist> findByNameArtContaining(String name);
}
