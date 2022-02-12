package com.example.planprehrane.Services;

import com.example.planprehrane.Models.User;
import com.example.planprehrane.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    //GET all users
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = userRepository.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    //user update podatke
    public ResponseEntity<User> updateUser(Long user_id, User user) {
        Optional<User> user1 = userRepository.findById(user_id);
        if(user1.isPresent()) {
            User user2 = user1.get();
            user2.setUsername(user.getUsername());
            user2.setEmail(user.getEmail());
            user2.setPassword(user.getPassword());
            user2.setRezultati(user.getRezultati());
            return new ResponseEntity<>(userRepository.save(user2), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<String> deleteUser(Long user_id) {
        Optional<User> result = userRepository.findById(user_id);

        if (result.isPresent()) {
            User user = result.get();
            userRepository.delete(user);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
