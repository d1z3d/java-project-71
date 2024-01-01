package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Parser {
    public static Map<String, Object> parse(String pathToFile) throws Exception {
        Path path = Paths.get(pathToFile).toAbsolutePath().normalize();

        if (!Files.exists(path)) {
            throw new Exception(String.format("File %s does not exist", path));
        }

        String data = Files.readString(path);
        ObjectMapper objectMapper;

        if (pathToFile.toLowerCase().contains(".json")) {
            objectMapper = new ObjectMapper();
        } else if (pathToFile.toLowerCase().contains(".yml")) {
            objectMapper = new YAMLMapper();
        } else {
            return new HashMap<>();
        }

        return objectMapper.readValue(data, new TypeReference<Map<String, Object>>() { });
    }
}
