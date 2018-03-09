package com.crayon2f.collection;


import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by feiFan.gou on 2018/2/24 17:39.
 *  List.of()、Set.of()、Map.of() 和 Map.ofEntries()等工厂方法来创建不可变集合
 */
public class Newly {

    @Test
    public void listOf() {

        System.out.println(List.of(1, 2, 3, 4));
        System.out.println(List.of("a", "2", "3"));

    }

    /**
     * 不能存放重复的元素
     */
    @Test
    public void setOf() {

        System.out.println(Set.of("1", "3", "4"));
        System.out.println(Set.of(false, true));

    }

    @Test
    public void mapOf() {

        // key和value 泛型确定 则返回 Map<K,V>
        Map<String, Integer> map = Map.of("0", 2, "3", 3);
        map.forEach((key, value) -> System.out.println(String.format("key = %s; value = %s", key, value)));
        // map.put("1", 3); //不能操作 !!!
        // key和value 泛型不一定, 则返回 不带泛型的map
        Map<?,?> without = Map.of(1, 2, "4", "9");
        without.forEach((key, value) -> {
            System.out.println(key instanceof String);
            System.out.println(value instanceof String);
            System.out.println(String.format("key = %s; value = %s", key, value));
        });
    }

    @Test
    public void mapOfEntries() {

        Map<String, String> stringMap = Map.ofEntries(Map.entry("1", "2"), Map.entry("2", "4"));
        System.out.println(stringMap);


        Map<String, String> map = new HashMap<>();
        Map.of("1", "3", "2", "4", "3", "5").entrySet().forEach(entry -> {
            Map.ofEntries(entry).forEach(map::put);
        });
        System.out.println(map);
    }

}
