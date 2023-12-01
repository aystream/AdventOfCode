package com.aystream.adventofcode.year23;

import com.aystream.adventofcode.common.Day;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        IntStream.range(1, 25).forEach(day -> {
            try {
                processDay(day);
            } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private static void processDay(int day) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        System.out.println("Day " + day + ":");
        Day instance = (Day) Class.forName("com.aystream.adventofcode.year23.days.Day" + day).getDeclaredConstructor().newInstance();
        instance.printParts();
        System.out.println();
    }
}