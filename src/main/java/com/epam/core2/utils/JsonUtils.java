package com.epam.core2.utils;

import com.epam.core2.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.*;

public class JsonUtils {
    public static Map<String, User> getJsonModelFromFile(String path) throws IOException {
        Map<String, User> jsonModels = new HashMap<>();
        List<File> list = Arrays.asList(Objects.requireNonNull(new File(path).listFiles()));
        for (File file : list) {
            ObjectMapper objectMapper = new ObjectMapper();
            Reader reader = new FileReader(file);
            jsonModels.put(file.getName(), objectMapper.readValue(reader, User.class));
        }
        return jsonModels;
    }

    public static String getJson(User jsonModel) throws JsonProcessingException {
        ObjectMapper obj = new ObjectMapper();
        return obj.writeValueAsString(jsonModel);
    }
}
