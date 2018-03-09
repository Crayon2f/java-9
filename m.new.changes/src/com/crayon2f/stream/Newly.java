package com.crayon2f.stream;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by feiFan.gou on 2018/2/24 18:34.
 */
public class Newly {


    /**
     * 对已经排好顺序的Stream，从不符合条件的第一个开始执行,如果返回false,立即中断,不在管后面的
     */
    @Test
    public void dropWhile() {
        List<Integer> list = Stream.of(1, 9, 3, 4, 5, 6, 4, 8, 9).dropWhile(i -> {
            System.out.print("dropWhile:" + i + "\t");
            return i < 5;
        }).collect(Collectors.toList());
        System.out.println(list);
//        Assert.assertEquals(4, count);
    }

    /**
     * 在返回false以后, stream 立即中断不在向后执行,与filter不一样,filter在返回false以后,仍然向后执行,直到stream末尾
     */
    @Test
    public void takeWhile() {

        Stream.of(1,2,3,4,9,4,5,8,10).takeWhile(integer -> {
            System.out.println("takeWhile:" + integer + "\t");
            return integer < 4;
        }).forEach(System.out::println);

    }

}
