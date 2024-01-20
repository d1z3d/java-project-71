package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {

    @Test
    public void testGenerateStylishByJson() throws Exception {
        String path1 = TestUtils.getFixturePathAsString("file1TestIn.json");
        String path2 = TestUtils.getFixturePathAsString("file2TestIn.json");

        String expected = Utils.getDataFromFile(TestUtils.getFixturePathAsString("stylishExpected.txt"));

        String actual = Differ.generate(path1, path2);
        assertEquals(expected, actual);

        TestUtils.createTestOutputFile("testGenerateStylishByJson.txt", actual);
    }

    @Test
    public void testGeneratePlainByJson() throws Exception {
        String path1 = TestUtils.getFixturePathAsString("file1TestIn.json");
        String path2 = TestUtils.getFixturePathAsString("file2TestIn.json");

        String expected = Utils.getDataFromFile(TestUtils.getFixturePathAsString("plainExpected.txt"));

        String actual = Differ.generate(path1, path2, "plain");
        assertEquals(expected, actual);

        TestUtils.createTestOutputFile("testGeneratePlainByJson.txt", actual);
    }
    @Test
    public void testGenerateJsonByJson() throws Exception {
        String path1 = TestUtils.getFixturePathAsString("file1TestIn.json");
        String path2 = TestUtils.getFixturePathAsString("file2TestIn.json");

        String expected = Utils.getDataFromFile(TestUtils.getFixturePathAsString("jsonExpected.txt"));

        String actual = Differ.generate(path1, path2, "json");
        assertEquals(expected, actual);

        TestUtils.createTestOutputFile("testGenerateJsonByJson.json", actual);
    }


    @Test
    public void testGenerateStylishByYml() throws Exception {
        String path1 = TestUtils.getFixturePathAsString("file1TestIn.yml");
        String path2 = TestUtils.getFixturePathAsString("file2TestIn.yml");

        String expected = Utils.getDataFromFile(TestUtils.getFixturePathAsString("stylishExpected.txt"));

        String actual = Differ.generate(path1, path2);
        assertEquals(expected, actual);

        TestUtils.createTestOutputFile("testGenerateStylishByYml.txt", actual);
    }

    @Test
    public void testGeneratePlainByYml() throws Exception {
        String path1 = TestUtils.getFixturePathAsString("file1TestIn.yml");
        String path2 = TestUtils.getFixturePathAsString("file2TestIn.yml");

        String expected = Utils.getDataFromFile(TestUtils.getFixturePathAsString("plainExpected.txt"));

        String actual = Differ.generate(path1, path2, "plain");
        assertEquals(expected, actual);

        TestUtils.createTestOutputFile("testGeneratePlainByYml.txt", actual);
    }

    @Test
    public void testGenerateJsonByYml() throws Exception {
        String path1 = TestUtils.getFixturePathAsString("file1TestIn.yml");
        String path2 = TestUtils.getFixturePathAsString("file2TestIn.yml");

        String expected = Utils.getDataFromFile(TestUtils.getFixturePathAsString("jsonExpected.txt"));

        String actual = Differ.generate(path1, path2, "json");
        assertEquals(expected, actual);

        TestUtils.createTestOutputFile("testGenerateJsonByYml.json", actual);
    }
}
