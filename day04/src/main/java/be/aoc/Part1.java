package be.aoc;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static java.nio.file.Files.lines;
import static java.util.stream.Collectors.toUnmodifiableList;

public class Part1 {
    public static void main(String[] args) throws Exception {
        final Path path = Paths.get(Part1.class.getClassLoader().getResource("input.txt").toURI());
        final List<String> lines = lines(path)
                .collect(toUnmodifiableList());
    }
}