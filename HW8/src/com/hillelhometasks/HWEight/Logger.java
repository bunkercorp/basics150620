package com.hillelhometasks.HWEight;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Logger {
    protected static StdLogger log;

    Logger(){}
    int tik = 1;
    public void log(String solo){
        final String method = Thread.currentThread().getStackTrace()[2].getMethodName();
        String dateFunc = new SimpleDateFormat("HH:MM:ss:SS").format(new Date());
        System.out.printf("%d %s [%s]: %s\n", ++tik,dateFunc,method,solo);
        System.out.println();
    }
}
