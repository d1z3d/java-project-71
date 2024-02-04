package hexlet.code;

import java.util.List;
import java.util.Map;

public class Differ {
    public static String generate(String path1, String path2, String format) throws Exception {
        String dataFromFirstFile = Utils.getDataFromFile(path1);
        String dataFromSecondFile = Utils.getDataFromFile(path2);
        Map<String, Object> mapData1 = Parser.parse(dataFromFirstFile, Utils.getExtensionByString(path1));
        Map<String, Object> mapData2 = Parser.parse(dataFromSecondFile, Utils.getExtensionByString(path2));
        List<Map<String, Object>> comparedData = DiffBuilder.compareData(mapData1, mapData2);
        return Formatter.format(comparedData, format);
    }

    public static String generate(String path1, String path2) throws Exception {
        return generate(path1, path2, "stylish");
    }
}
