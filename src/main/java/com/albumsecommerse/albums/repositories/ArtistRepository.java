package com.albumsecommerse.albums.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.albumsecommerse.albums.entities.Artist;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
    
}
