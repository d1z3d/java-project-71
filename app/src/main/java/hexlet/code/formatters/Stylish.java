package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Stylish {
    public static String fillAsStylish(List<Map<String, Object>> data) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{\n");
        for (var node : data) {
            Object operation = node.get("operation");
            if (operation.equals("added")) {
                stringBuilder.append(String.format("  %s %s: %s\n",
                        "+",
                        node.get("key"),
                        node.get("value")));
            } else if (operation.equals("equals")) {
                stringBuilder.append(String.format("  %s %s: %s\n",
                        " ",
                        node.get("key"),
                        node.get("value")));
            } else if (operation.equals("removed")) {
                stringBuilder.append(String.format("  %s %s: %s\n",
                        "-",
                        node.get("key"),
                        node.get("value")));
            } else if (operation.equals("updated")) {
                stringBuilder.append(String.format("  %s %s: %s\n",
                        "-",
                        node.get("key"),
                        node.get("valueOfFirstFile")));
                stringBuilder.append(String.format("  %s %s: %s\n",
                        "+",
                        node.get("key"),
                        node.get("valueOfSecondFile")));
            }
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
