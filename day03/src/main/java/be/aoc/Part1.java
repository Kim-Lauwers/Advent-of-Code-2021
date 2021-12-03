package be.aoc;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static java.nio.file.Files.lines;
import static java.util.stream.Collectors.toUnmodifiableList;

public class Part1 {
    private static final char ONE = '1';
    private static final char ZERO = '0';

    public static void main(String[] args) throws Exception {
        final Path path = Paths.get(Part1.class.getClassLoader().getResource("input.txt").toURI());
        final List<String> diagnosticReport = lines(path)
                .collect(toUnmodifiableList());

        int diagnosticReportRecordSize = diagnosticReport.get(0).length();
        StringBuilder gammaBuilder = new StringBuilder();
        StringBuilder epsilonBuilder = new StringBuilder();

        for (int i = 0; i < diagnosticReportRecordSize; i++) {
            int j = i;
            long numberOfOnes = diagnosticReport.stream().filter(s -> s.charAt(j) == ONE).count();
            long numberOfZeros = diagnosticReport.size() - numberOfOnes;
            if (numberOfOnes > numberOfZeros) {
                gammaBuilder.append(ONE);
                epsilonBuilder.append(ZERO);
            } else {
                gammaBuilder.append(ZERO);
                epsilonBuilder.append(ONE);
            }
        }

        int gamma = parseBinaryToDecimal(gammaBuilder.toString());
        int epsilon = parseBinaryToDecimal(epsilonBuilder.toString());

        System.out.println(gamma * epsilon);
    }

    private static int parseBinaryToDecimal(String binary) {
        return Integer.parseInt(binary, 2);
    }
}