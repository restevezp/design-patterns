package com.kreitek.pets.utils;

import com.kreitek.pets.infraestructure.bd.DbService;

public class ConsoleLogger {
    private static volatile ConsoleLogger instance = null;
    private static int logCounter = 0;

    private ConsoleLogger() {
        if (instance != null) {
            throw new RuntimeException("Usage getInstance method to create");
        }

    }
    public static ConsoleLogger getInstance() {
        if (instance == null) {
            synchronized (ConsoleLogger.class) {
                if (instance == null) {
                    instance = new ConsoleLogger();
                }
            }
        }
        return instance;
    }

    public void debug(String message) {
        logCounter++;
        System.out.println("[debug][" + logCounter + "] - " + message);
    }
}
