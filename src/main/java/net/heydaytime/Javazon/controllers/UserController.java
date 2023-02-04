package net.heydaytime.Javazon.controllers;

import lombok.AllArgsConstructor;
import net.heydaytime.Javazon.email.EmailDetails;
import net.heydaytime.Javazon.email.EmailServiceImpl;
import net.heydaytime.Javazon.functions.HTML_Templates;
import net.heydaytime.Javazon.functions.NullChecker;
import net.heydaytime.Javazon.models.InvoiceModel;
import net.heydaytime.Javazon.models.ItemModel;
import net.heydaytime.Javazon.models.UserModel;
import net.heydaytime.Javazon.models.UserVerificationModel;
import net.heydaytime.Javazon.services.UserService;
import net.heydaytime.Javazon.services.UserVerificationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("api/v1/users")
@AllArgsConstructor // Dependency Injection
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    private final UserService userService;
    private final UserVerificationService userVerificationService;

    private final EmailServiceImpl emailService;

    @GetMapping
    public List<UserModel> fetchAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("signup")
    public ResponseEntity<String> createUser(@RequestBody UserModel user) throws URISyntaxException, IOException {
       user.setIsVerified(false);
       UserModel newUser = userService.createNewUser(user);
       if(newUser == null) return new ResponseEntity<>("That user already exists", HttpStatus.BAD_REQUEST);

       UserVerificationModel userVerification = userVerificationService.createUserVerificationCode(newUser.getId(), newUser.getEmail());
       emailService.sendSimpleMail(new EmailDetails(newUser.getEmail(), "Javazon Verification Code", HTML_Templates.verificationCode(userVerification.getVerificationCode(), userVerification.getGeneratedAt().toString())),
                            true);

       return new ResponseEntity<>("Successfully created a user! Check your email for further verification...", HttpStatus.OK);
    }

    @PostMapping("verify")
    public ResponseEntity<String> verify(@RequestBody UserVerificationModel userVerification) throws URISyntaxException, IOException {

        String email = userVerification.getEmail();
        String verificationCode = userVerification.getVerificationCode();



        ResponseEntity<String> response = userVerificationService.verify(email, verificationCode);

        if(response.getStatusCode() == HttpStatus.OK){
            emailService.sendSimpleMail(new EmailDetails(email, "Javazon Verification Was Successful", HTML_Templates.verificationCodeSuccess()), true);
        }
        return response;
    }


    @PostMapping("login")
    public ResponseEntity<UserModel> login(@RequestBody UserModel user) {
        UserModel loggedInUser =  userService.login(user);

        if(NullChecker.check(loggedInUser)){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        else {
            return new ResponseEntity<>(loggedInUser, HttpStatus.OK);
        }
    }

    @GetMapping("add-item")
    public ResponseEntity<List<ItemModel>> addItem(@RequestParam("u_id") String userId, @RequestParam(value = "i_attr") String itemAttr, @RequestParam(value = "by_w") String byWhat) {

       List<ItemModel> userCart = userService.addItemToCart(userId, itemAttr, byWhat);


       if(NullChecker.check(userCart)){
           return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
       }
       else {
        return new ResponseEntity<>(userCart, HttpStatus.OK);
       }
    }

    @GetMapping("clear-cart")
    public ResponseEntity<List<ItemModel>> clearCart(@RequestParam(value = "u_id") String userId, @RequestParam("i_ud") String itemId){

        List<ItemModel> clearedItems = userService.clearUserCart(userId, itemId);

        if(NullChecker.check(clearedItems)){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        else{
            return new ResponseEntity<>(clearedItems, HttpStatus.OK);
        }

    }

    @GetMapping("get-cart")
    public ResponseEntity<List<ItemModel>> getCart(@RequestParam(value = "u_id") String userId){

        List<ItemModel> userCart = userService.getCart(userId);

        if(Objects.equals(userCart, null)){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        else {
            return new ResponseEntity<>(userCart, HttpStatus.OK);
        }
    }

    @GetMapping("checkout")
    public ResponseEntity<InvoiceModel> checkout(@RequestParam(value = "u_id") String userId) throws URISyntaxException, IOException {

        InvoiceModel invoice = userService.checkout(userId);

        if (Objects.equals(invoice, null) || invoice.cart().toArray().length == 0 || invoice.getTotalAmount() == 0) {

            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } else {

            emailService.sendSimpleMail(new EmailDetails(invoice.email(), "Invoice: Javazon - Thank You For Choosing Us!", HTML_Templates.invoice(invoice)), true);
            return new ResponseEntity<>(invoice, HttpStatus.OK);
        }
    }

}
