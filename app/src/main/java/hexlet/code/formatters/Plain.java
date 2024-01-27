package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Plain {
    private static StringBuilder stringBuilder;

    public static String fillAsPlain(List<Map<String, Object>> data) {
        stringBuilder = new StringBuilder();
        for (var node : data) {
            Object value1 = node.getOrDefault("valueOfFirstFile", node.get("value"));
            Object value2 = node.getOrDefault("valueOfSecondFile", node.get("value"));

            value1 = replaceArrayToComplexString(value1);
            value2 = replaceArrayToComplexString(value2);

            String operation = node.get("operation").toString();

            appendElement(operation, node.get("key"), value1, value2);
        }
        return stringBuilder.substring(0, stringBuilder.length() - 1);
    }

    private static Object replaceArrayToComplexString(Object value) {
        if (value != null) {
            if (value instanceof List<?> || value instanceof Map<?, ?>) {
                return "[complex value]";
            } else if (value instanceof String) {
                return String.format("'%s'", value);
            }
        }
        return value;
    }

    private static void appendElement(String operation, Object key, Object firstElement, Object secondElement) {
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
