package fr.lernejo.umlgrapher;

import picocli.CommandLine;
import picocli.CommandLine.Option;
import java.lang.Runnable;

public class Launcher implements Runnable {
    @Option(names = {"-c", "--classes"}, required = true, description = "Renseignemant de class")
    private final Class<?>[] user_class = {};
    @Option(names = {"-g", "--graph-type"}, description = "Selected type of output")
    private final GraphType graphType = GraphType.Mermaid;

    @Override
    public void run() {
        UmlGraph graph = new UmlGraph(user_class);
        String output = graph.as(graphType);
        System.out.println(output);
    }

    public static void main(String... args) {
        int exitCode = new CommandLine(new Launcher()).execute(args);
        System.exit(exitCode);
    }
}
