package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class Json {
    public static String fillAsJson(List<Map<String, Object>> data) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> result = new LinkedHashMap<>();
        result.put("differ", data);
        return objectMapper.writeValueAsString(result);
    }

}
