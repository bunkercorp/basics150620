package main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
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
        DesiredCapabilities caps;
        if (browserName.contentEquals("chrome")) {
            caps = DesiredCapabilities.chrome();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            caps.setCapability(ChromeOptions.CAPABILITY, options);
        } else {
            caps = DesiredCapabilities.firefox();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--start-maximized");
            caps.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
        }
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.2.69:4444/wd/hub"), caps);
        driver.get("https://google.com.ua");
        Thread.sleep(3000);
        driver.quit();
    }
}
