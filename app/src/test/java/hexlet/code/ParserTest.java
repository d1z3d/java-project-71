package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParserTest {
    private Path jsonPathFile;
    private Path yamlPathFile;
    private Path pathDoesntExist;
    private String expExpectedMessage;
    private Exception exception;
    private ObjectMapper jsonMapper;
    private ObjectMapper yamlMapper;

    @BeforeEach
    public void prepareData() {
        jsonPathFile = Paths.get("src", "test", "resources", "file1Test.json");
        yamlPathFile = Paths.get("src", "test", "resources", "file3Test.yml");
        pathDoesntExist = Paths.get("src", "test", "resources", "pathDoesntExist.json");
        exception = assertThrows(Exception.class, () -> {
            Parser.parse(pathDoesntExist.toString());
        });
        expExpectedMessage = "does not exist";
        jsonMapper = new ObjectMapper();
        yamlMapper = new YAMLMapper();
    }

    @Test
    public void parseTest() throws Exception {

        Map<String, Object> actual1 = jsonMapper.readValue(Files.readString(jsonPathFile),
                new TypeReference<Map<String, Object>>() { });
        Map<String, Object> expected1 = Parser.parse(jsonPathFile.toString());

        assertEquals(actual1, expected1);
        assertTrue(exception.getMessage().contains(expExpectedMessage));

        Map<String, Object> actual2 = yamlMapper.readValue(Files.readString(yamlPathFile),
                new TypeReference<Map<String, Object>>() { });
        Map<String, Object> expected2 = Parser.parse(yamlPathFile.toString());
        assertEquals(actual2, expected2);
    }
}
