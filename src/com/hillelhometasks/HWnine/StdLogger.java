package com.hillelhometasks.HWnine;
//HW Nine
import java.text.SimpleDateFormat;
import java.util.Date;

    public class StdLogger implements Logger {
        private static StdLogger _instance;
        int tik = 0;
        private StdLogger() {
        }

        public static StdLogger get_instance() {
            if (_instance == null)
                _instance = new StdLogger();
            return _instance;
        }
        @Override
        public void log(String date){
            System.out.printf("%s%s\n", logPrefix(), date);
        }

        @Override
        public String logPrefix() {
            String method = Thread.currentThread().getStackTrace()[3].getMethodName();
            String dateStr = new SimpleDateFormat("HH:mm:ss:SSS").format(new Date());
            return String.format("%d) %s [%s]: ", ++tik, dateStr, method);
        }

        public static void main(String[] args) {
            StdLogger stdLogger = new StdLogger();
            for (int i = 0; i <10  ; i++) {
                stdLogger.log("test");


            }

        }

    }
