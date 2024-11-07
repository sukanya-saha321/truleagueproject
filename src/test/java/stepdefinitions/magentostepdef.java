package stepdefinitions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import helper.Selenium_Actions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageobjects.magentopageobjects;
import resources.BaseClass;

public class magentostepdef extends BaseClass {
	
	
	magentopageobjects magentopageobjects = new magentopageobjects(driver);
	Selenium_Actions selenium_Actions = new Selenium_Actions(driver);
@Given("Navigate to mangentotestingboard homepage")
public void Navigate_to_mangentotestingboard_homepage() {
	driver.get("https://magento.softwaretestingboard.com/");	
	driver.manage().window().maximize();
	
	
	}
@And("Click on the createAccount on mangentotestingboard homepage")
public void Click_on_the_createAccount_on_mangentotestingboard_homepage() throws InterruptedException {
	selenium_Actions.getWaitHelper().waitForElementwithFluentwait(driver, magentopageobjects.getcreateAnAccount());
	selenium_Actions.getClickAndActionsHelper().moveToElement(magentopageobjects.getcreateAnAccount());
	selenium_Actions.getClickAndActionsHelper().clickOnElement(magentopageobjects.getcreateAnAccount());
	
	
}
@And("Enter the FirstName createAccount on mangentotestingboard homepage")
public void Enter_the_FirstName_createAccount_on_mangentotestingboard_homepage()  {
	selenium_Actions.getWaitHelper().waitForElementwithFluentwait(driver, magentopageobjects.getFirstName());
	selenium_Actions.getJavascriptHelper().scrollIntoView(magentopageobjects.getFirstName());
	selenium_Actions.getClickAndActionsHelper().clickOnElement(magentopageobjects.getFirstName());
	
	magentopageobjects.getFirstName().sendKeys("Sukanya",Keys.TAB);
	
}
@And("Enter the LastName createAccount on mangentotestingboard homepage")
public void Enter_the_LastName_createAccount_on_mangentotestingboard_homepage()  {
	selenium_Actions.getWaitHelper().waitForElementwithFluentwait(driver, magentopageobjects.getLastName_Input());
	selenium_Actions.getClickAndActionsHelper().moveToElement(magentopageobjects.getLastName_Input());
	selenium_Actions.getClickAndActionsHelper().clickOnElement(magentopageobjects.getLastName_Input());
	
	magentopageobjects.getLastName_Input().sendKeys("Saha",Keys.TAB);
	
}
@And("Enter the Email createAccount on mangentotestingboard homepage")
public void Enter_the_mail_createAccount_on_mangentotestingboard_homepage()  {
	selenium_Actions.getWaitHelper().waitForElementwithFluentwait(driver, magentopageobjects.getEmail_Input());
	selenium_Actions.getClickAndActionsHelper().moveToElement(magentopageobjects.getEmail_Input());
	selenium_Actions.getClickAndActionsHelper().clickOnElement(magentopageobjects.getEmail_Input());
	
	magentopageobjects.getEmail_Input().sendKeys("sukanyasaha282@gmail.com",Keys.TAB);
	
	
}
@And("Enter the Password createAccount on mangentotestingboard homepage")
public void Enter_the_Password_createAccount_on_mangentotestingboard_homepage()  {
	selenium_Actions.getWaitHelper().waitForElementwithFluentwait(driver, magentopageobjects.getPassword_Input());
	selenium_Actions.getClickAndActionsHelper().moveToElement(magentopageobjects.getPassword_Input());
	selenium_Actions.getClickAndActionsHelper().clickOnElement(magentopageobjects.getPassword_Input());
	
	magentopageobjects.getPassword_Input().sendKeys("magento#123",Keys.TAB);
	
	
}
@And("Enter the ConfirmPassword createAccount on mangentotestingboard homepage")
public void Enter_the_ConfirmPassword_createAccount_on_mangentotestingboard_homepage()  {
	selenium_Actions.getWaitHelper().waitForElementwithFluentwait(driver, magentopageobjects.getConfirmPassword_Input());
	selenium_Actions.getClickAndActionsHelper().moveToElement(magentopageobjects.getConfirmPassword_Input());
	selenium_Actions.getClickAndActionsHelper().clickOnElement(magentopageobjects.getConfirmPassword_Input());
	
	magentopageobjects.getConfirmPassword_Input().sendKeys("magento#123",Keys.TAB);
	
	
}
@And("Click on createAnAccount button createAccount on mangentotestingboard homepage")
public void Click_on_createAnAccount_button_createAccount_n_mangentotestingboard_homepage()  {
	selenium_Actions.getWaitHelper().waitForElementwithFluentwait(driver, magentopageobjects.createAnAccountBtn());
	selenium_Actions.getJavascriptHelper().scrollIntoView(magentopageobjects.createAnAccountBtn());
	selenium_Actions.getClickAndActionsHelper().clickOnElement(magentopageobjects.createAnAccountBtn());
	
	
	
	
}
@And("Click on SignOut on mangentotestingboard homepage")
public void Click_on_SignOut_on_angentotestingboard_homepage()  {
	selenium_Actions.getWaitHelper().waitForElementwithFluentwait(driver, magentopageobjects.getActionSwitch_DrpDwn());
	selenium_Actions.getClickAndActionsHelper().moveToElement(magentopageobjects.getActionSwitch_DrpDwn());
	selenium_Actions.getClickAndActionsHelper().clickOnElement(magentopageobjects.getActionSwitch_DrpDwn());
	selenium_Actions.getWaitHelper().waitForElementwithFluentwait(driver, magentopageobjects.getSignOut_Link());
	selenium_Actions.getClickAndActionsHelper().moveToElement(magentopageobjects.getSignOut_Link());
	selenium_Actions.getClickAndActionsHelper().clickOnElement(magentopageobjects.getSignOut_Link());
	
	
	
	
}
@Then("Click on signIn on mangentotestingboard homepage")
public void Click_on_signIn_on_mangentotestingboard_homepage() {
	selenium_Actions.getWaitHelper().waitForElementwithFluentwait(driver, magentopageobjects.getSignIn_Link());
	selenium_Actions.getClickAndActionsHelper().moveToElement(magentopageobjects.getSignIn_Link());
	selenium_Actions.getClickAndActionsHelper().clickOnElement(magentopageobjects.getSignIn_Link());
	
}
@Then("Enter the Email signIn on mangentotestingboard homepage")
public void Enter_the_Email_signIn_on_mangentotestingboard_homepage() {
	selenium_Actions.getWaitHelper().waitForElementwithFluentwait(driver, magentopageobjects.signInEmail());
	selenium_Actions.getJavascriptHelper().scrollIntoView(magentopageobjects.signInEmail());
	selenium_Actions.getClickAndActionsHelper().clickOnElement(magentopageobjects.signInEmail());
	magentopageobjects.signInEmail().sendKeys("sukanyasaha282@gmail.com",Keys.TAB);
	
}
@And("Enter the Password signIn on mangentotestingboard homepage")
public void Enter_the_Password_signIn_on_mangentotestingboard_homepage() {
	selenium_Actions.getWaitHelper().waitForElementwithFluentwait(driver, magentopageobjects.signInPassword_Input());
	selenium_Actions.getClickAndActionsHelper().moveToElement(magentopageobjects.signInPassword_Input());
	selenium_Actions.getClickAndActionsHelper().clickOnElement(magentopageobjects.signInPassword_Input());
	magentopageobjects.signInPassword_Input().sendKeys("magento#123",Keys.TAB);
	
}
@And("Click on SignIn button signIn on mangentotestingboard homepage")
public void Click_on_SignIn_button_signIn_on_mangentotestingboard_homepage() {
	selenium_Actions.getWaitHelper().waitForElementwithFluentwait(driver, magentopageobjects.SignIn_Btn());
	selenium_Actions.getClickAndActionsHelper().moveToElement(magentopageobjects.SignIn_Btn());
	selenium_Actions.getClickAndActionsHelper().clickOnElement(magentopageobjects.SignIn_Btn());
	 
	
}
@And("User verify the account is signIn or not")
public void User_verify_the_account_is_signIn_or_not() {
	selenium_Actions.getWaitHelper().waitForElementwithFluentwait(driver, magentopageobjects.WelcomeLogo());
	selenium_Actions.getClickAndActionsHelper().moveToElement(magentopageobjects.WelcomeLogo());
	String At=magentopageobjects.WelcomeLogo().getText();
	String Et = "Welcome, Sukanya Saha!";
	if(At.equals(Et)) {
		System.out.println("Verified");
	}
	else {
		Assert.fail();
	}
}
	

}
