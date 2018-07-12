/**
 * Package for calculate task.
 *
 * @author Egor Reutov (mailto:reutov9@yandex.ru)
 * @version $Id$
 * @since 0.1
 */

package ru.job4j.calculate;

/**
 * Main.
 * @param args - args.
 */
public class Calculate {

	/**
	 * @param main выводит на экран "Hello World"
	 */
	public static void main(String[] args) {
		System.out.println("Hello World");
	}

	/**
	 * Method echo.
	 * @param name Egor Reutov.
	 * @return Echo plus your name.
	 */
	public String echo(String name) {
		return "Echo, echo, echo : " + name;
	}
}