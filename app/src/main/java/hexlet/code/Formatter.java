package hexlet.code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.List;
import java.util.Map;

public class Formatter {
    public static String format(List<Map<String, Object>> comparedData,
                                String format) throws Exception {
        switch (format.toLowerCase()) {
            case "plain" -> {
                return Plain.fillAsPlain(comparedData);
            }
            case "json" -> {
                return Json.fillAsJson(comparedData);
            }
            case "stylish" -> {
                return Stylish.fillAsStylish(comparedData);
            }
            default -> throw new Exception("Unsupported format of out");
        }
    }
}
