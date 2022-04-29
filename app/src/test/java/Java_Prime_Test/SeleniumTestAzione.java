package Java_Prime_Test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;

public class SeleniumTestAzione
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
    public void totalDramaAction()
        {
            driver.get("https://archiveofourown.org");
            Actions actUp = new Actions(driver);
            WebElement fandomsButton = driver.findElement(By.xpath("//*[@id=\"header\"]/ul/li[1]/a"));
            actUp.moveToElement(fandomsButton).build().perform();

            WebElement anime = driver.findElement(By.xpath("//*[@id=\"medium_5\"]/a"));
            anime.click();

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
