package hexlet.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static hexlet.code.Differ.generate;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {
    private Path firstPathToFile;
    private Path secondPathToFile;

    @BeforeEach
    public void prepareData() {
        firstPathToFile = Paths.get("src", "test", "resources", "stubs", "file1Test.json");
        secondPathToFile = Paths.get("src", "test", "resources", "stubs", "file2Test.json");
    }

    @Test
    public void generateTest() throws Exception {
        String actual = generate(firstPathToFile.toString(), secondPathToFile.toString(), "stylish");
        String expected = "{\n\t+ action: test field that starts with A"
                + "\n\t- follow: false\n\t"
                + "  host: hexlet.io\n\t"
                + "- proxy: 123.234.53.22\n\t"
                + "- timeout: 50\n\t"
                + "+ timeout: 20\n\t"
                + "+ verbose: true\n}";

        assertEquals(expected, actual);
    }
}
