package hexlet.code;

import hexlet.code.model.DiffString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;


public class Differ {
    public static String generate(String path1, String path2) throws Exception {
        String dataFromFirstFile = Util.parse(path1);
        String dataFromSecondFile = Util.parse(path2);
        Map<String, Object> map1 = Util.getData(dataFromFirstFile);
        Map<String, Object> map2 = Util.getData(dataFromSecondFile);

        List<DiffString> diffStrings = new ArrayList<>();

        fillResult(map1, map2, diffStrings);

        for (String key : map2.keySet()) {
            diffStrings.add(new DiffString(2, "+", key, map2.get(key)));
        }
        Collections.sort(diffStrings);

        return DiffString.listToString(diffStrings);
    }

    private static void fillResult(Map<String, Object> map1, Map<String, Object> map2, List<DiffString> result) {
        String key1;
        String key2;
        Object value1;
        Object value2;
        for (String s : map1.keySet()) {
            key1 = s;
            value1 = map1.get(key1);

            key2 = map2.containsKey(key1) ? key1 : null;
            value2 = map2.getOrDefault(key2, null);
            if (key2 == null) {
                result.add(new DiffString(1, "-", key1, value1));
            } else {
                if (value1.equals(value2)) {
                    result.add(new DiffString(1, " ", key1, value1));
                    map2.remove(key2);
                } else {
                    result.add(new DiffString(1, "-", key1, value1));
                    result.add(new DiffString(2, "+", key2, value2));
                    map2.remove(key2);
                }
            }
        }
    }
}
