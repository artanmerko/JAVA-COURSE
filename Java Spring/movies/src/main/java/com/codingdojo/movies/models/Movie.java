package com.codingdojo.movies.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message="Title required")
    @Column(unique = true)
    private String title;

    @NotBlank(message="Network required")
    private String network;

    @NotBlank(message="Description required")
    private String description;

    @Column
    @NotBlank(message="PictureUrl required")
    private String pictureUrl;

    @Column(name = "favorite")
    private Boolean favorite;

    @Column
    @NotBlank(message="Video TrailerUrl required")
    private String videoTrailerUrl;

    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    @OneToMany(mappedBy="movie", fetch=FetchType.LAZY)
    private List<Rating> ratings;

    public double getAverageRating() {
        if (ratings.isEmpty()) {
            return 0.0;
        }
        double sum = 0.0;
        for (Rating rating : ratings) {
            sum += rating.getScore();
        }
        return sum / ratings.size();
    }

    public Movie(){}

    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
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

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getVideoTrailerUrl() {
        return videoTrailerUrl;
    }

    public void setVideoTrailerUrl(String videoTrailerUrl) {
        this.videoTrailerUrl = videoTrailerUrl;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }
    public Boolean getFavorite() {
        return favorite;
    }

    public Boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(Boolean favorite) {
        this.favorite = favorite;
    }

    public Movie(Long id, String title, String network, String description, String pictureUrl, Boolean favorite, String videoTrailerUrl, Date createdAt, Date updatedAt, User user, List<Rating> ratings) {
        this.id = id;
        this.title = title;
        this.network = network;
        this.description = description;
        this.pictureUrl = pictureUrl;
        this.favorite = favorite;
        this.videoTrailerUrl = videoTrailerUrl;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.user = user;
        this.ratings = ratings;
    }
}
