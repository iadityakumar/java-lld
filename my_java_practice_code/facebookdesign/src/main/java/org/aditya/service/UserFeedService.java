package org.aditya.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.aditya.model.Post;
import org.aditya.model.User;
import org.aditya.repository.PostRepository;
import org.aditya.repository.UserRelationsRepository;
import org.aditya.repository.UserRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AllArgsConstructor
public class UserFeedService {

    PostService postService;
    UserRelationsRepository userRelationsRepository;
    UserRepository userRepository;

    public ArrayList<Post> getUserFeed(Integer userId)
    {
        User user = userRepository.getUser(userId);
//        ArrayList<User> followers = new ArrayList<>(userRelationsRepository.getUserRelations().getUserFollowers(user).stream().map(id -> userRepository.getUser(id)).collect(Collectors.toList()));
//        ArrayList<Integer> followers = userRelationsRepository.getUserRelations().getUserFollowers(user);
//        return  new ArrayList<>(followers.stream().map(id -> postService.getPostsForUser(id)).flatMap(list -> list.stream()).collect(Collectors.toList()));
        List<Integer> userIds = Stream.of(userRelationsRepository.getUserRelations().getUserFollowers(user), (userRelationsRepository.getUserRelations().getUserFollowees(user))).flatMap(Collection::stream).collect(Collectors.toList());
        return getPostsFromUsers(userIds);
    }

    public ArrayList<Post> getPostsFromUsers(List<Integer> userIds)
    {
//        User user = userRepository.getUser(userId);
//        ArrayList<User> followers = new ArrayList<>(userRelationsRepository.getUserRelations().getUserFollowers(user).stream().map(id -> userRepository.getUser(id)).collect(Collectors.toList()));
//        ArrayList<Integer> followers = userRelationsRepository.getUserRelations().getUserFollowers(user);
        return  new ArrayList<>(userIds.stream().map(id -> postService.getPostsForUser(id)).flatMap(list -> list.stream()).collect(Collectors.toList()));
    }


//    https://stackoverflow.com/a/25038430
    public ArrayList<Post> getPaginatedUserFeed(Integer userId, Integer page, Integer perPage)
    {
       return new ArrayList<>(getUserFeed(userId).stream().skip(page * perPage).limit(perPage).collect(Collectors.toList()));
    }

}
