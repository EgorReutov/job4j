package ru.job4j.list;

import java.util.HashMap;
import java.util.List;

public class UserConvert {
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> result = new HashMap<Integer, User>();
        for (User o : list) {
            result.put(o.getIdUser(), o);
        }
        return result;
    }
}
