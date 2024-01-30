package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Plain {

    public static String fillAsPlain(List<Map<String, Object>> data) {
        StringBuilder stringBuilder = new StringBuilder();
        for (var node : data) {
            Object value1 = node.getOrDefault("valueOfFirstFile", node.get("value"));
            Object value2 = node.getOrDefault("valueOfSecondFile", node.get("value"));

            value1 = stringify(value1);
            value2 = stringify(value2);

            String operation = node.get("operation").toString();

            appendElement(stringBuilder, operation, node.get("key"), value1, value2);
        }
        return stringBuilder.substring(0, stringBuilder.length() - 1);
    }

    private static String stringify(Object value) {
        if (value == null) {
            return "null";
        }
        if (value instanceof String) {
            return "'" + value + "'";
        }
        if (value instanceof Map || value instanceof List) {
            return "[complex value]";
        }
        return value.toString();
    }

    private static void appendElement(StringBuilder stringBuilder,
                                      String operation,
                                      Object key,
                                      Object firstElement,
                                      Object secondElement) {
        switch (operation) {
            case "added" -> stringBuilder.append(String.format("Property '%s' was %s with value: %s\n",
                    key,
                    operation,
                    secondElement));
            case "removed" -> stringBuilder.append(String.format("Property '%s' was %s\n",
                    key,
                    operation));
            case "updated" -> stringBuilder.append(String.format("Property '%s' was %s. From %s to %s\n",
                    key,
                    operation,
                    firstElement,
                    secondElement));
            default -> {
                break;
            }
        }
    }
}
