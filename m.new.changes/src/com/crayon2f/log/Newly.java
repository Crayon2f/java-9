package com.crayon2f.log;

import org.junit.Test;

import java.lang.invoke.VarHandle;

/**
 * Created by feiFan.gou on 2018/3/1 15:15.
 */
public class Newly {

    private static final System.Logger LOGGER = System.getLogger("log");
    @Test
    public void log() {
        System.out.println(LOGGER.isLoggable(System.Logger.Level.DEBUG));
        LOGGER.log(System.Logger.Level.INFO, "this is jdk9 logger ");
        System.LoggerFinder finder = System.LoggerFinder.getLoggerFinder();
        //TODO 待定学习
    }
}
