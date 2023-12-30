package hexlet.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class UtilTest {
    private Path firstPathToFile;
    private Path pathDoesntExist;


    @BeforeEach
    public void prepareData() {
        firstPathToFile = Paths.get("src", "test", "resources", "stubs", "file1Test.json");
        pathDoesntExist = Paths.get("src", "test", "resources", "stubs", "pathDoesntExist.json");
    }

    @Test
    public void parseTest() throws Exception {
        String actualSuccessAttempt = Files.readString(firstPathToFile);
        String expectedSuccessAttempt = Util.parse(firstPathToFile.toString());
        String expectedMessage = "does not exist";
        Exception exc = assertThrows(Exception.class, () -> {
            Util.parse(pathDoesntExist.toString());
        });

        assertEquals(actualSuccessAttempt, expectedSuccessAttempt);
        assertTrue(exc.getMessage().contains(expectedMessage));
    }


    @Test
    public void getDataTest() throws Exception {
        Map<String, Object> expected = new HashMap<>();
        expected.put("host", "hexlet.io");
        expected.put("timeout", 50);
        expected.put("proxy", "123.234.53.22");
        expected.put("follow", "false");
        String fileData = Util.parse(firstPathToFile.toString());
        Map<String, Object> actualMap = Util.getData(fileData);

        assertEquals(actualMap.size(), expected.size());
    }
}
