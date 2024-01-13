package hexlet.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {
    private Path firstPathToFile;
    private Path secondPathToFile;
    private StringBuilder stringBuilder;

    @BeforeEach
    public void prepareData() {
        firstPathToFile = Paths.get("src", "test", "resources", "stubs", "file1Test.json");
        secondPathToFile = Paths.get("src", "test", "resources", "stubs", "file2Test.json");
        stringBuilder = new StringBuilder();
        stringBuilder.append("{\n");
        stringBuilder.append("\t+ action: test field that starts with A\n");
        stringBuilder.append("\t- follow: false\n");
        stringBuilder.append("\t  host: hexlet.io\n");
        stringBuilder.append("\t- numbers1: [1, 2, 3, 4]\n");
        stringBuilder.append("\t+ numbers1: avs\n");
        stringBuilder.append("\t- proxy: 123.234.53.22\n");
        stringBuilder.append("\t- timeout: 50\n");
        stringBuilder.append("\t+ timeout: 20\n");
        stringBuilder.append("\t+ verbose: true\n");
        stringBuilder.append("}");
    }

    @Test
    public void generateTest() throws Exception {
        String actual = Differ.generate(firstPathToFile.toString(), secondPathToFile.toString(), "stylish");
        String expected = stringBuilder.toString();

        assertEquals(expected, actual);
    }
}
