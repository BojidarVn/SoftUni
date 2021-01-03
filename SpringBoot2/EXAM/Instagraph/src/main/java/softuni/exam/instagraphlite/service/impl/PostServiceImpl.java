package softuni.exam.instagraphlite.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.entities.Picture;
import softuni.exam.instagraphlite.models.entities.Post;
import softuni.exam.instagraphlite.models.entities.User;
import softuni.exam.instagraphlite.models.importXml.PostImportDto;
import softuni.exam.instagraphlite.models.importXml.PostImportRootDto;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.repository.PostRepository;
import softuni.exam.instagraphlite.repository.UserRepository;
import softuni.exam.instagraphlite.service.PostService;
import softuni.exam.instagraphlite.util.ValidatorUtil;
import softuni.exam.instagraphlite.util.XmlParser;

import javax.transaction.Transactional;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class PostServiceImpl implements PostService {

    private final static String POST_FILE_PATH = "src/main/resources/files/posts.xml";

    private final PostRepository postRepository;
    private final XmlParser xmlParser;
    private final ValidatorUtil validatorUtil;
    private final ModelMapper modelMapper;

    private final UserRepository userRepository;
    private final PictureRepository pictureRepository;

    public PostServiceImpl(PostRepository postRepository, XmlParser xmlParser,
                           ValidatorUtil validatorUtil, ModelMapper modelMapper, UserRepository userRepository, PictureRepository pictureRepository) {
        this.postRepository = postRepository;
        this.xmlParser = xmlParser;
        this.validatorUtil = validatorUtil;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.pictureRepository = pictureRepository;
    }


    @Override
    public Boolean аreImported() {
        return this.postRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return String.join("", Files.readAllLines(Path.of(POST_FILE_PATH)));
    }

    @Override

    public String importPosts() throws IOException, JAXBException {

        StringBuilder resultInfo = new StringBuilder();


        PostImportRootDto rootDto = this.xmlParser.parseXml(PostImportRootDto.class, POST_FILE_PATH);

        for (PostImportDto postForCheck : rootDto.getPosts()) {

            Picture picture = this.pictureRepository.findFirstByPath(postForCheck.getPicture().getPath());

            User user = this.userRepository.findFirstByUsername(postForCheck.getUser().getUsername());


            if (this.validatorUtil.isValid(postForCheck)) {

                if (this.pictureRepository.findFirstByPath(postForCheck.getPicture().getPath()) != null
                        && this.userRepository.findFirstByUsername(postForCheck.getUser().getUsername()) != null) {

                    Post post = this.modelMapper.map(postForCheck, Post.class);

                    post.setPicture(picture);
                    post.setUser(user);

                    this.postRepository.saveAndFlush(post);

                    resultInfo.append(String.format("Successfully imported Post, made by %s",postForCheck.getUser().getUsername()));
                } else {
                    resultInfo.append("Invalid Post");
                }


            } else {

                resultInfo.append("Invalid Post");
            }
            resultInfo.append(System.lineSeparator());
        }

        return resultInfo.toString();
    }
}





























