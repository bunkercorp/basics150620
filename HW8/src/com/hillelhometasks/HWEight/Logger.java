package com.hillelhometasks.HWEight;

import java.text.SimpleDateFormat;
import java.util.Date;
public abstract class Logger {
    private int tik;
    public void log(String date){
        System.out.printf("%s%s\n", logPrefix(), date);
    }

    protected String logPrefix() {
        String method = Thread.currentThread().getStackTrace()[3].getMethodName();
        String dateStr = new SimpleDateFormat("HH:mm:ss:SSS").format(new Date());
        return String.format("%d) %s [%s]: ", ++tik, dateStr, method);
    }
}
