package util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonHelper {
    /**
     * Capture current screen and return the image path (../report/screenshot/imageXXX.png)
     * @param driver
     * @return
     */
    static public String captureScreenshot(WebDriver driver){
        try{
            String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            String destination = System.getProperty("user.dir") + "/report/screenshot/" + dateName + ".png";
            File finalDestination = new File(destination);
            FileUtils.copyFile(source, finalDestination);
            return destination;
        }catch (Exception e) {
            System.out.println("Could not capture screenshot !");
        }
        return null;
    }
}
