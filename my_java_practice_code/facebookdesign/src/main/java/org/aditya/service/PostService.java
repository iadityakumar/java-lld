package org.aditya.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.aditya.model.Post;
import org.aditya.model.User;
import org.aditya.repository.PostRepository;
import org.aditya.repository.UserRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

@AllArgsConstructor

public class PostService {

    UserRepository userRepository;
    PostRepository postRepository;


    public void addPosts(Post[] posts) {
        Arrays.asList(posts).forEach(post -> postRepository.addPost(post));
    }

    public ArrayList<Post> getPostsForUser(Integer userId) {
        User user = userRepository.getUser(userId);
        ArrayList<Post> allPosts = postRepository.getPosts();
        return new ArrayList(allPosts.stream().filter(post -> post.getCreatedBy() == user.getId()).sorted(Comparator.comparing(Post::getCreatedDate)).collect(Collectors.toList()));
    }
}
