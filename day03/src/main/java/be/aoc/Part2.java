package be.aoc;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.BiFunction;

import static java.nio.file.Files.lines;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toUnmodifiableList;

public class Part2 {
    private static final char ONE = '1';
    private static final char ZERO = '0';

    public static void main(String[] args) throws Exception {
        final Path path = Paths.get(Part2.class.getClassLoader().getResource("input.txt").toURI());
        final List<String> diagnosticReport = lines(path)
                .collect(toUnmodifiableList());

        int oxygen = findInBits(diagnosticReport, (ones, zeros) -> ones >= zeros ? ONE : ZERO);
        int carbonDioxide = findInBits(diagnosticReport, (ones, zeros) -> ones >= zeros ? ZERO : ONE);

        System.out.println(oxygen * carbonDioxide);
    }

    private static int findInBits(List<String> diagnosticReport, BiFunction<Long, Long, Character> bitSelector) {
        var diagnosticReportUnderInvestigation = diagnosticReport;
        int diagnosticReportRecordSize = diagnosticReport.get(0).length();

        for (int i = 0; i < diagnosticReportRecordSize && diagnosticReportUnderInvestigation.size() > 1; i++) {
            int j = i;
            long numberOfOnes = diagnosticReportUnderInvestigation.stream().filter(s -> s.charAt(j) == '1').count();
            long numberOfZeros = diagnosticReportUnderInvestigation.size() - numberOfOnes;
            char expectedChar = bitSelector.apply(numberOfOnes, numberOfZeros);

            diagnosticReportUnderInvestigation = diagnosticReportUnderInvestigation
                    .stream()
                    .filter(s -> s.charAt(j) == expectedChar)
                    .collect(toList());
        }

        return parseBinaryToDecimal(diagnosticReportUnderInvestigation.get(0));
    }

    private static int parseBinaryToDecimal(String binary) {
        return Integer.parseInt(binary, 2);
    }
}