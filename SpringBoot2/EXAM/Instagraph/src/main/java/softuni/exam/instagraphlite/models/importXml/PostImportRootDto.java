package softuni.exam.instagraphlite.models.importXml;

import org.springframework.data.annotation.AccessType;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "posts")
@AccessType(AccessType.Type.FIELD)
public class PostImportRootDto {

    @XmlElement(name = "post")
    private List<PostImportDto> posts;

    public PostImportRootDto() {
    }

    public List<PostImportDto> getPosts() {
        return posts;
    }

    public void setPost(List<PostImportDto> posts) {
        this.posts = posts;
    }
}
