package hexlet.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Util {
    public static List<Map<String, Object>> compareData(Map<String, Object> firstMap, Map<String, Object> secondMap) {
        List<Map<String, Object>> result = new ArrayList<>();

        for (String key : getKeysFromMaps(firstMap, secondMap)) {
            Map<String, Object> node = new HashMap<>();
            if (firstMap.containsKey(key) && secondMap.containsKey(key)) {
                if (firstMap.get(key) == null || secondMap.get(key) == null) {
                    if (firstMap.get(key) != secondMap.get(key)) {
                        node.put("key", key);
                        node.put("operation", "updated");
                        node.put("hasInBothFiles", true);
                        node.put("valueOfFirstFile", firstMap.get(key));
                        node.put("valueOfSecondFile", secondMap.get(key));
                    } else {
                        node.put("key", key);
                        node.put("operation", "equals");
                        node.put("hasInBothFiles", true);
                        node.put("valueOfFirstFile", firstMap.get(key));
                        node.put("valueOfSecondFile", secondMap.get(key));
                    }
                } else if (!firstMap.get(key).equals(secondMap.get(key))) {
                    node.put("key", key);
                    node.put("operation", "updated");
                    node.put("hasInBothFiles", true);
                    node.put("valueOfFirstFile", firstMap.get(key));
                    node.put("valueOfSecondFile", secondMap.get(key));
                } else {
                    node.put("key", key);
                    node.put("operation", "equals");
                    node.put("hasInBothFiles", true);
                    node.put("valueOfFirstFile", firstMap.get(key));
                    node.put("valueOfSecondFile", secondMap.get(key));
                }
            } else if (firstMap.containsKey(key)) {
                node.put("key", key);
                node.put("operation", "removed");
                node.put("hasInBothFiles", false);
                node.put("valueOfFirstFile", firstMap.get(key));
                node.put("valueOfSecondFile", null);
            } else {
                node.put("key", key);
                node.put("operation", "added");
                node.put("hasInBothFiles", false);
                node.put("valueOfFirstFile", null);
                node.put("valueOfSecondFile", secondMap.get(key));
            }
            result.add(node);
        }
        return result;
    }

    private static List<String> getKeysFromMaps(Map<String, Object> firstMap, Map<String, Object> secondMap) {
        List<String> keys = new ArrayList<>(firstMap.keySet());
        for (String keySecondMap: secondMap.keySet()) {
            if (!firstMap.containsKey(keySecondMap)) {
                keys.add(keySecondMap);
            }
        }
        Collections.sort(keys);
        return keys;
    }

}
