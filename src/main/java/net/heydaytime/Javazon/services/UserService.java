package net.heydaytime.Javazon.services;

import lombok.AllArgsConstructor;
import net.heydaytime.Javazon.functions.Generator;
import net.heydaytime.Javazon.functions.NullChecker;
import net.heydaytime.Javazon.models.InvoiceModel;
import net.heydaytime.Javazon.models.ItemModel;
import net.heydaytime.Javazon.models.UserModel;
import net.heydaytime.Javazon.repositories.InvoiceRepo;
import net.heydaytime.Javazon.repositories.UserRepo;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserService {

    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    private final UserRepo userRepo;
    private final ItemService itemService;

    private final InvoiceRepo invoiceRepo;

    public List<UserModel> getAllUsers() {
        return userRepo.findAll();
    }

    public UserModel userExistenceByEmail(String email) {

        Optional<UserModel> userOptional = userRepo.findUserByEmail(email);

        userOptional.ifPresentOrElse(usr -> {
            LOG.warn("{} exists", usr.getEmail());
        }, () -> {
            LOG.info("{} does not exist", email);
        });
        return userOptional.orElse(null);

    }

    public UserModel userExistenceById(String id) {

        if (id == null) return null;

        Optional<UserModel> userOptional = userRepo.findById(id);

        userOptional.ifPresentOrElse(usr -> {
            LOG.warn("{} does exist", usr.getEmail());
        }, () -> {
            LOG.info("{} does not exist", id);
        });

        return userOptional.orElse(null);
    }

    public UserModel createNewUser(UserModel user) {
        if (Objects.equals(userExistenceByEmail(user.getEmail()), null) && Objects.equals(userExistenceById(user.getId()), null)) {
            user.setCart(new ArrayList<>());
            user.generateId();
            userRepo.insert(user);
            return user;
        }
        return null;
    }

    public UserModel login(UserModel user) {
        Optional<UserModel> realUserOptional = userRepo.findUserByEmail(user.getEmail());
        if (realUserOptional.isPresent()) {
            if (realUserOptional.get().getIsVerified()) {
                UserModel realUser = realUserOptional.get();

                if (Objects.equals(user.getPassword(), realUser.getPassword())) {
                    LOG.info("{} logged in successfully", user.getEmail());
                    return realUser;
                } else {
                    LOG.warn("{} sent wrong password while logging in", user.getEmail());

                }
            } else {
                LOG.warn("{} is not verified to login", user.getEmail());
            }
        } else {
            LOG.warn("{} does not exist to login", user.getEmail());
        }
        return null;
    }

    public List<ItemModel> addItemToCart(String userId, String itemAttr, String byWhat) {

        UserModel verifiedUser = userAuthentication(userRepo.findUserById(userId));
        if (NullChecker.check(verifiedUser)) return null;

        ArrayList<ItemModel> currentCart = verifiedUser.getCart() != null ? (ArrayList<ItemModel>) verifiedUser.getCart() : new ArrayList<>();

        ItemModel itemToBeAdded = null;

        if(byWhat.equals("i_id"))
        itemToBeAdded = itemService.getItemById(itemAttr);
        else if (byWhat.equals("i_pr_n")) {
            itemToBeAdded = itemService.getItemByProductName(itemAttr);
        }
        else return null;

        if (Objects.equals(itemToBeAdded, null)) return null;
        itemToBeAdded.setQuantity(1);

        boolean checkUnique = true;
        for (int i = 0; i < currentCart.toArray().length; i++) {
            if (itemToBeAdded.getProductName().equals(currentCart.get(i).getProductName())) {
                int currentQuantity = currentCart.get(i).getQuantity();
                itemToBeAdded.setQuantity(currentQuantity + 1);
                currentCart.set(i, itemToBeAdded);
                checkUnique = false;
            }
        }
        if (checkUnique) {
            currentCart.add(itemToBeAdded);
        }

        verifiedUser.setCart(currentCart);


        userRepo.deleteById(verifiedUser.getId());
        return userRepo.insert(verifiedUser).getCart();

    }

    public List<ItemModel> getCart(String userId) {

        UserModel verifiedUser = userAuthentication(userRepo.findUserById(userId));
        if (NullChecker.check(verifiedUser)) return null;

        return verifiedUser.getCart();
    }

    public List<ItemModel> clearUserCart(String userId, String itemId) {
        UserModel verifiedUser = userAuthentication(userRepo.findUserById(userId));
        if (NullChecker.check(verifiedUser)) return null;

        List<ItemModel> currentCart = verifiedUser.getCart();

        ItemModel itemToRemove = itemService.getItemById(itemId);

        int quantity = 0;
        boolean exists = false;
        for (ItemModel item : currentCart) {
            if (item.getId().equals(itemId)) {
                quantity = item.getQuantity();
                exists = true;
                break;
            }
        }

        if (!exists) return null;

        itemToRemove.setQuantity(quantity);

        currentCart.remove(itemToRemove);

        verifiedUser.setCart(currentCart);

        userRepo.deleteById(verifiedUser.getId());
        return userRepo.insert(verifiedUser).getCart();
    }


    public InvoiceModel checkout(String userId) {


        UserModel verifiedUser = userAuthentication(userRepo.findUserById(userId));
        if (NullChecker.check(verifiedUser)) return null;

        if (verifiedUser.getCart().size() == 0) {
            LOG.warn("{} cart is empty", userId);
            return null;
        }

        InvoiceModel invoice = new InvoiceModel(new ObjectId().toString(), verifiedUser.getEmail(), verifiedUser.getCart(), Generator.generateRandomizedETA(7), LocalDateTime.now());
        invoiceRepo.insert(invoice);


        LOG.info("{} invoice generated for {}", invoice, userId);

        verifiedUser.setCart(new ArrayList<>());
        userRepo.deleteById(verifiedUser.getId());
        userRepo.insert(verifiedUser);

        return invoice;
    }

    public UserModel userAuthentication(UserModel user) {

        UserModel verifiedUser = userExistenceById(user.getId());

        if (NullChecker.check(verifiedUser) || !verifiedUser.getIsVerified()) {
            LOG.warn("{} failed to meet the requirements to access/modify cart", user.getEmail());
        }

        return verifiedUser;
    }
}
