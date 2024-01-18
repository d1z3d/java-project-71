package hexlet.code.formatters;

import org.apache.commons.collections4.map.LinkedMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Plain {
    public static String fillAsPlain(List<Map<String, Object>> data) {
        StringBuilder stringBuilder = new StringBuilder();

        for (var node : data) {
            Object value1 = node.get("valueOfFirstFile");
            Object value2 = node.get("valueOfSecondFile");

            if (value1 != null) {
                if (value1 instanceof ArrayList || value1 instanceof HashMap || value1 instanceof LinkedMap) {
                    value1 = "[complex value]";
                } else if (value1 instanceof String) {
                    value1 = String.format("'%s'", value1);
                }
            }

            if (value2 != null) {
                if (value2 instanceof ArrayList || value2 instanceof HashMap || value2 instanceof LinkedMap) {
                    value2 = "[complex value]";
                } else if (value2 instanceof String) {
                    value2 = String.format("'%s'", value2);
                }
            }


            Object operation = node.get("operation");
            if (operation.equals("added")) {
                stringBuilder.append(String.format("Property '%s' was %s with value: %s\n",
                        node.get("key"),
                        operation,
                        value2));
            } else if (operation.equals("removed")) {
                stringBuilder.append(String.format("Property '%s' was %s\n",
                        node.get("key"),
                        operation));
            } else if (operation.equals("updated")) {
                stringBuilder.append(String.format("Property '%s' was %s. From %s to %s\n",
                        node.get("key"),
                        operation,
                        value1,
                        value2));
            }
        }

        return stringBuilder.substring(0, stringBuilder.length() - 1);
    }
}
