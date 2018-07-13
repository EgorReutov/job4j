/**
 * Package for calculate task.
 *
 * @author Egor Reutov (mailto:reutov9@yandex.ru)
 * @version $Id$
 * @since 0.1
 */

package ru.job4j.calculator;

/**
 * Main.
 * @param args - args.
 */

public class Calculator {

    private double result;

    public void add(double first, double second) {
        this.result = first + second;
    }

    public void subtract(double first, double second) {
        this.result = first - second;
    }

    public void div(double first, double second) {
        this.result = first / second;
    }

    public void multiple(double first, double second) {
        this.result = first * second;
    }

    public double getResult() {
        return this.result;
    }
}