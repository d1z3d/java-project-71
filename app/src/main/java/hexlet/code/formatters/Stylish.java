package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Stylish {

    public static String fillAsStylish(List<Map<String, Object>> data) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{\n");
        for (var node : data) {
            String operation = node.get("operation").toString();

            switch (operation) {
                case "added" -> appendElement(stringBuilder, "+", node.get("key"), node.get("value"));
                case "equals" -> appendElement(stringBuilder, " ", node.get("key"), node.get("value"));
                case "removed" -> appendElement(stringBuilder, "-", node.get("key"), node.get("value"));
                case "updated" -> {
                    appendElement(stringBuilder, "-", node.get("key"), node.get("valueOfFirstFile"));
                    appendElement(stringBuilder, "+", node.get("key"), node.get("valueOfSecondFile"));
                }
                default -> {
                    break;
                }
            }
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    private static void appendElement(StringBuilder stringBuilder, String operation, Object key, Object value) {
        stringBuilder.append(String.format("  %s %s: %s\n",
                operation,
                key,
                value));
    }
}
