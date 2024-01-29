package hexlet.code;

import java.nio.file.Paths;

public class TestUtils {
    public static String getFixturePath(String file) {
        return Paths.get("src", "test", "resources", file).toString();
    }
}
