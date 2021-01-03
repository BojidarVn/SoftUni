package com.softuni.springintroex.services.models;

import com.softuni.springintroex.domain.entities.AgeRestriction;
import com.softuni.springintroex.domain.entities.EditionType;

import java.math.BigDecimal;

public class BookInfo {

    private String title;
    private EditionType editionType;
    private AgeRestriction ageRestriction;

    public BookInfo(String title, EditionType editionType, AgeRestriction ageRestriction) {
        this.title = title;
        this.editionType = editionType;
        this.ageRestriction = ageRestriction;
    }

    public String getTitle() {
        return title;
    }

    public EditionType getEditionType() {
        return editionType;
    }

    public AgeRestriction getAgeRestriction() {
        return ageRestriction;
    }
}
