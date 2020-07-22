package com.hillelhometasks.HWEight;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Logger {
    Logger(){}
    int counter = 1;
    protected void log(String solo){
        final String method = Thread.currentThread().getStackTrace()[2].getMethodName();
        String dateFunc = new SimpleDateFormat("HH:MM:ss:SS").format(new Date());
        System.out.printf("%d %s [%s]: %s\n", ++counter,dateFunc,method,solo);
        System.out.println();
    }
}
