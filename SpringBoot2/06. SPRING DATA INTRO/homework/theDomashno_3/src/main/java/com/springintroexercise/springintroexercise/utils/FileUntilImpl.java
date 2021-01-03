package com.springintroexercise.springintroexercise.utils;


import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class FileUntilImpl implements FileUtil {
    @Override
    public String[] fileContext(String path) throws IOException {
        File file = new File(path);
        BufferedReader bf = new BufferedReader(new FileReader(file));

        List<String> info = new ArrayList<>();

        String line;
        while ((line = bf.readLine()) != null) {
            info.add(line);

        }

        return info
                .stream()
                .filter(l -> !l.equals(""))
                .toArray(String[]::new);
    }
}
