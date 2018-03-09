package com.crayon2f.optional;

import org.junit.Test;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by feiFan.gou on 2018/3/1 15:03.
 */
public class Newly {

    @Test
    public void stream() {

        long count = Optional.of("33").stream().count();
        System.out.println(count);
        System.out.println(Optional.empty().stream().count());

        Stream.of(Optional.of(1), Optional.empty(), Optional.of(3)).flatMap(Optional::stream)
                .forEach(System.out::println);
    }

    @Test
    public void ifPresentOrElse() {

        Optional<Integer> optional = Optional.empty();
        optional.ifPresentOrElse(System.out::println, () -> {
            throw new RuntimeException("option is empty");
        });

    }
}
