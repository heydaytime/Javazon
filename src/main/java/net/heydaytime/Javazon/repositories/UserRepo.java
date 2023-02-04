package net.heydaytime.Javazon.repositories;


import net.heydaytime.Javazon.models.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepo extends MongoRepository<UserModel, String> {
    Optional<UserModel> findUserByEmail(String email);

    UserModel findUserById(String Id);

}