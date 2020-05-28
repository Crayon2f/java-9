package com.crayon2f.grammar;

import com.crayon2f.interfaces.GenericInterface;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Created by feiFan.gou on 2018/3/1 10:34.
 */
public class Newly {

    @Test
    public void AnonymousInnerClassWithDiamond() {

        GenericInterface<String> generic = new GenericInterface<>() {
            @Override
            public void fun() {

            }

            @Override
            public void fun2() {

            }
        };

        // 在jdk9 以前匿名内部类泛型不可以直接写<> ,例如上面的,必须写成
        // GenericInterface<String> generic = new GenericInterface<String>(){...}
        // 但是jdk 9 可以直接写<>
    }

    @Test
    public void tryResource() throws IOException {

        // old :
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\feifan.gou\\Desktop\\vim.txt"))) {
            String temp;
            while (null != (temp = reader.readLine())) {
                System.out.println(temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //new :
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\feifan.gou\\Desktop\\vim.txt"));
        FileInputStream fis = new FileInputStream("");
        try (reader;fis) {
            String temp;
            while (null != (temp = reader.readLine())) {
                System.out.println(temp);
            }
        }
    }

    @Test
    public void processImpl() {

        ProcessHandle processHandle = ProcessHandle.current();
        System.out.println("当前进程ID: " + processHandle.pid());
        ProcessHandle.Info info = ProcessHandle.current().info();
        info.command().ifPresent(System.out::println);
        info.arguments().ifPresent(System.out::println);
        info.commandLine().ifPresent(System.out::println);
        info.startInstant().ifPresent(System.out::println);
        info.totalCpuDuration().ifPresent(System.out::println);
        info.user().ifPresent(System.out::println);
    }

    @Test
    public void completableFutureImpl() throws InterruptedException {

        timer();
        Thread.sleep(600 * 1000);
        System.out.println();
    }

    private void timer() {

        // 延迟xx 执行
        Executor executor = CompletableFuture.delayedExecutor(10L, TimeUnit.SECONDS); //10秒
        Runnable command = () -> {
            long currentMilli = Instant.now().toEpochMilli();
            System.out.println(currentMilli);
        };
        executor.execute(command);
    }



}

