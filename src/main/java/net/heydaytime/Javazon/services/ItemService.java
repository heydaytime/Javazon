package net.heydaytime.Javazon.services;

import lombok.AllArgsConstructor;
import net.heydaytime.Javazon.enums.ItemCategory;
import net.heydaytime.Javazon.models.ItemModel;
import net.heydaytime.Javazon.repositories.ItemRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;

@AllArgsConstructor
@Service
public class ItemService {

    private final static Logger LOG = LoggerFactory.getLogger(ItemService.class);
    private final ItemRepo itemRepo;

    public List<ItemModel> getAllItems() {
        return itemRepo.findAll();
    }

    public ItemModel createItem(ItemModel item) {
        return itemRepo.insert(item);
    }

    public ItemModel getItemById(String Id) {
        Optional<ItemModel> itemOptional = itemRepo.findById(Id);

        itemOptional.ifPresentOrElse(item -> {
            LOG.info("{} item requested exists", item);
        }, () -> {
            LOG.warn("{} item requested does not exist", Id);
        });

        return itemOptional.orElse(null);
    }

    public ItemModel getItemByProductName(String name) {

        return itemRepo.findByProductName(name);
    }

    public List<ItemModel> getItemsBy(String category, String byWhat, String order) {

        List<ItemModel> allItems = getAllItems();
        List<ItemModel> requiredItems = new ArrayList<>();

        ItemCategory[] possibleEnumValues = ItemCategory.values();

        if (category.equals("ALL")) {
            requiredItems = allItems;
        } else {

            for (ItemCategory c : possibleEnumValues) {
                if (c == ItemCategory.valueOf(category)) {

                    for (ItemModel item : allItems) {
                        if (item.getItemCategory().equals(c)) {
                            requiredItems.add(item);
                        }
                    }
                    break;
                }
            }
        }

        switch (byWhat) {

            case "fb_rat" -> {
                requiredItems.sort(Comparator.comparing(ItemModel::getRating));
            }

            case "fb_rev" -> {
                requiredItems.sort(Comparator.comparing(ItemModel::getNumberOfReviews));

            }

            case "fb_pr" -> {
                requiredItems.sort(Comparator.comparing(ItemModel::getPrice));
            }

            default -> {
                return null;
            }
        }

        switch (order) {
            case "lth" -> {
            }
            case "htl" -> {
                Collections.reverse(requiredItems);
            }
            default -> {
                return null;
            }
        }

        return requiredItems;
    }
}
