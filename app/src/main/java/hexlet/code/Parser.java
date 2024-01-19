package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.util.HashMap;
import java.util.Map;

public class Parser {
    public static Map<String, Object> parse(String data, String fileExtension) throws Exception {
        ObjectMapper objectMapper;

        if (fileExtension.equals("json")) {
            objectMapper = new ObjectMapper();
        } else if (fileExtension.equals("yml")) {
            objectMapper = new YAMLMapper();
        } else {
            return new HashMap<>();
        }
        return objectMapper.readValue(data, new TypeReference<Map<String, Object>>() { });
    }
}
