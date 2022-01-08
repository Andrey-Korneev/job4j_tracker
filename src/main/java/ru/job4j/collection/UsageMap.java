package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("billy_bons@yandex.ru", "Billy Bons");
        map.put("john_silver@mail.ru", "John Silver");
        map.put("jimmy_hokkins@inbox.com", "Jimmy Hokkins");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }
    }
}
