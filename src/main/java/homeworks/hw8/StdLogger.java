package homeworks.hw8;

 final class StdLogger extends Logger {
     private static StdLogger instanse = null;
     StdLogger() {
     }
     public static StdLogger getInstance(){
         if (instanse==null){
             instanse=new StdLogger();
         }
         return instanse;
     }
}
