package net.heydaytime.Javazon.services;

import lombok.AllArgsConstructor;
import net.heydaytime.Javazon.models.UserModel;
import net.heydaytime.Javazon.models.UserVerificationModel;
import net.heydaytime.Javazon.repositories.UserRepo;
import net.heydaytime.Javazon.repositories.UserVerificationRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
@AllArgsConstructor
public class UserVerificationService {

    private final Logger LOG = LoggerFactory.getLogger(UserVerificationService.class);

    private final UserVerificationRepo userVerificationRepo;
    private final UserRepo userRepo;

    public Boolean userExists(String email) {

        userVerificationRepo.findUserByEmail(email).ifPresentOrElse(userVerification -> {
            LOG.info("{} Verification Exists", userVerification);
        }, () -> {
            LOG.warn("{} Verification Does Not Exist", email);
        });
        return userVerificationRepo.findUserByEmail(email).isPresent();
    }

    public UserVerificationModel createUserVerificationCode(String id, String email) {

        StringBuilder verificationCode = new StringBuilder();
        String allowedCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        for (int i = 0; i < 6; i++) {
            verificationCode.append(allowedCharacters.charAt((int) Math.round(Math.random() * (allowedCharacters.length() - 1))));
        }

        LOG.info("{} Created A Verification Code - {}", email, verificationCode.toString());

        return userVerificationRepo.insert(new UserVerificationModel(id, email, verificationCode.toString(), LocalDateTime.now()));
    }

    public ResponseEntity<String> verify(String email, String verificationCode) {
        if (!userExists(email)) {
            LOG.warn("{} Does Not Exist To Verify", email);
            return new ResponseEntity<>("User does not exist to verify", HttpStatus.BAD_REQUEST);
        }

        LOG.info("{} passed {} for verification", email, verificationCode);

        UserModel currentUser = userRepo.findUserByEmail(email).get();
        UserVerificationModel currentVerificationUser = userVerificationRepo.findUserByEmail(email).get();

        if(currentUser.getIsVerified()) {
            LOG.warn("{} is already verified", currentUser.getEmail());
            return new ResponseEntity<>("User already verified", HttpStatus.BAD_REQUEST);
        }

        String correctVerificationCode = currentVerificationUser.getVerificationCode();

        if (Objects.equals(verificationCode, correctVerificationCode)) {
            LOG.info("{} Successfully Verified", email);
            if (userRepo.findUserByEmail(email).isPresent()) {

                userRepo.delete(currentUser);
                currentUser.setIsVerified(true);
                userRepo.insert(currentUser);

                userVerificationRepo.delete(currentVerificationUser);

                return new ResponseEntity<>("Success", HttpStatus.OK);
            }
        } else {
            LOG.warn("{} Incorrect Verification Code Passed", email);
            return new ResponseEntity<>("Fail", HttpStatus.NOT_ACCEPTABLE);
        }

        return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
