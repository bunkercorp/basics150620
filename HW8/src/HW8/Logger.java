package HW8;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Logger {
    private int counter;

    public Logger() {
    }

    public void log(String text) {
        System.out.printf("%s%s\n", this.logPrefix(), text);
    }

    protected String logPrefix() {
        String methodName = Thread.currentThread().getStackTrace()[3].getMethodName();
        String dateStr = (new SimpleDateFormat("HH:mm:ss:SSS")).format(new Date());
        return String.format("%d) %s [%s]: ", ++this.counter, dateStr, methodName);
    }
}