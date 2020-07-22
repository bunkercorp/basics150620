package com.hillelhometasks.HWEight;

public class StdLogger extends Logger  {


   private static StdLogger _instance;

    private StdLogger(){}
    public static StdLogger Instance (){
       if (_instance ==null){

           _instance = new StdLogger();
       }
       return _instance;
   }

    public static void main(String[] args) {
        for (int i = 0 ; i<10 ; i ++)
        System.out.println(log);

    }
}

