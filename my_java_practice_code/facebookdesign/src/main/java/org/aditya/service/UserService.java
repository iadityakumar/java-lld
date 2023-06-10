package org.aditya.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.aditya.model.User;
import org.aditya.repository.UserRepository;

@AllArgsConstructor
public class UserService {

    UserRepository userRepository;


    public  void createUser(User user) {
        userRepository.addUser(user);
    }

    public void updateUser(User user) {
//        TODO Auto-generated method stub
    }

    public User getUser(Integer id) {
        return userRepository.getUser(id);
    }

}
