import java.util.Date;

public class StdLogger implements Logger {
    String message;
    int id;
    public StdLogger(String m){
        this.message = m;
        this.id = id++;
    }

    @Override
    public String stringgen() {
        String result = new String();
        String date = takeDate();
        String name = takeName();
        return result + Integer.toString(this.id) + " " + date + " " +name + " " + this.message ;
    }

    @Override
    public String takeDate() {
        Date date = new Date();
        return date.toString();
    }

    @Override
    public String takeName() {
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }
}
