package com.proiect.util;

import java.util.Locale;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class OSDetector {

    private static final Logger LOG = LoggerFactory.getLogger(OSDetector.class.getName());

    public static OSType getOs() {
        OSType detectedOS;
        String OS = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);

        if ((OS.contains("mac"))) {
            detectedOS = OSType.MAC_OS;
        } else {
            detectedOS = OSType.WINDOWS;
        }

        LOG.info("Detected OS is {}.", detectedOS);
        return detectedOS;
    }

    public static void setChromeDriver() {
        switch (CommonSteps.getDetectedOs()) {
            case "WINDOWS": {
                System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
                break;
            }
            case "MAC_OS": {
                System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
                break;
            }
        }
    }
}
