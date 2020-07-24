import java.text.SimpleDateFormat;
import java.util.Date;

final public class StdLogger implements Logger{
    private static StdLogger instance ;
    int number = 1;
    private  StdLogger(){

    }

    public static StdLogger getInstance(){
        if(instance == null) {
            instance = new StdLogger();
        }
        return instance;
    }
    @Override
    public String log(String s) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss:SSS");
        String date = timeFormat.format(new Date());
        final String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        String str = String.format("%d %s [%s]: %s", number++, date, methodName, s) ;
        return str;
    }

    public static void main(String[] args) {
        StdLogger  instance = getInstance();;
        System.out.println(instance.log("TEST"));
        System.out.println(instance.log("TEST2"));
        System.out.println(instance.log("TEST3"));
    }
}
