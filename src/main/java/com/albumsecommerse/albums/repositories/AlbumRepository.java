package com.albumsecommerse.albums.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.albumsecommerse.albums.models.Album;

public interface AlbumRepository extends JpaRepository<Album, Long> {
    
}
