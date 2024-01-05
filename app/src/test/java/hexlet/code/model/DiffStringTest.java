package hexlet.code.model;

/*import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;*/

public class DiffStringTest {
/*    private List<DiffString> list = new ArrayList<>();
    private DiffString diffString1;
    private DiffString diffString2;
    private DiffString diffString3;
    private DiffString diffString4;

    @BeforeEach
    public void prepareData() {
        diffString1 = new DiffString(1, " ", "name", "Andrey");
        diffString2 = new DiffString(2, " ", "name", "Andrey");
        diffString3 = new DiffString(2, " ", "about", "Andrey");
        diffString4 = new DiffString(2, " ", "before", "Andrey");
        list.add(diffString1);
        list.add(diffString2);
        list.add(diffString3);
        list.add(diffString4);
    }

    @Test
    public void compareToTest() {
        int actual1 = diffString1.compareTo(diffString2);
        assertEquals(-1, actual1);

        int actual2 = diffString3.compareTo(diffString4);
        assertEquals(-1, actual2);

        int actual3 = diffString4.compareTo(diffString3);
        assertEquals(1, actual3);
    }

    @Test
    public void toStringTest() {
        String actual = diffString1.toString();
        String expected = "DiffString{idFile=1, operation=' ', key='name', value=Andrey}";
        assertEquals(expected, actual);
    }

    *//*@Test
    public void listToString() {
        String actual = DiffString.listToString(list);
        String expected = "{\n\t  name: Andrey\n\t  name: Andrey\n\t  about: Andrey\n\t  before: Andrey\n}";
        assertEquals(actual, expected);
    }*//*

    @Test
    public void hashCodeTest() {
        int actual = Objects.hash(diffString1.getIdFile(),
                diffString1.getOperation(),
                diffString1.getKey(),
                diffString1.getValue());
        int expected1 = Objects.hash(1, " ", "name", "Andrey");
        assertEquals(expected1, actual);

        int expected2 = Objects.hash(1, " ", "name", "Andrey1");
        assertNotEquals(expected2, actual);
    }

    @Test
    public void settersTest() {
        diffString1.setIdFile(3);
        diffString1.setOperation("+");
        diffString1.setKey("hexlet");
        diffString1.setValue("isGood");
        assertEquals(new DiffString(3, "+", "hexlet", "isGood"), diffString1);
    }

    @Test
    public void emptyConstructorTest() {
        DiffString actual = new DiffString();
        assertEquals(new DiffString(), actual);
    }*/
}
