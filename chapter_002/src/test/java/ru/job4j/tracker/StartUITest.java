package ru.job4j.tracker;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class StartUITest {
    private String ls = System.lineSeparator();
    private StringBuilder menu =
            new StringBuilder("0 : Add new Item.").append(ls)
                    .append("1 : Show all items").append(ls)
                    .append("2 : Edit item").append(ls)
                    .append("3 : Delete item").append(ls)
                    .append("4 : Find item by Id").append(ls)
                    .append("5 : Find items by name").append(ls)
                    .append("6. Exit Program").append(ls);
    ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.out.println("execute after method");
    }

    @Test
    public void whenAddItem() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }

    @Test
    public void whenEditItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("task1", "desc1"));
        Input input = new StubInput(new String[]{"2", item.getId(), "task2", "desc2", "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("task2"));
    }
}
