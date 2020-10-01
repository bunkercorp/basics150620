package main;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        if (args.length > 0) {
            System.out.println("Arguments");
            for (String arg : args) System.out.println("\t" + arg);
        }
        final Map<Object, Object> jvmProps = System.getProperties();
        if (!jvmProps.isEmpty()) {
            System.out.println("JVM props");
            jvmProps.forEach((key, value) -> System.out.printf("\t%s=%s\n", key, value));
        }
    }
}
