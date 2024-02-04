package hexlet.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class DiffBuilder {
    public static List<Map<String, Object>> compareData(Map<String, Object> firstMap, Map<String, Object> secondMap) {
        Set<String> keys = new TreeSet<>(firstMap.keySet());
        keys.addAll(secondMap.keySet());

        List<Map<String, Object>> result = new ArrayList<>();
        for (String key : keys) {
            Map<String, Object> node;
            Object value1 = firstMap.get(key);
            Object value2 = secondMap.get(key);
            if (!firstMap.containsKey(key)) {
                node = createNode(key, "added", secondMap.get(key), null);
            } else if (!secondMap.containsKey(key)) {
                node = createNode(key, "removed", firstMap.get(key), null);
            } else if (Objects.equals(value1, value2)) {
                node = createNode(key, "equals", firstMap.get(key), secondMap.get(key));
            } else {
                node = createNode(key, "updated", firstMap.get(key), secondMap.get(key));
            }
            result.add(node);
        }
        return result;
    }


    private static Map<String, Object> createNode(String key,
                                                  String operation,
                                                  Object value1,
                                                  Object value2) {
        Map<String, Object> node = new HashMap<>();
        node.put("key", key);
        node.put("operation", operation);
        if (operation.equals("updated")) {
            node.put("valueOfFirstFile", value1);
            node.put("valueOfSecondFile", value2);
        } else {
            node.put("value", value1);
        }
        return node;
    }

}
