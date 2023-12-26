package hexlet.code.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiffString implements Comparable<DiffString> {
    private int idFile;
    private String operation;
    private String key;
    private Object value;

    @Override
    public int compareTo(DiffString diff) {
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
        return "DiffString{"
                + "idFile=" + idFile
                + ", operation='" + operation + '\''
                + ", key='" + key + '\''
                + ", value=" + value
                + '}';
    }

    public static String listToString(List<DiffString> diffStrings) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{\n");
        for (DiffString differ : diffStrings) {
            stringBuilder.append(String.format("\t%s %s: %s\n",
                    differ.getOperation(),
                    differ.getKey(),
                    differ.getValue()));
        }
        stringBuilder.append("}");

        return stringBuilder.toString();
    }
}
