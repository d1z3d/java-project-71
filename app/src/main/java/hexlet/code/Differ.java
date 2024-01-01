package hexlet.code;

import java.util.Map;


public class Differ {
    public static String generate(String path1, String path2, String format) throws Exception {
        Map<String, Object> dataFromFirstFile = Parser.parse(path1);
        Map<String, Object> dataFromSecondFile = Parser.parse(path2);

        return Formatter.format(dataFromFirstFile, dataFromSecondFile, format);
    }
}
