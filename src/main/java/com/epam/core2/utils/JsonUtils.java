package com.epam.core2.utils;

import com.epam.core2.models.ResponseModel;
import com.epam.core2.models.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.*;

public class JsonUtils {
    private static ObjectReader reader;
    private static ObjectWriter writer;

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

    public static String getJsonStringFromObject(User user) {
        Gson gson = new Gson();
        return gson.toJson(user);
    }

    public static String getJson(User jsonModel) throws JsonProcessingException {
        ObjectMapper obj = new ObjectMapper();
        return obj.writeValueAsString(jsonModel);
    }

    public static ResponseModel fromJsonString(String json) throws IOException {
        System.out.println(json);
        return getObjectReader().readValue(json);
    }


    private static void instantiateMapper() {
        ObjectMapper mapper = new ObjectMapper();
        reader = mapper.reader(ResponseModel.class);
        writer = mapper.writerFor(ResponseModel.class);
    }

    private static ObjectReader getObjectReader() {
        if (reader == null) instantiateMapper();
        return reader;
    }

    private static ObjectWriter getObjectWriter() {
        if (writer == null) instantiateMapper();
        return writer;
    }

    public static String toJsonString(ResponseModel obj) throws JsonProcessingException {
        return getObjectWriter().writeValueAsString(obj);
    }
}
