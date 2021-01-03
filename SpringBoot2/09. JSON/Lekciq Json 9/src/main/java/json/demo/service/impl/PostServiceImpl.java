package json.demo.service.impl;

import json.demo.dao.PostRepository;
import json.demo.entities.Post;
import json.demo.excption.NonexistingEntityException;
import json.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class PostServiceImpl implements PostService {

    private PostRepository postRepo;

    @Autowired
    public PostServiceImpl(PostRepository postRepo) {
        this.postRepo = postRepo;
    }

    @Override
    public List<Post> getAllPost() {
        return postRepo.findAll();
    }

    @Override
    public Post getPostById(Long id) {
        return postRepo.findById(id).orElseThrow(() ->
                new NonexistingEntityException(String.format("Post with ID=%s is not exist.", id))
        );
    }

    @Transactional
    @Override
    public Post addPost(Post post) {
        post.setId(null);
        return postRepo.save(post);
    }

    @Transactional
    @Override
    public Post updatePost(Post post) {
        getPostById(post.getId());

        return postRepo.save(post);
    }

    @Transactional
    @Override
    public Post deletePost(Long id) {
        Post removed= getPostById(id);
        postRepo.deleteById(id);
        return removed;
    }

    @Override
    public long getPostCount() {
        return postRepo.count();
    }
}
