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
                diffStrings.add(new DiffString(1, "-", key1, value1));
            } else {
                if (value1.equals(value2)) {
                    diffStrings.add(new DiffString(1, " ", key1, value1));
                    map2.remove(key2);
                } else {
                    diffStrings.add(new DiffString(1, "-", key1, value1));
                    diffStrings.add(new DiffString(2, "+", key2, value2));
                    map2.remove(key2);
                }
            }
        }

        for (String key : map2.keySet()) {
            key2 = key;
            value2 = map2.get(key2);

            diffStrings.add(new DiffString(2, "+", key2, value2));
        }
        Collections.sort(diffStrings);

        return DiffString.listToString(diffStrings);
    }
}
