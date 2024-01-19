package hexlet.code;

import org.junit.jupiter.api.Test;
import picocli.CommandLine;

import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class AppTest {

    @Test
    public void testAppMainSuccess() {
        String path1 = TestUtils.getFixturePathAsString("file1TestIn.json");
        String path2 = TestUtils.getFixturePathAsString("file2TestIn.json");
        String[] args = {path1, path2};

        App myApp = new App();
        CommandLine cmd = new CommandLine(myApp);

        StringWriter sw = new StringWriter();
        cmd.setOut(new PrintWriter(sw));

        int actual = cmd.execute(args);

        assertEquals(0, actual);
    }

    @Test
    public void testAppMainFailed() {
        String path1 = TestUtils.getFixturePathAsString("file11TestIn.json");
        String path2 = TestUtils.getFixturePathAsString("file2TestIn.json");
        String[] args = {path1, path2};

        App myApp = new App();
        CommandLine cmd = new CommandLine(myApp);

        StringWriter sw = new StringWriter();
        cmd.setOut(new PrintWriter(sw));

        int actual = cmd.execute(args);

        assertEquals(1, actual);
    }
}
