package json.demo.service;

import json.demo.entities.Post;

import java.util.List;

public interface PostService {

    List<Post> getAllPost();

    Post getPostById(Long id);

    Post addPost(Post post);

    Post updatePost(Post post);

    Post deletePost(Long id);
    long getPostCount();
}
