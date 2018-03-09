package com.crayon2f.collectors;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by feiFan.gou on 2018/3/1 14:45.
 */
public class Newly {

    private List<String> list = List.of("1", "2", "56", "666", "634534");

    /**
     * 过滤
     */
    @Test
    public void filtering() {

        Long collect = list.stream()
                .collect(Collectors.filtering(string -> string.length() < 3, Collectors.counting()));
        System.out.println(collect);
    }

    /**
     * 流转换类型
     */
    @Test
    public void flatMapping() {

        Integer collect = list.stream()
                .collect(Collectors.flatMapping(string -> Stream.of(Integer.valueOf(string)), Collectors.summingInt(integer -> integer)));
        System.out.println(collect);
    }
}
