package com.codingdojo.bookbroker.services;

import com.codingdojo.bookbroker.models.LoginUser;
import com.codingdojo.bookbroker.models.User;
import com.codingdojo.bookbroker.repositories.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User register(User newUser, BindingResult result){
        Optional<User> userCheck = userRepository.findByEmail(newUser.getEmail());
        if(userCheck.isPresent()){
            result.rejectValue("email","Unique","Account with this email already exists.");
        }
        if(!newUser.getPassword().equals(newUser.getConfirm())){
            result.rejectValue("confirm", "Matches","The Confirm password must match the Password!");
        }
        if(result.hasErrors()){
            return null;
        }
        String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
        newUser.setPassword(hashed);
        newUser = userRepository.save(newUser);
        return newUser;
    }

    public User login(LoginUser newLogin, BindingResult result){
        Optional<User> userCheck = userRepository.findByEmail(newLogin.getEmail());
        if(!userCheck.isPresent()){
            result.rejectValue("email","MissingAccount","No account found!");
            return null;
        }
        User user = userCheck.get();
        if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())){
            result.rejectValue("password","Matches","Invalid Password");
        }
        if(result.hasErrors()){
            return null;
        }

        return user;
    }

    public User findByEmail(String email){
        Optional<User> result = userRepository.findByEmail(email);
        if(result.isPresent()){
            return result.get();
        }
        return null;
    }

    public User findById(Long id){
        Optional<User> result = userRepository.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        return null;
    }
}

