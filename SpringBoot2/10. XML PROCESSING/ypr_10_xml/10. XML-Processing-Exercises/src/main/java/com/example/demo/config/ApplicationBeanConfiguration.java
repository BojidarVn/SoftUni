package com.example.demo.config;

import com.example.demo.utils.ValidatorUtil;
import com.example.demo.utils.ValidatorUtilImpl;
import com.example.demo.utils.XmlParser;
import com.example.demo.utils.XmlParserImpl;
import com.google.gson.*;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validation;
import javax.validation.Validator;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public Gson gson() {
        return new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .registerTypeAdapter(LocalDateTime.class, new JsonDeserializer<LocalDateTime>() {
                    @Override
                    public LocalDateTime deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                        return LocalDateTime.parse(jsonElement.getAsString(), DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
                    }
                })
                .create();
    }

    @Bean
    public XmlParser XmlParser(){
        return new XmlParserImpl();
    }


//
//    @Bean
//    public Validator validator() {
//        return Validation.buildDefaultValidatorFactory().getValidator();
//    }
//
//    @Bean
//    public ValidatorUtil validatorUtil(){
//        return new ValidatorUtilImpl(validator());
//    }


}
