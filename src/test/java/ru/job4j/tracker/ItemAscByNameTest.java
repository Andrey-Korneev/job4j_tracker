package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ItemAscByNameTest {

    @Test
    public void sort() {
        Item one = new Item(1, "Jacket");
        Item two = new Item(2, "Dress");
        Item three = new Item(3, "Hat");
        Item four = new Item(4, "Trousers");
        Item five = new Item(5, "Shoes");

        List<Item> list = new ArrayList<>();
        list.add(one);
        list.add(two);
        list.add(three);
        list.add(four);
        list.add(five);

        List<Item> expected = List.of(two, three, one, five, four);
        Collections.sort(list, new ItemAscByName());
        assertThat(list, is(expected));
    }
}