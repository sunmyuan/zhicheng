package com.henu.main.util;

import java.util.HashMap;

public class ApplicationInit {

    private static HashMap<String, String> memoryDatabase = new HashMap<>();

    public static HashMap<String, String> getMemoryDatabase() {
        return memoryDatabase;
    }

}
