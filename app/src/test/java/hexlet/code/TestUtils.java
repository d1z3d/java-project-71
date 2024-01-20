package hexlet.code;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.file.Paths;

public class TestUtils {
    public static String getFixturePathAsString(String file) {
        return Paths.get("src", "test", "resources", file).toString();
    }

    public static String getFixturePathAsString(String folder, String file) {
        return Paths.get("src", "test", "resources", folder,  file).toString();
    }

    public static void createTestOutputFile(String nameOfFile, String data) {
        String path = TestUtils.getFixturePathAsString(nameOfFile);
        File file = new File(path);
        try (OutputStream fileOutputStream = new FileOutputStream(file)) {
            byte[] result = data.getBytes();
            fileOutputStream.write(result);
        } catch (Exception e) {
            System.out.println("problems");
        }
    }
}
