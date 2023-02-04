package net.heydaytime.Javazon.functions;

import lombok.AllArgsConstructor;
import net.heydaytime.Javazon.enums.ItemCategory;
import net.heydaytime.Javazon.models.ItemModel;
import net.heydaytime.Javazon.services.ItemService;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@AllArgsConstructor
@Service
public class FakeItemGenerator {


    private final ItemService itemService;

    public  List<ItemModel> generate() throws Exception {
        List<ItemModel> itemList = new ArrayList<>();

        InputStream stream = FakeItemGenerator.class.getResourceAsStream("/static/FakeProductList.txt");

        assert stream != null;

        Scanner sc = new Scanner(stream);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            System.out.println(line);
            if(line.charAt(0) =='*') continue;
            String[] attributes = line.split(";");
            String productName = attributes[0];
            Double price = Double.valueOf(attributes[1]);
            String manufacturer = attributes[2];
            Double rating = Double.valueOf(attributes[3]);
            if(rating > 5) throw new Exception("Rating cannot be" + rating + " for " + productName);
            Integer numberOfReviews = Integer.valueOf(attributes[4]);
            String description = attributes[5];
            ItemCategory category = ItemCategory.valueOf(attributes[6]);
            itemList.add(new ItemModel(productName, price, manufacturer, rating, numberOfReviews, description, category));
        }

        for(ItemModel item : itemList) itemService.createItem(item);

        return itemList;
    }
}
