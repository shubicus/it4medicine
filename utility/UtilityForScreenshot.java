package utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;


public class UtilityForScreenshot {

    public static void captureScreenshot(WebDriver webDriver, String screenshotName) {

        try {
            TakesScreenshot takesScreenshot = (TakesScreenshot) webDriver;
            File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(file, new File("./screenshots/" + screenshotName + ".png"));
        } catch (IOException e) {
            System.out.println("OOOpps, you have got some problem in UtilityForScreenshot.class with captureScreenshot method => " + e.getMessage());
        }

    }

}
