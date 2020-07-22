package com.hillelhometasks.HWEight;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Logger {
    public void log(String solo){
        final String method = Thread.currentThread().getStackTrace()[2].getMethodName();
        String dateFunc = new SimpleDateFormat("HH:MM:ss:SS").format(new Date());
        System.out.printf("%d %s [%s]: %s\n", ++counter,dateFunc,method,content);
        System.out.println();
    }
}
