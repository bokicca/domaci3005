import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Domaci3005 {
    /*
    Otići na http://www.strela.co.rs/, kliknuti na dugme Prodavnica u headeru,
     izabrati opciju Lukovi - Bows iz leve navigacije, potom kliknuti na luk koji se zove Samick Sage,
     i onda proveriti da ime tog luka na njegovoj stranici zaista sadrži reč Samick.
     */
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Intel\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("http://www.strela.co.rs/");
        WebElement shop = driver.findElement(By.xpath("//*[@id=\"ctl00_RadMenu1\"]/ul/li[2]/a/span/strong"));
        shop.click();
        WebElement bows = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_GrupeRadTreeView\"]/ul/li[1]/div/span[3]"));
        bows.click();
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ctl00_MainContent_ListView1_ctrl35_Label3\"]")));
        WebElement samickSage = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_ListView1_ctrl35_Panel1\"]/figure/a/img"));
        samickSage.click();

        WebElement element = driver.findElement(By.id("ctl00_MainContent_ItemListView_ctrl0_ItemNazivLabel"));

        if(element.getText().contains("Samick")){
            System.out.println("Ime luka je Samick.");
        }
        driver.close();


    }
}
