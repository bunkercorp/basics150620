package com.hillelhometasks.HWEight;

public class StdLogger extends Logger {


    private static StdLogger _instance;

    private StdLogger() {

    }

    public static StdLogger get_instance() {
        if (_instance == null)
            _instance = new StdLogger();
        return _instance;
    }

    public void log(String date) {
        System.out.printf("%s%s\n", logPrefix(), date);
    }


    }




