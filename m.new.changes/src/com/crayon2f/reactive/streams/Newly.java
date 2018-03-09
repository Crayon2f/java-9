package com.crayon2f.reactive.streams;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by feiFan.gou on 2018/3/1 16:11.
 */
public class Newly {

    public static void main(String[] args) throws InterruptedException, ExecutionException {


        Runnable runnable = () -> {
            System.out.println(" ========================= runnable ========================= ");

        };

        StringBuffer result = new StringBuffer();

        FutureTask<StringBuffer> task = new FutureTask<>(runnable, result);


        task.run();
        System.out.println(task.get());

        Thread.sleep(60 * 1000);

    }
}
