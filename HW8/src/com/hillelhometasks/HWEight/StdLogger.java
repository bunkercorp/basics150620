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
    @Override
    public void log(String date) {
        System.out.printf("%s%s\n", logPrefix(), date);
    }

    public static void main(String[] args) {
        StdLogger stdLogger = new StdLogger();
        for (int i = 0; i <10  ; i++) {
            stdLogger.log("test");


        }

    }

}


