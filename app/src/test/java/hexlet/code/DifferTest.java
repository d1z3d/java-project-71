package hexlet.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {

    @Test
    public void testGenerateStylishByJson() throws Exception {
        String path1 = TestUtils.getFixturePathAsString("file1TestIn.json");
        String path2 = TestUtils.getFixturePathAsString("file2TestIn.json");

        String expected = "{\n"
                + "    chars1: [a, b, c]\n"
                + "  - chars2: [d, e, f]\n"
                + "  + chars2: false\n"
                + "  - checked: false\n"
                + "  + checked: true\n"
                + "  - default: null\n"
                + "  + default: [value1, value2]\n"
                + "  - id: 45\n"
                + "  + id: null\n"
                + "  - key1: value1\n"
                + "  + key2: value2\n"
                + "    numbers1: [1, 2, 3, 4]\n"
                + "  - numbers2: [2, 3, 4, 5]\n"
                + "  + numbers2: [22, 33, 44, 55]\n"
                + "  - numbers3: [3, 4, 5]\n"
                + "  + numbers4: [4, 5, 6]\n"
                + "  + obj1: {nestedKey=value, isNested=true}\n"
                + "  - setting1: Some value\n"
                + "  + setting1: Another value\n"
                + "  - setting2: 200\n"
                + "  + setting2: 300\n"
                + "  - setting3: true\n"
                + "  + setting3: none\n"
                + "}";

        String actual = Differ.generate(path1, path2);
        assertEquals(expected, actual);

        TestUtils.createTestOutputFile("testGenerateStylishByJson.txt", actual);
    }

    @Test
    public void testGeneratePlainByJson() throws Exception {
        String path1 = TestUtils.getFixturePathAsString("file1TestIn.json");
        String path2 = TestUtils.getFixturePathAsString("file2TestIn.json");

        String expected = "Property 'chars2' was updated. From [complex value] to false\n"
                + "Property 'checked' was updated. From false to true\n"
                + "Property 'default' was updated. From null to [complex value]\n"
                + "Property 'id' was updated. From 45 to null\n"
                + "Property 'key1' was removed\n"
                + "Property 'key2' was added with value: 'value2'\n"
                + "Property 'numbers2' was updated. From [complex value] to [complex value]\n"
                + "Property 'numbers3' was removed\n"
                + "Property 'numbers4' was added with value: [complex value]\n"
                + "Property 'obj1' was added with value: [complex value]\n"
                + "Property 'setting1' was updated. From 'Some value' to 'Another value'\n"
                + "Property 'setting2' was updated. From 200 to 300\n"
                + "Property 'setting3' was updated. From true to 'none'";

        String actual = Differ.generate(path1, path2, "plain");
        assertEquals(expected, actual);

        TestUtils.createTestOutputFile("testGeneratePlainByJson.txt", actual);
    }
    @Test
    public void testGenerateJsonByJson() throws Exception {
        String path1 = TestUtils.getFixturePathAsString("file1TestIn.json");
        String path2 = TestUtils.getFixturePathAsString("file2TestIn.json");

        String expected = "{\"differ\":[{\"hasInBothFiles\":true,\"operation\":"
                + "\"equals\",\"value\":[\"a\",\"b\",\"c\"],\"key\":\"chars1\"},"
                + "{\"hasInBothFiles\":\"true\",\"valueOfSecondFile\":false,\"valueOfFirstFile\":"
                + "[\"d\",\"e\",\"f\"],\"operation\":\"updated\",\"key\":\"chars2\"},"
                + "{\"hasInBothFiles\":\"true\",\"valueOfSecondFile\":true,\"valueOfFirstFile\":"
                + "false,\"operation\":\"updated\",\"key\":\"checked\"},{\"hasInBothFiles\":\"true\","
                + "\"valueOfSecondFile\":[\"value1\",\"value2\"],\"valueOfFirstFile\":null,"
                + "\"operation\":\"updated\",\"key\":\"default\"},{\"hasInBothFiles\":\"true\","
                + "\"valueOfSecondFile\":null,\"valueOfFirstFile\":45,\"operation\":\"updated\","
                + "\"key\":\"id\"},{\"hasInBothFiles\":false,\"operation\":\"removed\",\"value\":"
                + "\"value1\",\"key\":\"key1\"},{\"hasInBothFiles\":false,\"operation\":\"added\","
                + "\"value\":\"value2\",\"key\":\"key2\"},{\"hasInBothFiles\":true,\"operation\":"
                + "\"equals\",\"value\":[1,2,3,4],\"key\":\"numbers1\"},{\"hasInBothFiles\":\"true\","
                + "\"valueOfSecondFile\":[22,33,44,55],\"valueOfFirstFile\":[2,3,4,5],\"operation\":"
                + "\"updated\",\"key\":\"numbers2\"},{\"hasInBothFiles\":false,\"operation\":\"removed\","
                + "\"value\":[3,4,5],\"key\":\"numbers3\"},{\"hasInBothFiles\":false,\"operation\":\"added\","
                + "\"value\":[4,5,6],\"key\":\"numbers4\"},{\"hasInBothFiles\":false,\"operation\":\"added\","
                + "\"value\":{\"nestedKey\":\"value\",\"isNested\":true},\"key\":\"obj1\"},{\"hasInBothFiles\":"
                + "\"true\",\"valueOfSecondFile\":\"Another value\",\"valueOfFirstFile\":\"Some value\","
                + "\"operation\":\"updated\",\"key\":\"setting1\"},{\"hasInBothFiles\":\"true\","
                + "\"valueOfSecondFile\":300,\"valueOfFirstFile\":200,\"operation\":\"updated\","
                + "\"key\":\"setting2\"},{\"hasInBothFiles\":\"true\",\"valueOfSecondFile\":\"none\","
                + "\"valueOfFirstFile\":true,\"operation\":\"updated\",\"key\":\"setting3\"}]}";

        String actual = Differ.generate(path1, path2, "json");
        assertEquals(expected, actual);

        TestUtils.createTestOutputFile("testGenerateJsonByJson.json", actual);
    }


    @Test
    public void testGenerateStylishByYml() throws Exception {
        String path1 = TestUtils.getFixturePathAsString("file1TestIn.yml");
        String path2 = TestUtils.getFixturePathAsString("file2TestIn.yml");

        String expected = "{\n"
                + "    chars1: [a, b, c]\n"
                + "  - chars2: [d, e, f]\n"
                + "  + chars2: false\n"
                + "  - checked: false\n"
                + "  + checked: true\n"
                + "  - default: null\n"
                + "  + default: [value1, value2]\n"
                + "  - id: 45\n"
                + "  + id: null\n"
                + "  - key1: value1\n"
                + "  + key2: value2\n"
                + "    numbers1: [1, 2, 3, 4]\n"
                + "  - numbers2: [2, 3, 4, 5]\n"
                + "  + numbers2: [22, 33, 44, 55]\n"
                + "  - numbers3: [3, 4, 5]\n"
                + "  + numbers4: [4, 5, 6]\n"
                + "  + obj1: {nestedKey=value, isNested=true}\n"
                + "  - setting1: Some value\n"
                + "  + setting1: Another value\n"
                + "  - setting2: 200\n"
                + "  + setting2: 300\n"
                + "  - setting3: true\n"
                + "  + setting3: none\n"
                + "}";

        String actual = Differ.generate(path1, path2);
        assertEquals(expected, actual);

        TestUtils.createTestOutputFile("testGenerateStylishByYml.txt", actual);
    }

    @Test
    public void testGeneratePlainByYml() throws Exception {
        String path1 = TestUtils.getFixturePathAsString("file1TestIn.yml");
        String path2 = TestUtils.getFixturePathAsString("file2TestIn.yml");

        String expected = "Property 'chars2' was updated. From [complex value] to false\n"
                + "Property 'checked' was updated. From false to true\n"
                + "Property 'default' was updated. From null to [complex value]\n"
                + "Property 'id' was updated. From 45 to null\n"
                + "Property 'key1' was removed\n"
                + "Property 'key2' was added with value: 'value2'\n"
                + "Property 'numbers2' was updated. From [complex value] to [complex value]\n"
                + "Property 'numbers3' was removed\n"
                + "Property 'numbers4' was added with value: [complex value]\n"
                + "Property 'obj1' was added with value: [complex value]\n"
                + "Property 'setting1' was updated. From 'Some value' to 'Another value'\n"
                + "Property 'setting2' was updated. From 200 to 300\n"
                + "Property 'setting3' was updated. From true to 'none'";

        String actual = Differ.generate(path1, path2, "plain");
        assertEquals(expected, actual);

        TestUtils.createTestOutputFile("testGeneratePlainByYml.txt", actual);
    }

    @Test
    public void testGenerateJsonByYml() throws Exception {
        String path1 = TestUtils.getFixturePathAsString("file1TestIn.yml");
        String path2 = TestUtils.getFixturePathAsString("file2TestIn.yml");

        String expected = "{\"differ\":[{\"hasInBothFiles\":true,\"operation\":"
                + "\"equals\",\"value\":[\"a\",\"b\",\"c\"],\"key\":\"chars1\"},"
                + "{\"hasInBothFiles\":\"true\",\"valueOfSecondFile\":false,\"valueOfFirstFile\":"
                + "[\"d\",\"e\",\"f\"],\"operation\":\"updated\",\"key\":\"chars2\"},"
                + "{\"hasInBothFiles\":\"true\",\"valueOfSecondFile\":true,\"valueOfFirstFile\":"
                + "false,\"operation\":\"updated\",\"key\":\"checked\"},{\"hasInBothFiles\":\"true\","
                + "\"valueOfSecondFile\":[\"value1\",\"value2\"],\"valueOfFirstFile\":null,"
                + "\"operation\":\"updated\",\"key\":\"default\"},{\"hasInBothFiles\":\"true\","
                + "\"valueOfSecondFile\":null,\"valueOfFirstFile\":45,\"operation\":\"updated\","
                + "\"key\":\"id\"},{\"hasInBothFiles\":false,\"operation\":\"removed\",\"value\":"
                + "\"value1\",\"key\":\"key1\"},{\"hasInBothFiles\":false,\"operation\":\"added\","
                + "\"value\":\"value2\",\"key\":\"key2\"},{\"hasInBothFiles\":true,\"operation\":"
                + "\"equals\",\"value\":[1,2,3,4],\"key\":\"numbers1\"},{\"hasInBothFiles\":\"true\","
                + "\"valueOfSecondFile\":[22,33,44,55],\"valueOfFirstFile\":[2,3,4,5],\"operation\":"
                + "\"updated\",\"key\":\"numbers2\"},{\"hasInBothFiles\":false,\"operation\":\"removed\","
                + "\"value\":[3,4,5],\"key\":\"numbers3\"},{\"hasInBothFiles\":false,\"operation\":\"added\","
                + "\"value\":[4,5,6],\"key\":\"numbers4\"},{\"hasInBothFiles\":false,\"operation\":\"added\","
                + "\"value\":{\"nestedKey\":\"value\",\"isNested\":true},\"key\":\"obj1\"},{\"hasInBothFiles\":"
                + "\"true\",\"valueOfSecondFile\":\"Another value\",\"valueOfFirstFile\":\"Some value\","
                + "\"operation\":\"updated\",\"key\":\"setting1\"},{\"hasInBothFiles\":\"true\","
                + "\"valueOfSecondFile\":300,\"valueOfFirstFile\":200,\"operation\":\"updated\","
                + "\"key\":\"setting2\"},{\"hasInBothFiles\":\"true\",\"valueOfSecondFile\":\"none\","
                + "\"valueOfFirstFile\":true,\"operation\":\"updated\",\"key\":\"setting3\"}]}";

        String actual = Differ.generate(path1, path2, "json");
        assertEquals(expected, actual);

        TestUtils.createTestOutputFile("testGenerateJsonByYml.json", actual);
    }
}
