package hexlet.code;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public final class DifferTest {

    @ParameterizedTest
    @ValueSource(strings = { "json", "yml" })
    public void generateTest(String expansion) throws Exception {
        String filePath1 = TestUtils.getFixturePath("file1." + expansion);
        String filePath2 = TestUtils.getFixturePath("file2." + expansion);

        String actualStylish1 = Differ.generate(filePath1, filePath2);
        String expectedStylish = Utils.getDataFromFile(TestUtils.getFixturePath("stylishExpected.txt"));
        assertEquals(expectedStylish, actualStylish1);

        String actualStylish2 = Differ.generate(filePath1, filePath2, "stylish");
        assertEquals(expectedStylish, actualStylish2);

        String actualPlain = Differ.generate(filePath1, filePath2, "plain");
        String expectedPlain = Utils.getDataFromFile(TestUtils.getFixturePath("plainExpected.txt"));
        assertEquals(expectedPlain, actualPlain);

        String actualJson = Differ.generate(filePath1, filePath2, "json");
        String expectedJson = Utils.getDataFromFile(TestUtils.getFixturePath("jsonExpected.txt"));
        assertEquals(expectedJson, actualJson);
    }
}
