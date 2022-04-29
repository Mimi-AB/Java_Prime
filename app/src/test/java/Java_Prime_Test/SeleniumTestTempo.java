package Java_Prime_Test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class SeleniumTestTempo
    {
        private static WebDriver driver;

        @BeforeClass
        public static void prima()
            {
            //File safari = new File("/usr/bin/safaridriver");
            //System.setProperty("webdriver.safari.driver", safari.getAbsolutePath());
            //driver = new SafariDriver();

            File chrome = new File("src/test/resources/chromedriver");
            System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
            driver = new ChromeDriver();

            //How long to wait for the page to load
            //driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
            }
        @Test
        public void prove()
            {
                driver.get("https://www.fanfiction.net");

                WebElement aniMan = driver.findElement(By.xpath("//*[@id=\"gui_table1i\"]/tbody/tr[1]/td[1]/a"));

                //Explicit Wait
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
                wait.until(ExpectedConditions.elementToBeClickable(aniMan));

                aniMan.click();
                assertEquals("FanFiction", driver.getTitle());

                try{
                    Thread.sleep(4000);
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        @AfterClass
        public static void dopo()
            {
                driver.quit();
            }
    }
