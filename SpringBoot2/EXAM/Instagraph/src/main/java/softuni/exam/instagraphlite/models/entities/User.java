package softuni.exam.instagraphlite.models.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
public class User extends BaseEntity {

    private String username;
    private String password;
    private Picture profilePicture;

    private Set<Post> post;

    public User() {
    }

    @Column(nullable = false,unique = true)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @ManyToOne
    @JoinColumn(name = "profile_picture_id")
    public Picture getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(Picture profilePicture) {
        this.profilePicture = profilePicture;
    }

    @OneToMany(mappedBy = "user")
    public Set<Post> getPost() {
        return post;
    }

    public void setPost(Set<Post> post) {
        this.post = post;
    }
}
