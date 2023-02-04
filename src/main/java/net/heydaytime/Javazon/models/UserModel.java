package net.heydaytime.Javazon.models;

import lombok.Data;
import net.heydaytime.Javazon.enums.Gender;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data // Auto Generates Constructors, Getters And Setters
@Document
public class UserModel {

    @Id //Mongodb ID for Document

    private String id;
    private final String firstName;
    private final String lastName;
    private final Date dob;


    @Indexed(unique = true)
    private final String email;
    private final String password;

    private final Gender gender;

    private Boolean isVerified;

    private List<ItemModel> cart = new ArrayList<>();


    public String generateId(){
        id = new ObjectId().toString();
        return id;
    }

}

