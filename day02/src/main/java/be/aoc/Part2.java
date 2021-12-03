package be.aoc;

import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.Files.lines;

public class Part2 {
    private static int depth = 0;
    private static int horizontal = 0;
    private static int aim = 0;

    public static void main(String[] args) throws Exception {
        final Path path = Paths.get(Part2.class.getClassLoader().getResource("input.txt").toURI());

        lines(path)
                .map(line -> line.split(" "))
                .forEach(Part2::parse);

        System.out.println("Solution: " + (depth * horizontal));
    }

    private static void parse(String[] splits) {
        String command = splits[0];
        Integer distance = Integer.valueOf(splits[1]);

        if ("forward".equals(command)) {
            horizontal += distance;
            depth += aim * distance;
        } else if ("down".equals(command)) {
            aim += distance;
        } else if ("up".equals(command)) {
            aim -= distance;
        }
    }
}