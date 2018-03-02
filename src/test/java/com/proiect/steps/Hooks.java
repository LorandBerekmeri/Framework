package com.proiect.steps;

import com.proiect.util.ConfigHelper;
import com.proiect.util.CommonSteps;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

import static com.proiect.util.OSDetector.getOs;
import static com.proiect.util.OSDetector.setChromeDriver;

public class Hooks {

    static String browser = ConfigHelper.INSTANCE.getProperty("browser");
    public static WebDriver driver;
    private static final Logger LOG = (Logger) LoggerFactory.getLogger(Hooks.class);

    @Before(order = 1)
    public void storeOs() {
        CommonSteps.setDetectedOs(getOs().toString());
        LOG.info("Test cases will be executed on the detected {} operating system.", CommonSteps.getDetectedOs());
    }

    @Before("@cucumber-test")
    public static WebDriver getDriver() {
        if (driver == null) {
            synchronized (Hooks.class) {
                if (driver == null) {
                    switch (browser) {
                        case "firefox": {
                            driver = new FirefoxDriver();
                            driver.manage().window().maximize();
                            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
                            LOG.info("FirefoxDriver is started.");
                            break;
                        }
                        case "chrome": {
                            setChromeDriver();
                            driver = new ChromeDriver();
                            driver.manage().window().maximize();
                            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
                            LOG.info("ChromeDriver is started.");
                            break;
                        }
                        case "ie": {
                            System.setProperty("webdriver.ie.driver", "drivers/internetexplorerdriver/IEDriverServer.exe");
                            DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
                            caps.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
                            caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                            caps.setCapability("ignoreZoomSetting", true);
                            driver = new InternetExplorerDriver(caps);
                            driver.manage().window().maximize();
                            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
                            LOG.info("InternetExplorerDriver is started.");
                            break;
                        }
                    }
                }
            }
        }
        return driver;
    }

    @After("@cucumber-test")
    public static void stopDriver(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                scenario.write("Current page URL is: <" + driver.getCurrentUrl() + ">.");
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (WebDriverException e) {
                System.err.println(e.getMessage());
            }
        }
        driver.close();
        DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
        capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
        driver = null;
        LOG.info("Driver is closed.");
    }
}