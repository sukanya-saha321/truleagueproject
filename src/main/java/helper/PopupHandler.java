package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import pageobjects.CommonElementsObj;

import java.time.Duration;
import java.util.NoSuchElementException;

public class PopupHandler {

    WebDriver driver;
    WebDriverWait wait;
    CommonElementsObj commonElementsObj;

    // Constructor to initialize WebDriver and WebDriverWait
    public PopupHandler(WebDriver driver, int timeoutInSeconds) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        this.commonElementsObj = new CommonElementsObj(driver);
    }

    // Method to wait for and handle different popups
    public void handlePopup() {
        try {
            if (isPopupVisible("//div[@class = 'jMsgbox-titleWrap' and contains(text(), 'CONFIRM')]", 3)) {
                handleConfirmPopup();
            } else if (isPopupVisible("//div[@class = 'jMsgbox-titleWrap' and contains(text(), 'warning')]", 3)) {
                handleWarningPopup();
            } else if (isPopupVisible("//div[@class = 'jMsgbox-titleWrap' and contains(text(), 'Cannot Proceed')]", 3)) {
                handleCannotProceedPopup();
            } else if (isPopupVisible("//div[@class = 'jMsgbox-titleWrap' and contains(text(), 'INFORMATION')]", 3)) {
                handleInformationPopup();
            } else if (isPopupVisible("//div[@class = 'jMsgbox-titleWrap' and contains(text(), 'ERROR')]", 3)) {
                handleErrorPopup();
            } else if (isPopupVisible("//div[@class = 'jMsgbox-titleWrap' and contains(text(), 'Success')]", 3)) {
                handleSuccessPopup();
            }
        } catch (Exception e) {
            System.out.println("No popup detected within the specified timeout.");
        }
    }

    private boolean isPopupVisible(String xpath, int timeoutInSeconds) {
        try {
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
            shortWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private void handleConfirmPopup() {
        System.out.println("Handling Confirm popup...");
        clickElement(commonElementsObj.iisConfirmOkButton());
    }

    private void handleWarningPopup() {
        System.out.println("Handling Warning popup...");
        clickElement(commonElementsObj.iisOkButton());
    }

    private void handleCannotProceedPopup() {
        System.out.println("Handling Cannot Proceed popup...");
        clickElement(commonElementsObj.iisOkButton());
        Assert.fail();
    }

    private void handleInformationPopup() {
        System.out.println("Handling Information popup...");
        clickElement(commonElementsObj.iisOkButton());
    }

    private void handleErrorPopup() {
        System.out.println("Handling Error popup...");
        clickElement(commonElementsObj.iisOkButton());
        Assert.fail();
    }

    private void handleSuccessPopup() {
        System.out.println("Handling Success popup...");
        clickElement(commonElementsObj.iisOkButton());
        Assert.fail();
    }

    private void clickElement(WebElement element) {
        for (int i = 0; i < 3; i++) { // Reduced retry attempts to 3
            try {
                wait.until(ExpectedConditions.elementToBeClickable(element));
                element.click();
                System.out.println("Element clicked.");
                return;
            } catch (Exception e) {
                System.out.println("Attempt " + i + " failed.");
                if (i == 2) { // Check if the last attempt
                    System.out.println("Failed to click the element.");
                    Assert.fail();
                }
                try {
                    // Adding a short wait between retries to avoid spamming
                    Thread.sleep(100); // Shortened wait time to 100 milliseconds
                } catch (InterruptedException interruptedException) {
                    Thread.currentThread().interrupt();
                    Assert.fail("Thread interrupted");
                }
            }
        }
    }
    
    public void handleUndefinedOKPopup() {
    	    int maxAttempts = 10; // Maximum attempts to find and click the popup
    	    int attempts = 0; // Initialize attempt counter

    	    while (attempts < maxAttempts) {
    	        try {
    	            // Attempt to find the popup element
    	            WebElement okPopup = driver.findElement(By.xpath("//input[@id='_popup_path_sol_ok']"));
    	            
    	            // Check if the popup is displayed
    	            if (okPopup.isDisplayed()) {
    	                okPopup.click(); // Click the popup
    	                attempts = 0; // Reset attempts since we successfully clicked the popup
    	            } else {
    	                break; // Exit if the popup is not displayed
    	            }
    	        } catch (NoSuchElementException e) {
    	            // If the popup is not found, log the exception (optional)
    	            break; // Exit loop if the popup element is not found
    	        } catch (ElementNotInteractableException e) {
    	            // Handle case where the element is not clickable (optional)
    	            break; // Exit loop if the popup is not interactable
    	        } catch (Exception e) {
    	            // Handle any other exceptions that may arise (optional)
    	            //e.printStackTrace(); // Log the exception for debugging
    	            break; // Exit loop on unexpected exceptions
    	        }

    	        attempts++; // Increment attempt counter
    	    }
    	

    }
}
