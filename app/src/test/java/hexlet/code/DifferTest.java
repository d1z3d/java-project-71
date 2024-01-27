package hexlet.code;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {

    private static String pathJson1 = TestUtils.getFixturePathAsString("file1TestIn.json");
    private static String pathJson2 = TestUtils.getFixturePathAsString("file2TestIn.json");
    private static String pathYaml1 = TestUtils.getFixturePathAsString("file1TestIn.yml");;
    private static String pathYaml2 = TestUtils.getFixturePathAsString("file2TestIn.json");
    private static String expectedStylish;
    private static String expectedPlain;

    private static String expectedJson;

    static {
        try {
            expectedStylish = Utils.getDataFromFile(TestUtils.getFixturePathAsString("stylishExpected.txt"));
            expectedPlain = Utils.getDataFromFile(TestUtils.getFixturePathAsString("plainExpected.txt"));
            expectedJson = Utils.getDataFromFile(TestUtils.getFixturePathAsString("jsonExpected.txt"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @ParameterizedTest(name = "{index} - {0}")
    @MethodSource("jsonDataProvider")
    public void testJsonDiffer(String format, String path1, String path2, String expected) throws Exception {
        String actual = Differ.generate(path1, path2, format);
        assertEquals(expected, actual);
    }
    @ParameterizedTest(name = "{index} - {0}")
    @MethodSource("ymlDataProvider")
    public void testYmlDiffer(String format, String path1, String path2, String expected) throws Exception {
        String actual = Differ.generate(path1, path2, format);
        assertEquals(expected, actual);
    }


    private static Object[][] jsonDataProvider() {
        return new Object[][]{
                {"stylish", pathJson1, pathJson2, expectedStylish},
                {"plain", pathJson1, pathJson2, expectedPlain},
                {"json", pathJson1, pathJson2, expectedJson},
        };
    }
    private static Object[][] ymlDataProvider() {
        return new Object[][]{
                {"stylish", pathYaml1, pathYaml2, expectedStylish},
                {"plain", pathYaml1, pathYaml2, expectedPlain},
                {"json", pathYaml1, pathYaml2, expectedJson}
        };
    }
}
