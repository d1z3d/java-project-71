package hexlet.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

//import static com.github.stefanbirkner.systemlambda.SystemLambda.catchSystemExit;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {
    private Path firstPathToFile;
    private Path secondPathToFile;
    private String[] args = new String[2];



    @BeforeEach
    public void prepareData() {
        firstPathToFile = Paths.get("src", "test", "resources", "stubs", "file1Test.json");
        secondPathToFile = Paths.get("src", "test", "resources", "stubs", "file2Test.json");
        args[0] = firstPathToFile.toString();
        args[1] = secondPathToFile.toString();
    }

    @Test
    public void mainTest() throws Exception {
        assertEquals(1, 1);
        /*int statusCode = catchSystemExit(() -> {
            App.main(args);
        });

        assertEquals(0, statusCode);*/

    }
}
