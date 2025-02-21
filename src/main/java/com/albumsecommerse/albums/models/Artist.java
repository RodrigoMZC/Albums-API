package com.albumsecommerse.albums.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "artist")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "art_id")
    private Long art_id;

    @Column(name = "art_name", nullable = false)
    private String art_name;

    @Column(name = "art_desc", nullable = true)
    private String art_desc;

    @Column(name = "art_img")
    private String art_img;

    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Album> album;

    public Artist() {
    }

    public Artist(Long art_id, String art_name, String art_desc, String art_img, List<Album> album) {
        this.art_id = art_id;
        this.art_name = art_name;
        this.art_desc = art_desc;
        this.art_img = art_img;
        this.album = album;
    }

    public Artist(String art_name, String art_desc, String art_img, List<Album> album) {
        this.art_name = art_name;
        this.art_desc = art_desc;
        this.art_img = art_img;
        this.album = album;
    }

    public Long getArt_id() {
        return art_id;
    }

    public void setArt_id(Long art_id) {
        this.art_id = art_id;
    }

    public String getArt_name() {
        return art_name;
    }

    public void setArt_name(String art_name) {
        this.art_name = art_name;
    }

    public String getArt_desc() {
        return art_desc;
    }

    public void setArt_desc(String art_desc) {
        this.art_desc = art_desc;
    }

    public String getArt_img() {
        return art_img;
    }

    public void setArt_img(String art_img) {
        this.art_img = art_img;
    }

    public List<Album> getAlbum() {
        return album;
    }

    public void setAlbum(List<Album> album) {
        this.album = album;
    }

    @Override
    public String toString() {
        return "Artist{" +
            "artId=" + art_id +
            ", artName='" + art_name + '\'' +
            ", artDesc='" + art_desc + '\'' +
            ", artImg='" + art_img + '\'' +
            ", albums=" + (album != null ? album.size() : "null") +
            '}';
    }
}
