package ru.job4j.tracker;

import java.util.*;

public class Tracker implements ITracker {
    private List<Item> items = new ArrayList<>();
    private int position = 0;
    private static final Random RN = new Random();

    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    public Item add(Item item) {
        item.setId(this.generateId());
        //this.items[position++] = item;
        items.add(item);
        return item;
    }

    public boolean replace(String id, Item item) {
        boolean result = false;
        if (this.findById(id) != null) {
            for (int index = 0; index != items.size(); index++) {
                if (items.get(index).getId().equals(id)) {
                    item.setId(id);
                    items.set(index, item);
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    public void delete(String id) {
        for (Item index : items) {
            if (index.getId().equals(id)) {
                items.remove(index);
                //System.arraycopy(this.items, index + 1, items, index, position - index - 1);
                //position--;
                break;
            }
        }
    }

    public List<Item> findAll() {
        return items;
    }

    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
//        int count = 0;
        for (Item index : items) {
            if (index.getName().equals(key)) {
                result.add(index);
                //result[count++] = items[index];
            }
        }
        // return Arrays.copyOf(result, count);
        return result;
    }

    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }
}
