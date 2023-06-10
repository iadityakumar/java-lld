package org.aditya.repository;

import lombok.Data;
import org.aditya.model.Post;

import java.util.ArrayList;

@Data
public class PostRepository {
    ArrayList<Post> posts = new ArrayList<Post>();


    public void addPost(Post post) {
        posts.add(post);
    }

    public void deletePost(int postId) {
        posts.removeIf(p -> p.getId() == postId);
    }
}
