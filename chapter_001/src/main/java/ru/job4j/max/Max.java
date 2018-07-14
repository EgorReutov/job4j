package ru.job4j.max;

/**
 * @author Egor Reutov (mailto:reutov9@yandex.ru)
 * @version $Id$
 * @since 14.07.2018
 */

public class Max {
    public int max(int first, int second) {
        return first > second ? first : second;
    }
    public int max(int first, int second, int third) {
        return this.max(this.max(first, second), third);
    }

}
