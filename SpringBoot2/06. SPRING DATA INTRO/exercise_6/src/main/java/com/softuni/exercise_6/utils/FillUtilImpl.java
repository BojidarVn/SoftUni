package com.softuni.exercise_6.utils;

import com.softuni.exercise_6.utils.FileUtils;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Component
public class FillUtilImpl implements FileUtils {
    @Override
    public String[] readFileContent(String filePath) throws IOException {

        File file=new File(filePath);

        BufferedReader br=new BufferedReader(new FileReader(file));

        Set<String> result= new LinkedHashSet<>();

        String line;

        while ((line = br.readLine()) !=null ) {

            if (!"".equals(line)) {
                result.add(line);
            }

        }


        return result.toArray(String[]::new);
    }
}
