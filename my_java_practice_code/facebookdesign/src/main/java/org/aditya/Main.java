package org.aditya;

import org.aditya.model.Post;
import org.aditya.model.User;
import org.aditya.model.UserRelations;
import org.aditya.repository.PostRepository;
import org.aditya.repository.UserRelationsRepository;
import org.aditya.repository.UserRepository;
import org.aditya.service.PostService;
import org.aditya.service.UserFeedService;
import org.aditya.service.UserService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        User user = new User("test", "test@gmail.com", "123456789");
        User user2 = new User("test2", "tes2t@gmail.com", "1234567892");

        UserRepository userRepository = new UserRepository();
        UserService userService = new UserService(userRepository);
        Arrays.asList(new User[]{user, user2}).forEach(u -> userService.createUser(u));

        Post post = new Post("title1","testp1", user.getId());
        PostRepository postRepository = new PostRepository();
        PostService postService = new PostService(userRepository, postRepository);
        postService.addPosts(new Post[] {post} );


        UserRelationsRepository userRelationsRepository = new UserRelationsRepository();
        UserRelations userRelations = new UserRelations();
        userRelations.addUserRelations(user, user2);
        userRelationsRepository.setUserRelations(userRelations);


//        TODO: print posts by user
        UserFeedService userFeedService = new UserFeedService(postService,userRelationsRepository, userRepository);
        System.out.println(userFeedService.getPaginatedUserFeed(user.getId(), 0, 10));

    }
}