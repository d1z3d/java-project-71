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
            Map<String, Object> node;
            if (firstMap.containsKey(key) && secondMap.containsKey(key)) {
                if (firstMap.get(key) == null || secondMap.get(key) == null) {
                    if (firstMap.get(key) != secondMap.get(key)) {
                        node = createNode(key, "updated", true, firstMap.get(key), secondMap.get(key));
                    } else {
                        node = createNode(key, "equals", true, firstMap.get(key), secondMap.get(key));
                    }
                } else if (!firstMap.get(key).equals(secondMap.get(key))) {
                    node = createNode(key, "updated", true, firstMap.get(key), secondMap.get(key));
                } else {
                    node = createNode(key, "equals", true, firstMap.get(key), secondMap.get(key));
                }
            } else if (firstMap.containsKey(key)) {
                node = createNode(key, "removed", false, firstMap.get(key), null);
            } else {
                node = createNode(key, "added", false, null, secondMap.get(key));
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

    private static Map<String, Object> createNode(String key,
                                                  String operation,
                                                  boolean hasInBothFiles,
                                                  Object valueOfFirstFile,
                                                  Object valueOfSecondFile) {
        Map<String, Object> node = new HashMap<>();
        node.put("key", key);
        node.put("operation", operation);
        node.put("hasInBothFiles", hasInBothFiles);
        node.put("valueOfFirstFile", valueOfFirstFile);
        node.put("valueOfSecondFile", valueOfSecondFile);
        return node;
    }

}
