package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.findAll()[0], is(item));
    }
    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        tracker.add(previous);
        Item next = new Item("test2", "testDescription2", 1234L);
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }
    @Test
    public void testFindAll() {
        Tracker tracker = new Tracker();
        Item itemFirst = new Item("test1", "desc1", 123L);
        Item itemSecond = new Item("test2", "desc2", 123L);
        Item itemThird = new Item("test3", "desc3", 123L);
        tracker.add(itemFirst);
        tracker.add(itemSecond);
        tracker.add(itemThird);
        Item[] result = tracker.findAll();
        assertThat(result, is(new Item[]{itemFirst, itemSecond, itemThird}));
    }

    @Test
    public void testDeleteElement() {
        Tracker tracker = new Tracker();
        Item itemFirst = new Item("test1", "desc1", 123L);
        Item itemSecond = new Item("test2", "desc2", 123L);
        Item itemThird = new Item("test3", "desc3", 123L);
        tracker.add(itemFirst);
        tracker.add(itemSecond);
        tracker.add(itemThird);
        tracker.delete(itemFirst.getId());
        assertThat(tracker.findAll()[0], is(itemSecond));
    }
    @Test
    public void testFindByNameTest() {
        Tracker tracker = new Tracker();
        Item itemFirst = new Item("item", "desc1", 13L);
        Item itemSecond = new Item("item1", "desc2", 14L);
        tracker.add(itemFirst);
        tracker.add(itemSecond);
        Item[] result = tracker.findByName("item");
        assertThat(result, is(new Item[]{itemFirst}));
    }
    @Test
    public void testFindById() {
        Tracker tracker = new Tracker();
        Item itemFirst = new Item("item", "desc1", 123L);
        Item itemSecond = new Item("item1", "desc2", 123L);
        Item itemThird = new Item("test3", "desc3", 123L);
        tracker.add(itemFirst);
        tracker.add(itemSecond);
        tracker.add(itemThird);
        Item result = tracker.findById(itemSecond.getId());
        assertThat(result, is(itemSecond));
    }
}
