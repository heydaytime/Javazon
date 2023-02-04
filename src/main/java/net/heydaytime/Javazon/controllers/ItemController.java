package net.heydaytime.Javazon.controllers;

import lombok.AllArgsConstructor;
import net.heydaytime.Javazon.functions.FakeItemGenerator;
import net.heydaytime.Javazon.models.ItemModel;
import net.heydaytime.Javazon.services.ItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/items")
@AllArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ItemController {

    private final ItemService itemService;
    private final FakeItemGenerator fakeItemGenerator;

    @GetMapping()
    public List<ItemModel> fetchItemByCategory(@RequestParam (value = "ctg") String category, @RequestParam(value = "by_w") String byWhat, @RequestParam(value = "ord") String order){

        return itemService.getItemsBy(category, byWhat, order);
    }

    @GetMapping("gen-fake")
    public List<ItemModel> genFake() throws Exception {
        return fakeItemGenerator.generate();
    }

}
