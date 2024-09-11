package loginTests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import baseTest.BaseTest;

public class Successfull_login_test extends BaseTest{
	@Test
	public void loginWithCredential() {
		test = extent.createTest("Verify successful login");
		Actions action=new Actions(driver);
		WebElement email=driver.findElement(By.xpath(login.getProperty("email")));
		action.click(email)
	    .keyDown(Keys.CONTROL)
	    .sendKeys("a")
	    .keyUp(Keys.CONTROL)
	    .sendKeys(Keys.BACK_SPACE)
	    .build()
	    .perform();
		email.sendKeys("mahimayadowansi@gmail.com");
		test.log(Status.INFO, "Email entered");
		
		WebElement password=driver.findElement(By.xpath(login.getProperty("password")));
		action.click(password)
		.keyDown(Keys.CONTROL)
		.sendKeys("a")
		.keyUp(Keys.CONTROL)
		.sendKeys(Keys.BACK_SPACE)
		.build().perform();
		password.sendKeys("Mahima123@");
		test.log(Status.INFO, "Password entered");
		
		WebElement login_btn=driver.findElement(By.xpath(login.getProperty("login_btn")));
		login_btn.click();
		test.log(Status.INFO, "Clicked on Login button");
		
		WebElement profile_img=driver.findElement(By.xpath(login.getProperty("image")));
		Assert.assertTrue(profile_img.isDisplayed(), "image not displayed");
		test.log(Status.PASS, "Login successful and profile image is displayed.");
		
		}
	

}
