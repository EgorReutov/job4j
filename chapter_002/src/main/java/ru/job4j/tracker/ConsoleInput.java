package ru.job4j.tracker;

import java.util.*;

public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    public String ask(String question) throws MenuOutException {
        String result = null;
        try {
            result = scanner.nextLine();
        } catch (MenuOutException moe) {
            System.out.println("Пожалуйста, введите корректные данные.");
        }
        return result;
    }

    public int ask(String question, List<Integer> range) throws MenuOutException {
        int key = 0;
        try {
            key = Integer.valueOf(this.ask(question));
        } catch (MenuOutException moe) {
            System.out.println("Пожалуйста, введите корректные данные.");
        }
        return key;
    }
}