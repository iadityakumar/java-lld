package org.aditya.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aditya.exception.UserException;
import org.aditya.model.User;

import java.util.ArrayList;
import java.util.HashMap;

@Data
@NoArgsConstructor
public class UserRepository {
    HashMap<Integer, User> users = new HashMap<Integer, User>();

    public User getUser(Integer id) {

        User u = users.getOrDefault(id, null);
        if (u != null) {
            return u;
        }
        else  {
            throw new UserException("User with " + id + "  not found");
        }
    }

    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    public void removeUser(User user) {
        users.remove(user.getId());
    }
}
