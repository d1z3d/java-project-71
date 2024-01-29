package hexlet.code;

import org.junit.jupiter.api.Test;
import picocli.CommandLine;

import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {

    @Test
    public void testAppSuccess() {
        String path1 = TestUtils.getFixturePath("file1.json");
        String path2 = TestUtils.getFixturePath("file2.json");
        String[] args = {path1, path2};

        App myApp = new App();
        CommandLine cmd = new CommandLine(myApp);

        StringWriter sw = new StringWriter();
        cmd.setOut(new PrintWriter(sw));

        int actual = cmd.execute(args);

        assertEquals(0, actual);
    }

    @Test
    public void testAppFailed() {
        String path1 = TestUtils.getFixturePath("file11TestIn.json");
        String path2 = TestUtils.getFixturePath("file2.json");
        String[] args = {path1, path2};

        App myApp = new App();
        CommandLine cmd = new CommandLine(myApp);

        StringWriter sw = new StringWriter();
        cmd.setOut(new PrintWriter(sw));

        int actual = cmd.execute(args);

        assertEquals(1, actual);
    }
}
