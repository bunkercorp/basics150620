package config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Configuration.*;

public class Code {
        private void setConditionsFirefox() {
            timeout = 10000;
            browser = "Firefox";
            startMaximized = true;
        }

        public void setConfigsFirefox() {
            this.setConditionsFirefox();
        }

        private void setConditionsChrome() {
            timeout = 10000;
            browser = "Chrome";
            startMaximized = true;
        }
        public void setConfigsChrome() {
            this.setConditionsChrome();

    }
}
