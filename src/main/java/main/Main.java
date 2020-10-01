package main;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws MalformedURLException {
        if (args.length > 0) {
            System.out.println("Arguments");
            for (String arg : args) System.out.println("\t" + arg);
        }
        final Map<Object, Object> jvmProps = System.getProperties();
        if (!jvmProps.isEmpty()) {
            System.out.println("JVM props");
            jvmProps.forEach((key, value) -> System.out.printf("\t%s=%s\n", key, value));
        }
        final String browserName = System.getProperty("browser");
        Capabilities caps = new ChromeOptions();
        System.out.println(caps.getBrowserName());
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.2.69:4444/wd/hub"), caps);

        driver.get("https://google.com.ua");
    }
}
