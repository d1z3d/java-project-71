package hexlet.code;

import java.util.List;
import java.util.Map;


public class Differ {
    public static String generate(String path1, String path2, String format) throws Exception {
        Map<String, Object> dataFromFirstFile = Parser.parse(path1);
        Map<String, Object> dataFromSecondFile = Parser.parse(path2);
        List<Map<String, Object>> comparedData = Util.compareData(dataFromFirstFile, dataFromSecondFile);
        return Formatter.format(comparedData, format);
    }

    public static String generate(String path1, String path2) throws Exception {
        return generate(path1, path2, "stylish");
    }
}
