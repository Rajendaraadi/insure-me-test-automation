 package org.test.insureme;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
public class App 
{
    public static void main( String[] args ) throws InterruptedException, IOException
    {
        
        System.out.println( "Script started" );
      //initializing web driver
      System.setProperty("webdriver.chrome.driver", "/user/bin/chromedriver");
      WebDriverManager.chromedriver().setup();
        //setting up properties -chrome options
      ChromeOptions chromeOptions= new ChromeOptions();
      chromeOptions.addArguments("--headless");
      //open url
      System.out.println("Driver opening up the url in browser");
      WebDriver driver = new ChromeDriver(chromeOptions);
      //driver.get("http://localhost:8081/contact.html");
      driver.get("http://65.2.39.10:8081/contact.html");
      //http://65.2.57.178:8081/
      //http://13.127.102.100:8081/
      //http://localhost:8081/contact.html
      //wait to load page 
      driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
      //System.out.println( "opening browser" );
      //enter details
      System.out.println( "Entering details in the form" );      
      // email
      driver.findElement(By.id("inputName")).sendKeys("Rajendar");      
      //password      
      driver.findElement(By.id("inputNumber")).sendKeys("9999999999");
      Thread.sleep(3000);    
      driver.findElement(By.id("inputMail")).sendKeys("admin@admin.com");
      Thread.sleep(3000);  
      driver.findElement(By.id("inputMessage")).sendKeys("hello");
      Thread.sleep(6000);  
      //click login button
      
      
      
      driver.findElement(By.id("my-button")).click();  
      Thread.sleep(6000);  
      String response= driver.findElement(By.id("response")).getText();
      System.out.println(response);
      System.out.println("test scripts executed" );
      
      TakesScreenshot srcShot=((TakesScreenshot)driver);
      File srcFile = srcShot.getScreenshotAs(OutputType.FILE);
      //File destFile = new File ("/var/lib/jenkins/workspace/insure-me-test-scripts/test-reports.jpg");
      //File destFile = new File ("D:\\videos-staragile\\mod7-capstone\\test-reports.jpg");
      File destFile = new File ("\\var\\lib\\jenkins\\workspace\\insure-me-test-scripts\\test-reports.jpg");
      FileUtils.copyFile(srcFile, destFile);
      
      Thread.sleep(1000); 
      driver.quit();
    /*
     * System.out.println( "Clicking send button" ); Thread.sleep(3000);
     * 
     * String response= driver.findElement(By.id("response")).getText();
     * System.out.println( "checking page.." ); String actual_response=
     * "Message Sent"; if(response.equals(actual_response)) {
     * 
     * System.out.println( "page test Successful" ); } else {
     * System.out.println("page test  fails" ); } Thread.sleep(3000);
     * System.out.println("Successfully completed test case" );
     */
      
    }
}