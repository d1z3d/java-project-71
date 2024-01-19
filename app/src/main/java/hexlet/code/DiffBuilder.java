package hexlet.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class DiffBuilder {
    public static List<Map<String, Object>> compareData(Map<String, Object> firstMap, Map<String, Object> secondMap) {
        List<Map<String, Object>> result = new ArrayList<>();

        for (String key : getKeysFromMaps(firstMap, secondMap)) {
            Map<String, Object> node;
            Object value1 = Utils.replaceNullToString(firstMap.get(key));
            Object value2 = Utils.replaceNullToString(secondMap.get(key));
            if (!firstMap.containsKey(key)) {
                node = createNode(key, "added", false, secondMap.get(key));
            } else if (!secondMap.containsKey(key)) {
                node = createNode(key, "removed", false, firstMap.get(key));
            } else if (value1.equals(value2)) {
                node = createNode(key, "equals", true, firstMap.get(key));
            } else {
                node = createNode(key, firstMap.get(key), secondMap.get(key));
            }
            result.add(node);
        }

        return result;
    }

    private static Set<String> getKeysFromMaps(Map<String, Object> firstMap, Map<String, Object> secondMap) {
        Set<String> keys = new TreeSet<>();
        keys.addAll(firstMap.keySet());
        keys.addAll(secondMap.keySet());
        return keys;
    }

    private static Map<String, Object> createNode(String key,
                                                  Object value1,
                                                  Object value2) {
        Map<String, Object> node = new HashMap<>();
        node.put("key", key);
        node.put("operation", "updated");
        node.put("hasInBothFiles", "true");
        node.put("valueOfFirstFile", value1);
        node.put("valueOfSecondFile", value2);
        return node;
    }

    private static Map<String, Object> createNode(String key,
                                                  String operation,
                                                  boolean hasInBothFiles,
                                                  Object value) {
        Map<String, Object> node = new HashMap<>();
        node.put("key", key);
        node.put("operation", operation);
        node.put("hasInBothFiles", hasInBothFiles);
        node.put("value", value);
        return node;
    }
}
