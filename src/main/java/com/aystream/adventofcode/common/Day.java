package com.aystream.adventofcode.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

public abstract class Day {
    public static final String DEFAULT_DELIMITER = "\n";
    protected final int year;
    protected final int day;
    protected int example = 0;

    private Object solutionPart1;
    private Object solutionPart2;

    public Day(int year, int day) {
        this.year = year;
        this.day = day;
    }

    public Day setExample(int example) {
        this.example = example;
        return this;
    }

    public static String getResourceAsString(String resource) {
        try {
            return Files.readString(getResource(resource).toPath());
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public static File getResource(String path) {
        return new File("src/main/resources/" + path);
    }

    private String getDayPath() {
        boolean b = example != 0;
        return year + (b ? "-examples" : "") + "/day" + day + (b ? "-" + example : "") + ".txt";
    }

    public abstract Object part1();

    public abstract Object part2();

    public void printParts() {
        solutionPart1 = part1();
        if (solutionPart1 instanceof Optional) solutionPart1 = ((Optional<?>) solutionPart1).get();
        System.out.println("Part 1: " + solutionPart1);
        solutionPart2 = part2();
        if (solutionPart2 instanceof Optional) solutionPart2 = ((Optional<?>) solutionPart2).get();
        System.out.println("Part 2: " + solutionPart2);
    }

    protected String day() {
        return getResourceAsString(getDayPath());
    }

    protected Stream<String> dayStream() {
        return dayStream(DEFAULT_DELIMITER);
    }

    protected Stream<String> dayStream(String delimiter) {
        return Arrays.stream(day().split(delimiter));
    }

}