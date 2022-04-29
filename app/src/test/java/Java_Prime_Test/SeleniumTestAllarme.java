package Java_Prime_Test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class SeleniumTestAllarme
    {
    private static WebDriver driver;

    @BeforeClass
    public static void setup()
        {
        File chrome = new File("src/test/resources/chromedriver");
        System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
        driver = new ChromeDriver();
        }


    @Test
    public void handleUnsafePasswordAlert()
        {
            driver.get("https://automationintesting.online/#/");

            driver.findElement(By.xpath("//*[@id=\"collapseBanner\"]/div/div[2]/div[4]/ul/li[2]/a")).click();

            WebElement username = driver.findElement(By.xpath("//*[@id='username']"));
            username.sendKeys("admin");

            WebElement password = driver.findElement(By.xpath("//*[@id='password']"));
            password.sendKeys("password");

            driver.findElement(By.xpath("//*[@id='doLogin']")).click();

            // it doesn't seem to be showing...but this is how we would do it
            //change selenium's focus
            Alert alert = driver.switchTo().alert();
            alert.dismiss();

            // switchTo can be used to change the focus between windows as well
            driver.switchTo().window(driver.getWindowHandle());

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }





    @AfterClass
    public static void teardown()
        {
            driver.quit();
        }


    }
