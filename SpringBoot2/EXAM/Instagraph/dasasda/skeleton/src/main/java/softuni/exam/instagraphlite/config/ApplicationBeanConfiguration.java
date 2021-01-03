package softuni.exam.instagraphlite.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import softuni.exam.instagraphlite.util.ValidationUtilImpl;
import softuni.exam.instagraphlite.util.ValidatorUtil;
import softuni.exam.instagraphlite.util.XmlParser;
import softuni.exam.instagraphlite.util.XmlParserImpl;


@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public Gson gson() {
        return new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();
    }

    @Bean
    public ValidatorUtil validatorUtil() {
        return new ValidationUtilImpl();
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
    @Bean
    public XmlParser xmlParser(){
        return new XmlParserImpl();
    }

}
