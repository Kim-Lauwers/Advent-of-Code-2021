package be.aoc;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static java.nio.file.Files.lines;
import static java.util.stream.Collectors.toUnmodifiableList;

public class Day01Part2 {

    public static void main(String[] args) throws Exception {
        final Path path = Paths.get(Day01.class.getClassLoader().getResource("input.txt").toURI());
        final List<Integer> integers = lines(path)
                .map(Integer::parseInt)
                .collect(toUnmodifiableList());

        int prev = getTotalOfNext3(integers, 0);
        int total = 0;

        for (int i = 3; i < integers.size(); i++) {
            if (getTotalOfNext3(integers, i - 2) > prev) {
                total++;
            }
            prev = getTotalOfNext3(integers, i - 2);
        }

        System.out.println(total);
    }

    private static int getTotalOfNext3(List<Integer> integers, int startIndex) {
        return integers.get(startIndex) + integers.get(startIndex + 1) + integers.get(startIndex + 2);
    }
}