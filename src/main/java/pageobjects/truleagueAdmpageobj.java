package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class truleagueAdmpageobj {

public truleagueAdmpageobj(WebDriver driver) {
	 driver = new ChromeDriver();

	
	PageFactory.initElements(driver, this);
}	
	
@FindBy(xpath="//input[@id='email']")
private WebElement EmailinputAdm;
public WebElement getEmailinputAdm() {
	return  EmailinputAdm;
}
@FindBy(xpath="//input[@id='iagree']")
private WebElement IagreeCheckboxAdm;
public WebElement getIagreeCheckboxAdm() {
	return  IagreeCheckboxAdm;
}
@FindBy(xpath="//input[@id='loginButton']")
private WebElement LoginbtnAdm;
public WebElement geLoginbtnAdm() {
	return  LoginbtnAdm;
}


}
