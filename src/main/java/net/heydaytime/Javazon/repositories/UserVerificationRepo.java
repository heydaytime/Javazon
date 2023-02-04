package net.heydaytime.Javazon.repositories;

import net.heydaytime.Javazon.models.UserVerificationModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserVerificationRepo extends MongoRepository<UserVerificationModel, String> {

    Optional<UserVerificationModel> findUserByEmail(String email);


}
