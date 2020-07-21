
import java.text.SimpleDateFormat;
import java.util.Date;

final class StdLogger extends Logger {
    @Override
    protected void log(String privet) {
        {
            int a = Thread.currentThread().getStackTrace()[1].getLineNumber();
            String date = new SimpleDateFormat("HH:mm:ss.SSS").format(new Date());
            String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
            System.out.printf("%d) %s [%s] %s ",a,date,methodName,privet);
        }
    }
    public static void main(String[] args) {
        StdLogger stdLogger = new StdLogger();
        stdLogger.log("privet");
    }
}
