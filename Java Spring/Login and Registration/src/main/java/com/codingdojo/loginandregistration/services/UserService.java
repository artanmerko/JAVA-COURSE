package com.codingdojo.loginandregistration.services;

import com.codingdojo.loginandregistration.models.LoginUser;
import com.codingdojo.loginandregistration.models.User;
import com.codingdojo.loginandregistration.repositories.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.Optional;
@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;

    public User register(User newUser, BindingResult result) {


        Optional<User> potentialUser = this.userRepo.findByEmail(newUser.getEmail());

        if (potentialUser.isPresent()) {
            result.rejectValue("email", "EmailTaken", "Email address is already in use.");
        }

        if (!newUser.getPassword().equals(newUser.getConfirm())) {
            result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
        }

        if (result.hasErrors()) {
            return null;
        }

        else {
            String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
            newUser.setPassword(hashed);
            return userRepo.save(newUser);
        }
    }

    public User login(LoginUser newLoginObject, BindingResult result) {

        // Find user in the DB by email
        Optional<User> potentialUser = this.userRepo.findByEmail(newLoginObject.getEmail());

        if (!potentialUser.isPresent()) {
            result.rejectValue("email", "EmailNotFound", "No user found with that Email address.");
        } else {
            if (!BCrypt.checkpw(newLoginObject.getPassword(), potentialUser.get().getPassword())) {
                result.rejectValue("password", "Matches", "Invalid Password!");
            }
        }

        if (result.hasErrors()) {
            return null;
        } else {
            return potentialUser.get();
        }
    }

    public User findOneUser(Long id) {
        return this.userRepo.findById(id).orElse(null);
    }


}