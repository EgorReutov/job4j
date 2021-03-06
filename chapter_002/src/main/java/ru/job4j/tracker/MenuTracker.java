package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;



public class MenuTracker {

    /**
     * @param хранит ссылку на объект .
     */
    private Input input;

    /**
     * @param хранит ссылку на объект .
     */
    private ITracker tracker;

    /**
     * @param хранит ссылку на массив типа UserAction.
     */
    private List<UserAction> actions = new ArrayList<>();

    /**
     * Конструктор.
     *
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     */
    public MenuTracker(Input input, ITracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Метод для получения массива меню.
     *
     * @return длину массива
     */
    public int getActionsLentgh() {
        return this.actions.size();
    }

    /**
     * Метод заполняет массив.
     */
    public void fillActions() {
        this.actions.add(new AddAction(0, "Add item"));
        this.actions.add(new ShowItems(1, "Show all items"));
        this.actions.add(new EditItem(2, "Edit item"));
        this.actions.add(new DeleteItem(3, "Delete item"));
        this.actions.add(new FindItemById(4, "Find item by Id"));
        this.actions.add(new FindItemsByName(5, "Find items by name"));
        this.actions.add(new ExitProgram(6, "Exit Program"));
    }

    /**
     * Метод в зависимости от указанного ключа, выполняет соотвествующие действие.
     *
     * @param key ключ операции
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    /**
     * Метод выводит на экран меню.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    public class AddAction extends BaseAction {
        public AddAction(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, ITracker tracker) {
            System.out.println("------------ Adding new item --------------");
            String name = input.ask("Please, provide item name:");
            String desc = input.ask("Please, provide item description:");
            Item item = new Item(name, desc);
            tracker.add(item);
            System.out.println("------------ New Item with Id : " + item.getId());
            System.out.println("------------ New Item with Name : " + item.getName());
            System.out.println("------------ New Item with Description : " + item.getDesc());
        }
    }

    public class ShowItems extends BaseAction {
        public ShowItems(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, ITracker tracker) {
            System.out.println("--------- All items ---------");
            System.out.format("%16s%16s%16s", "Item name", "Description", "ID item");
            System.out.println();
            for (Item item : tracker.findAll()) {
                System.out.format("%16s%16s%16s", item.getName(), item.getDesc(), item.getId());
                System.out.println();
            }
        }
    }

    public class EditItem extends BaseAction {
        public EditItem(int key, String name) {
            super(key, name);
        }

        @Override
        public  void execute(Input input, ITracker tracker) {
            System.out.println("--------- Edit Item ---------");
            String id = input.ask("Please, provide item id: ");
            String name = input.ask("Please, provide item name: ");
            String desc = input.ask("Please, provide item description: ");
            Item itemNew = new Item(name, desc);
            tracker.replace(id, itemNew);
        }
    }

    public class DeleteItem extends BaseAction {
        public DeleteItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, ITracker tracker) {
            System.out.println("--------- Delete Item ---------");
            String id = input.ask("Provide id Item: ");
            tracker.delete(id);
            System.out.println("Delete successfully");
        }
    }

    public class FindItemById extends BaseAction {
        public FindItemById(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, ITracker tracker) {
            System.out.println("--------- Find Item by id ---------");
            String id = input.ask("Provide id Item: ");
            Item result = tracker.findById(id);
            if (result == null) {
                System.out.println("--------- Item does not exist ---------");
            } else {
                System.out.println("--------- Item find ---------");
                System.out.format("%16s%16s%16s", "Item name", "Description", "Item id");
                System.out.println();
                System.out.format("%16s%16s%16s", result.getName(), result.getDesc(), result.getId());
                System.out.println();
            }
        }
    }

    public class FindItemsByName extends BaseAction {
        public FindItemsByName(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, ITracker tracker) {
            System.out.println("--------- Find Item by name ---------");
            String name = input.ask("Provide Item name: ");
            List<Item> result = tracker.findByName(name);
            System.out.println("--------- Item find ---------");
            System.out.format("%16s%16s%16s", "Item name", "Description", "Item id");
            System.out.println();
            for (Item item : result) {
                System.out.format("%16s%16s%16s", item.getName(), item.getDesc(), item.getId());
                System.out.println();
            }
        }
    }

    public class ExitProgram extends BaseAction {
        public ExitProgram(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, ITracker tracker) {
        }
    }
}

