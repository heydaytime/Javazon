package net.heydaytime.Javazon.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
public class UserVerificationModel {

    @Id
    private final String id;

    @Indexed(unique = true)
    private final String email;
    private final String verificationCode;

    private final LocalDateTime generatedAt;
}
