package com.softuni.exercise_6.utils;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface FileUtils {
    String[] readFileContent(String filePath) throws IOException;
}
