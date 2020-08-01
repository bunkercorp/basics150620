public class Main {
    public static void main(String[] arg){
        for(int i = 0 ; i < 10;i++) {
            StdLogger log = new StdLogger("Test");
           System.out.println(log.stringgen());
        }
    }
}

