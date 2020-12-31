package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.PublicKey;

public class Base {
    public WebDriver driver=null;
    public Base(WebDriver driver){
        this.driver=driver;
    }

    public Base() {
    }



    public WebDriver chromeDriverConetion(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver= new ChromeDriver();

        return driver;
    }

    public  void type(String inputText, By locator) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 60);

        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(inputText);

        //driver.findElement(locator).sendKeys(inputText);
    }

    public void Click(By locator){
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).click();

        //driver.findElement(locator).click();
    }
    public void esperaListDesplegable(By locator){
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).click();
    }


    public void keyEnter(By locator){
        driver.findElement(locator).sendKeys(Keys.chord(Keys.ENTER));
    }

    public void keyTab(By locator){
        driver.findElement(locator).sendKeys(Keys.chord(Keys.TAB));
    }

    public String obtieneTexto(By locator){
        WebDriverWait wait = new WebDriverWait(driver, 60);
        String elementoTxto=wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
        return elementoTxto;
    }

    public Boolean isDisplayed(By locator) {
        try {
           return  driver.findElement(locator).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
    public void visit(String url){
        driver.get(url);
    }
}

