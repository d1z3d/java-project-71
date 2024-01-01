package hexlet.code.formatters;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class Stylish implements Comparable<Stylish> {
    private int idFile;
    private String operation;
    private String key;
    private Object value;

    @Override
    public int compareTo(Stylish diff) {
        if (this.key.compareTo(diff.getKey()) > 0) {
            return 1;
        } else if (this.key.compareTo(diff.getKey()) < 0) {
            return -1;
        } else {
            return Integer.compare(this.idFile, diff.getIdFile());
        }
    }

    @Override
    public String toString() {
        return "Stylish{"
                + "idFile=" + idFile
                + ", operation='" + operation + '\''
                + ", key='" + key + '\''
                + ", value=" + value
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
        Stylish that = (Stylish) o;
        return idFile == that.idFile && Objects.equals(operation, that.operation)
                && Objects.equals(key, that.key)
                && Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFile, operation, key, value);
    }
    public static String fill(Map<String, Object> map1, Map<String, Object> map2) {
        List<Stylish> result = new ArrayList<>();
        for (String key: map1.keySet()) {
            if (!map2.containsKey(key)) {
                result.add(new Stylish(1, "-", key, map1.get(key)));
            } else if (map1.get(key) == null || map2.get(key) == null) {
                if (map1.get(key) == map2.get(key)) {
                    result.add(new Stylish(1, " ", key, map1.get(key)));
                } else {
                    result.add(new Stylish(1, "-", key, map1.get(key)));
                    result.add(new Stylish(2, "+", key, map2.get(key)));
                    map2.remove(key);
                }
            } else {
                if (map1.get(key).equals(map2.get(key))) {
                    result.add(new Stylish(1, " ", key, map1.get(key)));
                    map2.remove(key);
                } else {
                    result.add(new Stylish(1, "-", key, map1.get(key)));
                    result.add(new Stylish(2, "+", key, map2.get(key)));
                    map2.remove(key);
                }
            }
        }

        for (String key : map2.keySet()) {
            result.add(new Stylish(2, "+", key, map2.get(key)));
        }

        Collections.sort(result);
        return listToString(result);
    }

    private static String listToString(List<Stylish> diffStrings) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{\n");
        for (Stylish differ : diffStrings) {
            stringBuilder.append(String.format("\t%s %s: %s\n",
                    differ.getOperation(),
                    differ.getKey(),
                    differ.getValue()));
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
