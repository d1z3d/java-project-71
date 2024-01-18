package hexlet.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FormatterTest {
    private Path jsonPathFile1;
    private Path jsonPathFile2;
    private Path yamlPathFile1;
    private Path yamlPathFile2;
    private Map<String, Object> dataFromFirstJsonFile;
    private Map<String, Object> dataFromSecondJsonFile;
    private Map<String, Object> dataFromFirstYamlFile;
    private Map<String, Object> dataFromSecondYamlFile;
    StringBuilder stringBuilderToStylish;
    StringBuilder stringBuilderToPlain;
    StringBuilder stringBuilderToJson;

    @BeforeEach
    public void prepareData() throws Exception {
        jsonPathFile1 = Paths.get("src", "test", "resources", "stubs", "file1Test.json");
        jsonPathFile2 = Paths.get("src", "test", "resources", "stubs", "file2Test.json");
        yamlPathFile1 = Paths.get("src", "test", "resources", "stubs", "file3Test.yml");
        yamlPathFile2 = Paths.get("src", "test", "resources", "stubs", "file4Test.yml");

        dataFromFirstJsonFile = Parser.parse(jsonPathFile1.toString());
        dataFromSecondJsonFile = Parser.parse(jsonPathFile2.toString());
        dataFromFirstYamlFile = Parser.parse(yamlPathFile1.toString());
        dataFromSecondYamlFile = Parser.parse(yamlPathFile2.toString());

        stringBuilderToStylish = new StringBuilder();
        stringBuilderToStylish.append("{\n");
        stringBuilderToStylish.append("  + action: test field that starts with A\n");
        stringBuilderToStylish.append("  - follow: false\n");
        stringBuilderToStylish.append("    host: hexlet.io\n");
        stringBuilderToStylish.append("  - numbers1: [1, 2, 3, 4]\n");
        stringBuilderToStylish.append("  + numbers1: avs\n");
        stringBuilderToStylish.append("  - proxy: 123.234.53.22\n");
        stringBuilderToStylish.append("  - timeout: 50\n");
        stringBuilderToStylish.append("  + timeout: 20\n");
        stringBuilderToStylish.append("  + verbose: true\n");
        stringBuilderToStylish.append("}");

        stringBuilderToPlain = new StringBuilder();
        stringBuilderToPlain.append("Property 'action' was added with value: 'test field that starts with A'\n");
        stringBuilderToPlain.append("Property 'follow' was removed\n");
        stringBuilderToPlain.append("Property 'numbers1' was updated. From [complex value] to 'avs'\n");
        stringBuilderToPlain.append("Property 'proxy' was removed\n");
        stringBuilderToPlain.append("Property 'timeout' was updated. From 50 to 20\n");
        stringBuilderToPlain.append("Property 'verbose' was added with value: true\n");

        stringBuilderToJson = new StringBuilder();
        stringBuilderToJson.append("{\"differ\":[{\"hasInBothFiles\":false,\"valueOfSecondFile\":"
                + "\"test field that starts with A\",\"valueOfFirstFile\":null,"
                + "\"operation\":\"added\",\"key\":\"action\"},"
                + "{\"hasInBothFiles\":false,\"valueOfSecondFile\":null,"
                + "\"valueOfFirstFile\":false,\"operation\":\"removed\","
                + "\"key\":\"follow\"},{\"hasInBothFiles\":true,\"valueOfSecondFile\":"
                + "\"hexlet.io\",\"valueOfFirstFile\":\"hexlet.io\","
                + "\"operation\":\"equals\",\"key\":\"host\"},{\"hasInBothFiles\""
                + ":true,\"valueOfSecondFile\":\"avs\","
                + "\"valueOfFirstFile\":[1,2,3,4],\"operation\":\"updated\",\"key\":"
                + "\"numbers1\"},{\"hasInBothFiles\":false,"
                + "\"valueOfSecondFile\":null,\"valueOfFirstFile\":\"123.234.53.22\","
                + "\"operation\":\"removed\",\"key\":\"proxy\"},"
                + "{\"hasInBothFiles\":true,\"valueOfSecondFile\":20,\"valueOfFirstFile\":50,"
                + "\"operation\":\"updated\",\"key\":\"timeout\"},"
                + "{\"hasInBothFiles\":false,\"valueOfSecondFile\":true,\"valueOfFirstFile\":null,"
                + "\"operation\":\"added\",\"key\":\"verbose\"}]}");
    }

    @Test
    public void formatTest() throws Exception {
        String actualStylish = stringBuilderToStylish.toString();
        String expectedStylish = Formatter.format(Util.compareData(dataFromFirstJsonFile,
                dataFromSecondJsonFile),
                "stylish");
        assertEquals(expectedStylish, actualStylish);

        String actualPlain = stringBuilderToPlain.toString();
        String expectedPlain = Formatter.format(Util.compareData(dataFromFirstJsonFile,
                dataFromSecondJsonFile),
                "plain");
        assertEquals(actualPlain, expectedPlain);

        String actualJson = stringBuilderToJson.toString();
        String expectedJson = Formatter.format(Util.compareData(dataFromFirstJsonFile,
                dataFromSecondJsonFile),
                "json");
        assertEquals(actualJson, expectedJson);
    }
}
