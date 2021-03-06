package softuni.exam.instagraphlite.models.DTO.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "pictures")
public class Picture  extends BaseEntity{

    private String path;
    private double size;
    private Set<User> users;
    private Set<Post> posts;

    public Picture() {
    }

    @Column(name = "path",nullable = false,unique = true)
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    @Column(name = "size",nullable = false)
    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    @OneToMany(mappedBy = "profilePicture")
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @OneToMany(mappedBy = "picture")
    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }
}
