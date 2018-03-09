package com.crayon2f.one;

import com.crayon2f.three.pojo.Language;
import com.crayon2f.two.pojo.Person;

import java.util.logging.Logger;

/**
 * Created by feiFan.gou on 2018/3/9 11:26.
 */
public class Main {

    private final static Logger LOGGER = Logger.getLogger("m.one.main");
    public static void main(String[] args) {

        LOGGER.info("hello module");

        Person person = new Person("Jack", 34);
        System.out.println(person.getAge());

        Language language = new Language();
        language.setCategory(3);
        System.out.println(language.getCategory());
    }
}
