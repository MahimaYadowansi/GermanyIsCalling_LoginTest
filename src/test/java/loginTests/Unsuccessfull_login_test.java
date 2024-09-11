package loginTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import baseTest.BaseTest;

public class Unsuccessfull_login_test extends BaseTest {
	@Test(priority = 1)
	public void unsuccessfull_login()
	{
		test = extent.createTest("Verify unsuccessful login");
		WebElement email = driver.findElement(By.xpath(login.getProperty("email")));
	    WebElement password = driver.findElement(By.xpath(login.getProperty("password")));
	    WebElement loginButton = driver.findElement(By.xpath(login.getProperty("login_btn")));

	    email.clear();
	    password.clear();
	    email.sendKeys("abc@gmail.com");
	    password.sendKeys("1237");
	    loginButton.click();
	    test.log(Status.INFO, "Entered invalid credentials");
	    WebElement errormessage=driver.findElement(By.xpath(login.getProperty("errorMessage")));
	    Assert.assertTrue(errormessage.isDisplayed(), "Error message not displayed!");
	    System.out.println(errormessage.getText());
	}
	
	@Test(priority = 2)
	public void testEmptyFields() {
		test = extent.createTest("Verify login with empty fields");
		WebElement email = driver.findElement(By.xpath(login.getProperty("email")));
	    WebElement password = driver.findElement(By.xpath(login.getProperty("password")));
	    WebElement loginButton = driver.findElement(By.xpath(login.getProperty("login_btn")));

	    email.clear();
	    password.clear();
	    loginButton.click();
	    test.log(Status.INFO, "Clicked login button without entering any credentials");
	    WebElement emptyErrorMessage=driver.findElement(By.xpath(login.getProperty("emptyErrorMessage")));
	    Assert.assertTrue(emptyErrorMessage.isDisplayed(),"Empty fields error message not displayed");
	    test.log(Status.PASS, "Error message displayed for empty fields");
	}
	
	

}
