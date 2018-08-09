package ru.job4j.tracker;

public class StartUI {

    private static final String ADD = "0";
    private static final String Show = "1";
    private static final String Edit = "2";
    private static final String Delete = "3";
    private static final String FindById = "4";
    private static final String FindByName = "5";
    private static final String EXIT = "6";

    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (Show.equals(answer)) {
                this.showAll();
            } else if (Edit.equals(answer)) {
                this.editItem();
            } else if (Delete.equals(answer)) {
                this.deleteItem();
            } else if (FindById.equals(answer)) {
                this.findById();
            } else if (FindByName.equals(answer)) {
                this.setFindByName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }


    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    /**
     * Метод реализует выведение на экран всех заявок.
     */
    private void showAll() {
        System.out.println("------------ Все заявки --------------");
        this.tracker.findAll();
    }

    /**
     * Метод реализует редактирование заявки.
     */
    private void editItem() {
        System.out.println("--------- Редактирование заявки ---------");
        String id = this.input.ask("Введите id заявки: ");
        String name = this.input.ask("Введите имя заявки: ");
        String desc = this.input.ask("Введите описание заявки: ");
        Item itemNew = new Item(name, desc);
        this.tracker.replace(id, itemNew);
        System.out.println("--------- Заявка отредактирована ---------");
    }

    /**
     * Метод реализует удаление заявки.
     */
    private void deleteItem() {
        System.out.println("--------- Удаление заявки ---------");
        String id = this.input.ask("Введите id заявки: ");
        this.tracker.delete(id);
    }

    /**
     * Метод поиск по id заявки.
     */
    public void findById() {
        System.out.println("--------- Поиск заявки по id ---------");
        String id = this.input.ask("Введите id заявки: ");
        this.tracker.findById(id);
    }

    /**
     * Метод поиск по имени заявки.
     */

    public void setFindByName() {
        System.out.println("--------- Поиск заявки по имени ---------");
        String name = this.input.ask("Введите имя заявки: ");
        this.tracker.findByName(name);
    }


    /**
     * Метод отображает меню.
     */
    private void showMenu() {
        System.out.println("Меню.");
        System.out.println("0. Add new Item.");
        System.out.println("1. Show all items.");
        System.out.println("2. Edit item.");
        System.out.println("3. Delete item.");
        System.out.println("4. Find item by Id.");
        System.out.println("5. Find items by name.");
        System.out.println("6. Exit Program.");
        System.out.println("Select:");
    }

    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}

