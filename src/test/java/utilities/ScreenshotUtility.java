package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtility {
	 public static String captureScreenshot(WebDriver driver, String screenshotName) {
	        String timestamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
	        String destinationPath = System.getProperty("user.dir") + "/screenshots/" + screenshotName + "loginTest" + timestamp + ".png";
	        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        
	        try {
	            FileUtils.copyFile(screenshot, new File(destinationPath));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return destinationPath;
	    }

}
