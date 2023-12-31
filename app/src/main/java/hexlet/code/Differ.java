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
        for (String key : map1.keySet()) {
            if (!map2.containsKey(key)) {
                result.add(new DiffString(1, "-", key, map1.get(key)));
            } else {
                if (map1.get(key).equals(map2.get(key))) {
                    result.add(new DiffString(1, " ", key, map1.get(key)));
                    map2.remove(key);
                } else {
                    result.add(new DiffString(1, "-", key, map1.get(key)));
                    result.add(new DiffString(2, "+", key, map2.get(key)));
                    map2.remove(key);
                }
            }
        }
    }
}
