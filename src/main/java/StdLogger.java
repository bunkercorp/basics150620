import java.text.SimpleDateFormat;
import java.util.Date;

public final class StdLogger implements Logger{
    private static StdLogger instanse=null;
    int counter=1;
    StdLogger() {
    }

    public static StdLogger getInstance(){
        if (instanse==null){
            instanse=new StdLogger();
        }
        return instanse;
    }
    @Override
            public void  log (String str){
            final String metodName = Thread.currentThread().getStackTrace()[2].getMethodName();
            String dateStr=new SimpleDateFormat("HH:MM:ss:SSS").format(new Date());
            System.out.printf("%d) %s [%s]: %s",counter++, dateStr,metodName, str);

        }
    }

