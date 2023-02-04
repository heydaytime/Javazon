package net.heydaytime.Javazon.repositories;

import net.heydaytime.Javazon.models.InvoiceModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface InvoiceRepo extends MongoRepository<InvoiceModel, String> {

    Optional<InvoiceModel> findByEmailAndId(String email, String id);

}
