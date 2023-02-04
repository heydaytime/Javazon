package net.heydaytime.Javazon.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document
public record InvoiceModel(@Id String id,  String email, List<ItemModel> cart, LocalDateTime ETA, LocalDateTime generatedAt){

    public Double getTotalAmount(){
        double totalAmount = 0D;
        for(ItemModel item: cart){
            totalAmount += item.getPrice() * item.getQuantity();
        }
        return totalAmount;
    }
    public Integer getNumberOfProductsOrdered() {
        return cart.size();
    }
}
