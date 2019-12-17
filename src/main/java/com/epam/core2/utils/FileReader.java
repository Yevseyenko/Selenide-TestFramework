package com.epam.core2.utils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

    static String path = System.getProperty("user.dir") + "/src/main/resources/endpoints/endpoint.txt";

    public static List<String> readFileLines() throws IOException {
        return Files.readAllLines(Paths.get(path), Charset.defaultCharset());
    }

    public static String getEndpoint(){
        List<String> endPointParameters = new ArrayList<>();
        try {
            endPointParameters = readFileLines();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return endPointParameters.get(0);
    }

}
