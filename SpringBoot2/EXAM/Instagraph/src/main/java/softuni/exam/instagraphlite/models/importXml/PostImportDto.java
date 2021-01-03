package softuni.exam.instagraphlite.models.importXml;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "post")
@XmlAccessorType(XmlAccessType.FIELD)
public class PostImportDto {

    @XmlElement
    private String caption;

    @XmlElement
    private PostToUser user;

    @XmlElement
    private PostToPicture picture;

    public PostImportDto() {
    }

    @NotNull
    @Length(min = 21)
    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    @NotNull
    public PostToUser getUser() {
        return user;
    }

    public void setUser(PostToUser user) {
        this.user = user;
    }

    @NotNull
    public PostToPicture getPicture() {
        return picture;
    }

    public void setPicture(PostToPicture picture) {
        this.picture = picture;
    }
}
