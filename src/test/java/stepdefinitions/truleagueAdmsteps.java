package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import dataProvider.ConfigFileReader;
import io.cucumber.java.en.Given;

public class truleagueAdmsteps {
	WebDriver driver = new ChromeDriver();
	
	ConfigFileReader configFileReader = new ConfigFileReader();
	
	@Given("Navigate to admin URL")
	public void Navigate_to_admin_URL() {
		driver.manage().window().maximize();
		driver.get(configFileReader.gettruleagueApplicationUrl());
		
	}
 
	
}
