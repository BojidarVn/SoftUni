package com.softuni.exercise_6.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name ="books")
public class Book extends BaseEntity {

    private String title;
    private String description;
    private EditionType editionType;
    private BigDecimal prise;
    private int copies;
    private LocalDate releaseDate;
    private AgeRestriction ageRestriction;
    private Author author;

    private Set<Category> categories;

    public Book() {
    }

    @Column(name = "title", nullable = false, length = 50)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "description", length = 1000)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Enumerated(EnumType.ORDINAL)
    public EditionType getEditionType() {
        return editionType;
    }

    public void setEditionType(EditionType editionType) {
        this.editionType = editionType;
    }

    @Column(name = "price",nullable = false)
    public BigDecimal getPrise() {
        return prise;
    }

    public void setPrise(BigDecimal prise) {
        this.prise = prise;
    }

    @Column(name = "copies")
    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    @Column(name = "release_date")
    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
@Enumerated(EnumType.ORDINAL)
    public AgeRestriction getAgeRestriction() {
        return ageRestriction;
    }

    public void setAgeRestriction(AgeRestriction ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
