package hexlet.code;

import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "gendiff",
        mixinStandardHelpOptions = true,
        version = "gendiff 1.0",
        description = "Compares two configuration files and shows a difference.")
public final class App implements Callable<Integer> {
    @CommandLine.Parameters(index = "0",
            description = "path to first file")
    private String filepath1;
    @CommandLine.Parameters(index = "1",
            description = "path to second file")
    private String filepath2;

    @CommandLine.Option(names = {"-f", "--format"},
            defaultValue = "stylish",
            description = "out format [default: stylish]")
    private String format;
    @Override
    public Integer call() throws Exception {
        String result = Differ.generate(filepath1, filepath2, format);
        System.out.println(result);
        return 0;
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
