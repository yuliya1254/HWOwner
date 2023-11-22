package tests;

import com.codeborne.selenide.Configuration;
import configs.WebBrowserConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeEach;


public class TestBase {

    @BeforeEach
    public void beforeAllCase() {
        WebBrowserConfig webBrowserConfig = ConfigFactory.create(WebBrowserConfig.class, System.getProperties());
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.browser = webBrowserConfig.browserName();
        Configuration.browserVersion = webBrowserConfig.browserVersion();
        Configuration.browserSize = webBrowserConfig.browserSize();
        if (webBrowserConfig.isRemote()) {
            Configuration.remote = webBrowserConfig.remoteURL();
        }


    }
}

