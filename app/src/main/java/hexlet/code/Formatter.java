package hexlet.code;

import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.Map;

public class Formatter {
    public static String format(Map<String, Object> dataFromFirstFile,
                                Map<String, Object> dataFromSecondFile,
                                String format) {
        if (format.equals("plain")) {
            return Plain.fill(dataFromFirstFile, dataFromSecondFile);
        }
        return Stylish.fill(dataFromFirstFile, dataFromSecondFile);
    }
}
