package php;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class verifysite {

  WebDriver driver;
  @BeforeTest
  public void openapp() {
	  System.setProperty("webdriver.chrome.driver","/var/lib/jenkins/workspace/TestJob/chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("http://35.193.151.202:8083/");
  }
  @Test
  public void verifytext() {
	 driver.findElement(By.xpath("//a[@id='About Us']")).click();
	 String text = driver.findElement(By.xpath("//p[@id='PID-ab2-pg']")).getText();
	 String expected_text = "This is about page. Lorem Ipsum Dipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
	 Assert.assertEquals(text, expected_text);
  }
  
  @AfterTest
  public void closeBrowser() {
	  driver.close();
  }
}
