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
        firstPathToFile = Paths.get("src", "test", "resources", "file1Test.json");
        secondPathToFile = Paths.get("src", "test", "resources", "file2Test.json");
        stringBuilder = new StringBuilder();
        stringBuilder.append("{\n");
        stringBuilder.append("  + action: test field that starts with A\n");
        stringBuilder.append("  - follow: false\n");
        stringBuilder.append("    host: hexlet.io\n");
        stringBuilder.append("  - numbers1: [1, 2, 3, 4]\n");
        stringBuilder.append("  + numbers1: avs\n");
        stringBuilder.append("  - proxy: 123.234.53.22\n");
        stringBuilder.append("  - timeout: 50\n");
        stringBuilder.append("  + timeout: 20\n");
        stringBuilder.append("  + verbose: true\n");
        stringBuilder.append("}");
    }

    @Test
    public void generateTest() throws Exception {
        String actual = Differ.generate(firstPathToFile.toString(), secondPathToFile.toString(), "stylish");
        String expected = stringBuilder.toString();

        assertEquals(expected, actual);
    }
}
