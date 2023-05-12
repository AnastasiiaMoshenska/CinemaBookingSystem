package com.project.cinemabookingsystem.persistence.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name="MOVIES")
public class Movie {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String description;
    private LocalDateTime date;
    private String genre;
    private int age;
    private String imgPath;
    private int hall;
    private int price;

    public Movie() {
    }

    public Movie(String title, String description, LocalDateTime date, String genre, int age, String imgPath, int hall, int price) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.genre = genre;
        this.age = age;
        this.imgPath = imgPath;
        this.hall = hall;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public int getHall() {
        return hall;
    }

    public void setHall(int hall) {
        this.hall = hall;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return age == movie.age && hall == movie.hall && price == movie.price && Objects.equals(id, movie.id) && Objects.equals(title, movie.title) && Objects.equals(description, movie.description) && Objects.equals(date, movie.date) && Objects.equals(genre, movie.genre) && Objects.equals(imgPath, movie.imgPath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, date, genre, age, imgPath, hall, price);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", genre='" + genre + '\'' +
                ", age=" + age +
                ", imgPath='" + imgPath + '\'' +
                ", hall=" + hall +
                ", price=" + price +
                '}';
    }
}
