package softuni.exam.instagraphlite.models.DTO.Xml;

import softuni.exam.instagraphlite.models.DTO.Xml.PostImporDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "posts")
@XmlAccessorType(XmlAccessType.FIELD)
public class PostImporRootDto {

    @XmlElement(name = "post")
    private List<PostImporDto> posts;

    public PostImporRootDto() {
    }

    public List<PostImporDto> getPosts() {
        return posts;
    }

    public void setPosts(List<PostImporDto> posts) {
        this.posts = posts;
    }
}
