package hexlet.code.formatters;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
public class Plain implements Comparable<Plain> {
    private String operation;
    private String key;
    private Object valueOfFirstFile;
    private Object valueOfSecondFile;

    public Plain(String operation, String key, Object valueOfFirstFile, Object valueOfSecondFile) {
        this.operation = operation;
        this.key = key;
        this.valueOfFirstFile = valueOfFirstFile;
        this.valueOfSecondFile = valueOfSecondFile;
    }

    @Override
    public int compareTo(Plain diff) {
        return this.getKey().compareTo(diff.getKey());
    }

    @Override
    public String toString() {
        return "Plain{"
                + "operation='" + operation + '\''
                + ", key='" + key + '\''
                + ", valueOfFirstFile=" + valueOfFirstFile
                + ", valueOfSecondFile=" + valueOfSecondFile
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Plain plain = (Plain) o;
        return Objects.equals(operation, plain.operation)
                && Objects.equals(key, plain.key)
                && Objects.equals(valueOfFirstFile, plain.valueOfFirstFile)
                && Objects.equals(valueOfSecondFile, plain.valueOfSecondFile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operation, key, valueOfFirstFile, valueOfSecondFile);
    }

    public static String fill(Map<String, Object> map1, Map<String, Object> map2) {
        List<Plain> result = new ArrayList<>();

        for (String key : map1.keySet()) {
            if (!map2.containsKey(key)) {
                result.add(new Plain("removed", key, map1.get(key), ""));
            } else if (map1.get(key) == null || map2.get(key) == null) {
                if (map1.get(key) != map2.get(key)) {
                    result.add(new Plain("updated", key, map1.get(key), map2.get(key)));
                    map2.remove(key);
                } else {
                    map2.remove(key);
                }
            } else {
                if (!map1.get(key).equals(map2.get(key))) {
                    result.add(new Plain("updated", key, map1.get(key), map2.get(key)));
                    map2.remove(key);
                } else {
                    map2.remove(key);
                }
            }
        }

        for (String key : map2.keySet()) {
            result.add(new Plain("added", key, "", map2.get(key)));
        }

        Collections.sort(result);
        return listToString(result);
    }

    private static String listToString(List<Plain> diffStrings) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Plain differ : diffStrings) {
            Object value1 = differ.getValueOfFirstFile();
            Object value2 = differ.getValueOfSecondFile();


            if (value1 != null) {
                if (value1.getClass().toString().startsWith("class java.util.")) {
                    value1 = "[complex value]";
                } else if (value1.getClass().toString().equals("class java.lang.String")) {
                    value1 = String.format("'%s'", value1);
                }
            }

            if (value2 != null) {
                if (value2.getClass().toString().startsWith("class java.util.")) {
                    value2 = "[complex value]";
                } else if (value2.getClass().toString().equals("class java.lang.String")) {
                    value2 = String.format("'%s'", value2);
                }
            }


            switch (differ.getOperation()) {
                case "added" -> stringBuilder.append(String.format("Property '%s' was %s with value: %s\n",
                        differ.getKey(),
                        differ.getOperation(),
                        value2));
                case "removed" -> stringBuilder.append(String.format("Property '%s' was %s\n",
                        differ.getKey(),
                        differ.getOperation()));
                case "updated" -> stringBuilder.append(String.format("Property '%s' was %s. From %s to %s\n",
                        differ.getKey(),
                        differ.getOperation(),
                        value1,
                        value2));
                default -> {
                }
            }
        }
        return stringBuilder.toString();
    }
}
