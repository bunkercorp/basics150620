package homeworks.hw8;
import java.text.SimpleDateFormat;
import java.util.Date;

abstract class Logger {
    Logger() {
    }
    static int counter=1;
      protected static void  log (String str){
        final String metodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        String dateStr=new SimpleDateFormat("HH:MM:ss:SSS").format(new Date());
        System.out.printf("%d) %s [%s]: %s",counter++, dateStr,metodName, str);

    }
}
