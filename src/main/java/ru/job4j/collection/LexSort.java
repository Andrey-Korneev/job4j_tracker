package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] leftWords = left.split("\\.");
        String[] rightWords = right.split("\\.");
        int leftNumber = Integer.parseInt(leftWords[0]);
        int rightNumber = Integer.parseInt(rightWords[0]);
        return Integer.compare(leftNumber, rightNumber);
    }
}
