package hexlet.code.formatters;

import java.util.List;
import java.util.Map;

public class Stylish {

    public static String fillAsStylish(List<Map<String, Object>> data) {
        StringBuilder stringBuilder = new StringBuilder("{\n");
        for (var node : data) {
            String operation = node.get("operation").toString();
            switch (operation) {
                case "added" -> stringBuilder.append(String.format("  %s %s: %s\n",
                        "+",
                        node.get("key"),
                        node.get("value")));
                case "equals" -> stringBuilder.append(String.format("  %s %s: %s\n",
                        " ",
                        node.get("key"),
                        node.get("value")));
                case "removed" -> stringBuilder.append(String.format("  %s %s: %s\n",
                        "-",
                        node.get("key"),
                        node.get("value")));
                case "updated" -> {
                    stringBuilder.append(String.format("  %s %s: %s\n",
                            "-",
                            node.get("key"),
                            node.get("valueOfFirstFile")));
                    stringBuilder.append(String.format("  %s %s: %s\n",
                            "+",
                            node.get("key"),
                            node.get("valueOfSecondFile")));
                }
                default -> {
                }
            }
        }
        return stringBuilder.append("}").toString();
    }
}
