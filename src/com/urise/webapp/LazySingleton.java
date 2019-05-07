package com.urise.webapp;

public class LazySingleton {
    volatile private static LazySingleton INSTANCE;

    public LazySingleton() {
    }

    public static LazySingleton getINSTANCE() {
        if (INSTANCE == null) {
            synchronized (LazySingleton.class) {
                if (INSTANCE == null) {
                    INSTANCE = new LazySingleton();
                }
            }
        }
        return INSTANCE;
    }
}
