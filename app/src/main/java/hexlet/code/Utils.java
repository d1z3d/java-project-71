package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

public class Utils {
    public static String getDataFromFile(String pathToFile) throws Exception {
        Path path = Paths.get(pathToFile).toAbsolutePath().normalize();
        return Files.readString(path);
    }

    public static String getExtensionByString(String path) {
        Optional<String> fileExtension = Optional.ofNullable(path)
                .filter(f -> f.contains("."))
                .map(f -> f.substring(path.lastIndexOf(".") + 1));

        return fileExtension.orElse(null);
    }

    public static Object replaceNullToString(Object value) {
        if (value == null) {
            return "null";
        }

        return value;
    }
}
