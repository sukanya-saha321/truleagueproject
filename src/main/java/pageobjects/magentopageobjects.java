package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class magentopageobjects {
WebDriver driver;
	
	public magentopageobjects(WebDriver driver) {
		this.driver = driver ;
		PageFactory.initElements(driver, this);
	}
		
		@FindBy(xpath= "//div[@class='panel header']//a[text()='Create an Account']")
		private WebElement createAnAccount;
		
		public WebElement getcreateAnAccount() {
			return createAnAccount;
		}
		
		@FindBy(xpath="//input[@id='firstname']")
		private WebElement firstName;
		
		public WebElement getFirstName() {
			return firstName;
		}
		
		@FindBy(xpath="//input[@id='lastname']")
		private WebElement lastName;
		
		public WebElement getLastName_Input() {
			return lastName;
		}
		
		@FindBy(xpath="//input[@id='email_address']")
		private WebElement email;
		
		public WebElement getEmail_Input() {
			return email;
		}
		
		@FindBy(xpath="//input[@id='password']")
		private WebElement password;
		
		public WebElement getPassword_Input() {
			return password;
		}
		
		@FindBy(xpath="//input[@id='password-confirmation']")
		private WebElement confirmPassword;
		
		public WebElement getConfirmPassword_Input() {
			return confirmPassword;
		}
		
		@FindBy(xpath="//button[@class='action submit primary']")
		private WebElement createAnAccountBtn;
		
		public WebElement createAnAccountBtn(){
			return createAnAccountBtn;
		}
		
		//After SignUp
		
		@FindBy(xpath="//button[@class='action switch']")
		private WebElement actionSwitch_DrpDwn;
		
		public WebElement   getActionSwitch_DrpDwn() {
			return actionSwitch_DrpDwn;
		}
		
		@FindBy(xpath="//li[@class='authorization-link']//a")
		private WebElement signOut;
		
		public WebElement   getSignOut_Link() {
			return signOut;
		}
		
		@FindBy(xpath="//ul[@class='header links']//li[@class='authorization-link']//a")
		private WebElement signIn;
		
		public WebElement   getSignIn_Link() {
			return signIn;
		}
		
		@FindBy(xpath="//div[@class='control']//input[@id='email']")
		private WebElement signInEmail;
		
		public WebElement   signInEmail() {
			return signInEmail;
		}
		
		@FindBy(xpath="(//div[@class='control']//input[@id='pass'])[1]")
		private WebElement signInPassword;
		
		public WebElement   signInPassword_Input() {
			return signInPassword;
		}
		
		@FindBy(xpath="(//button[@name='send'])[1]")
		private WebElement SignIn_Btn;
		
		public WebElement   SignIn_Btn() {
			return SignIn_Btn;
		}
		@FindBy(xpath="//span[@class='logged-in']")
		private WebElement WelcomeLogo;
		
		public WebElement   WelcomeLogo() {
			return WelcomeLogo;
		}
		
		

}
