package softuni.exam.instagraphlite.service;

import softuni.exam.instagraphlite.models.DTO.entities.Picture;

import java.io.IOException;

public interface PictureService {
    Boolean areImported();
    String readFromFileContent() throws IOException;
    String importPictures() throws IOException;
    String exportPictures();

    Picture getByPath(String path);

}
