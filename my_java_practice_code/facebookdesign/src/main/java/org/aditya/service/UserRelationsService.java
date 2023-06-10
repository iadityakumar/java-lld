package org.aditya.service;

import lombok.AllArgsConstructor;
import org.aditya.model.User;
import org.aditya.repository.UserRelationsRepository;

@AllArgsConstructor
public class UserRelationsService {

    UserRelationsRepository userRelationsRepository;

//    need to set userRelationsRepository

    public void addUserRelation(User follower, User followee) {
        userRelationsRepository.getUserRelations().addUserRelations(follower, followee);
    }
}
