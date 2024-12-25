package com.example.productcatalogserviceproxy.clients.fakestore.dtos;

public class FakeStoreProductDto {
    private long id;
    private String title;
    private String description;
    private double price;
    private String image;
    private String category;
    private FakeStoreRatingDto fakeStoreRatingDto;

    // Getters
    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }

    public String getCategory() {
        return category;
    }

    public FakeStoreRatingDto getFakeStoreRatingDto() {
        return fakeStoreRatingDto;
    }

    // Setters
    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setFakeStoreRatingDto(FakeStoreRatingDto fakeStoreRatingDto) {
        this.fakeStoreRatingDto = fakeStoreRatingDto;
    }

    // toString Method
    @Override
    public String toString() {
        return "FakeStoreProductDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", image='" + image + '\'' +
                ", category='" + category + '\'' +
                ", fakeStoreRatingDto=" + fakeStoreRatingDto +
                '}';
    }
}
