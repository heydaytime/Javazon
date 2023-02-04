package net.heydaytime.Javazon.repositories;

import net.heydaytime.Javazon.models.ItemModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ItemRepo extends MongoRepository<ItemModel, String> {


    List<ItemModel> findAllByItemCategory(String itemCategory);
    ItemModel findByProductName(String productName);

}
