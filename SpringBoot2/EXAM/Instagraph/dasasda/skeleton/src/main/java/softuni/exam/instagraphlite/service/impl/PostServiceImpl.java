package softuni.exam.instagraphlite.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.DTO.Xml.PostImporRootDto;
import softuni.exam.instagraphlite.models.DTO.entities.Picture;
import softuni.exam.instagraphlite.models.DTO.entities.Post;
import softuni.exam.instagraphlite.models.DTO.entities.User;
import softuni.exam.instagraphlite.repository.PostRepository;
import softuni.exam.instagraphlite.repository.UserRepository;
import softuni.exam.instagraphlite.service.PictureService;
import softuni.exam.instagraphlite.service.PostService;
import softuni.exam.instagraphlite.service.UserService;
import softuni.exam.instagraphlite.util.ValidatorUtil;
import softuni.exam.instagraphlite.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class PostServiceImpl implements PostService {

    private static final String PATH_POST = "src/main/resources/files/posts.xml";

    private final UserRepository userRepository;
    private final PictureService pictureService;
    private final UserService userService;
    private final PostRepository postRepository;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final ValidatorUtil validatorUtil;

    public PostServiceImpl(UserRepository userRepository, PictureService pictureService, UserService userService, PostRepository postRepository, XmlParser xmlParser, ModelMapper modelMapper, ValidatorUtil validatorUtil) {
        this.userRepository = userRepository;
        this.pictureService = pictureService;
        this.userService = userService;
        this.postRepository = postRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
    }

    @Override
    public Boolean аreImported() {
        return this.postRepository.count()>0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(Path.of(PATH_POST));
    }

    @Override
    public String importPosts() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();

        PostImporRootDto postImporRootDto = this.xmlParser.parseXml(PostImporRootDto.class, PATH_POST);
        // TODO to check for username and path ---> unique


       postImporRootDto.getPosts()
               .forEach(dtos -> {
                   if(this.validatorUtil.isValid(dtos)){

                       if(this.userService.getByName(dtos.getUser().getUsername())!= null &&
                       this.pictureService.getByPath(dtos.getPicture().getPath())!=null){

                           Picture picture = this.pictureService.getByPath(dtos.getPicture().getPath());
                           User user = this.userRepository.findFirstByUsername(dtos.getUser().getUsername());

                           Post post = this.modelMapper.map(dtos, Post.class);
                           post.setUser(user);
                           post.setPicture(picture);

                           sb.append(String.format("Successfully imported post, made by %s",
                                   dtos.getUser().getUsername())).append(System.lineSeparator());

                           this.postRepository.saveAndFlush(post);



                       } else {
                           sb.append("Already in db").append(System.lineSeparator());
                       }


                   } else{
                       sb.append("Invalid Post").append(System.lineSeparator());
                   }
               });

        return sb.toString();
    }
}
