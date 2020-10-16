package com.common.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class JacksonUtils {


    public static <T> T getJsonFileMappedToPojoClass(String jsonFileName, Class<T> pojoClassName) throws IllegalAccessException, InstantiationException, IOException {
        T object = pojoClassName.newInstance();
        ObjectMapper mapper = new ObjectMapper();
        object = mapper.readValue(new File(jsonFileName), pojoClassName);
        return object;
    }

    public static <T> T getJsonStringMappedToPojoClass(String responseString, Class<T> pojoClassName) throws IllegalAccessException, InstantiationException, IOException {
        T object = pojoClassName.newInstance();
        ObjectMapper mapper = new ObjectMapper();
        object = mapper.readValue(responseString, pojoClassName);
        return object;
    }

    public static String buildParametrizedJsonToPostFromFile(File file, Map<String, String> valuesToChange) throws IOException {
        String JsonFileAsAString = FileUtils.readFileToString(file, "UTF-8");
        for (String key : valuesToChange.keySet()) {
            JsonFileAsAString = StringUtils.replace(JsonFileAsAString, "$" + key, valuesToChange.get(key));
        }
        return JsonFileAsAString;

    }

    public static String buildParametrizedJsonToPostFromString(String jsonBodyToPost, Map<String, String> valuesToChange) throws IOException {
        String JsonAsAString = jsonBodyToPost;
        for (String key : valuesToChange.keySet()) {
            JsonAsAString = StringUtils.replace(JsonAsAString, "$" + key, valuesToChange.get(key));
        }
        return JsonAsAString;

    }

}