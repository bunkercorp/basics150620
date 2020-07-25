package homeworks.hw7.hw9;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class StdLogger implements Logger{

        private static StdLogger instance;
        int counter = 0;

        private StdLogger() {
        }

        public static StdLogger getInstance() {
            if (instance == null) instance = new StdLogger();
            return instance;
        }

        @Override
        public String log(String str) {
            final String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
            SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss:SSS");
            String date = timeFormat.format(new Date());
            return String.format("%d %s [%s]: %s", counter++, date, methodName, str);
        }
}
