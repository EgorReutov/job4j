package ru.job4j.tracker;

import java.util.*;

public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    public String ask(String question) {
        return scanner.nextLine();
    }

    public int ask(String question, int[] range) {
        return 0;
    }
}