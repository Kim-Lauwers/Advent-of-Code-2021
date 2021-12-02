package be.aoc;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static java.nio.file.Files.lines;
import static java.util.stream.Collectors.toUnmodifiableList;

public class Part1 {

    private static int depth = 0;
    private static int horizontal = 0;

    public static void main(String[] args) throws Exception {
        final Path path = Paths.get(Part1.class.getClassLoader().getResource("input.txt").toURI());
        final List<String> commands = lines(path)
                .collect(toUnmodifiableList());

        commands.forEach(Part1::parse);
        System.out.println("Solution: " + (depth * horizontal));
    }

    private static void parse(String line) {
        if (line.startsWith("forward")) {
            int dist = Integer.valueOf(line.substring(8));
            horizontal += dist;
        } else if (line.startsWith("down")) {
            int dist = Integer.valueOf(line.substring(5));
            depth += dist;
        } else if (line.startsWith("up")) {
            int dist = Integer.valueOf(line.substring(3));
            depth -= dist;
        }
    }
}