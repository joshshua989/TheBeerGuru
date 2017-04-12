package com.joshellen.thebeerguru;

/**
 * Created by Josh on 3/7/2017.
 */
public class BreweryData {

    private int id, rating;
    private String year_established, name, image_link, city, state, website, phone, featured;

    public BreweryData(int id, String name, String image_link, String city, String state, String phone, String website, String year_established, int rating, String featured) {

        this.id = id;
        this.rating = rating;
        this.year_established = year_established;
        this.name = name;
        this.image_link = image_link;
        this.city = city;
        this.state = state;
        this.website = website;
        this.phone = phone;
        this.featured = featured;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage_link() {
        return image_link;
    }

    public void setImage_link(String image_link) {
        this.image_link = image_link;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getYear_established() {
        return year_established;
    }

    public void setYear_established(String year_established) {
        this.year_established = year_established;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getFeatured() {
        return featured;
    }

    public void setFeatured(String featured) {
        this.featured = featured;
    }
}
