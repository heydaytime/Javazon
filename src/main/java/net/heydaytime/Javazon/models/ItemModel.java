package net.heydaytime.Javazon.models;

import lombok.Data;
import net.heydaytime.Javazon.enums.ItemCategory;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class ItemModel {

    @Id
    private String id;

    //--------------------------

    private final String productName;

    private final Double price;

    private final String manufacturer;
    private final Double rating;
    private final Integer numberOfReviews;
    private final String description;
    private final ItemCategory itemCategory;


    private Integer quantity;

    public ItemModel(String productName, Double price, String manufacturer, Double rating, Integer numberOfReviews, String description, ItemCategory itemCategory) {
        this.productName = productName;
        this.price = price;
        this.manufacturer = manufacturer;
        this.rating = rating;
        this.numberOfReviews = numberOfReviews;
        this.description = description;
        this.itemCategory = itemCategory;

    }
}
