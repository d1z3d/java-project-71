package hexlet.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class DiffBuilder {
    public static List<Map<String, Object>> compareData(Map<String, Object> data1, Map<String, Object> data2) {
        Set<String> keys = new TreeSet<>(data1.keySet());
        keys.addAll(data2.keySet());

        List<Map<String, Object>> result = new ArrayList<>();
        for (String key : keys) {
            Map<String, Object> node;
            Object value1 = data1.get(key);
            Object value2 = data2.get(key);
            if (!data1.containsKey(key)) {
                node = createNode(key, "added", data2.get(key), null);
            } else if (!data2.containsKey(key)) {
                node = createNode(key, "removed", data1.get(key), null);
            } else if (Objects.equals(value1, value2)) {
                node = createNode(key, "equals", data1.get(key), data2.get(key));
            } else {
                node = createNode(key, "updated", data1.get(key), data2.get(key));
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
