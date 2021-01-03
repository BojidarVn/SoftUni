package softuni.exam.instagraphlite.models.DTO.Xml;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "post")
@XmlAccessorType(XmlAccessType.FIELD)
public class PostImporDto {

    @XmlElement(name = "caption")
    private  String caption;
    @XmlElement(name = "user")
    private PostUserImportDto user;
    @XmlElement(name = "picture")
    private PostPictureImportDto  picture;

    public PostImporDto() {
    }

    @NotNull
    @Length(min = 21)
    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public PostUserImportDto getUser() {
        return user;
    }

    public void setUser(PostUserImportDto user) {
        this.user = user;
    }

    public PostPictureImportDto getPicture() {
        return picture;
    }

    public void setPicture(PostPictureImportDto picture) {
        this.picture = picture;
    }
}
