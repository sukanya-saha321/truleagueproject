package utilities;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PopUpHandler {

    private WebDriver driver;
    private WebDriverWait wait;

    public PopUpHandler(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void handlePopUp() {
        try {
            // Wait for the pop-up to be visible
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Please wait while server request completes']/ancestor::div/descendant::div[text()='WARNING']")));

            System.out.println("popup appearaed...!!");
            // Perform action to close the pop-up
            WebElement closeButton = driver.findElement(By.xpath("//div[text()='Please wait while server request completes']/ancestor::div/center/input"));
            closeButton.click();
            System.out.println("click on close button");
        } catch (NoSuchElementException e) {
            // Handle cases where elements are not found
        } catch (Exception e) {
            // Handle any other exceptions, including TimeoutException
        }
    }
}
