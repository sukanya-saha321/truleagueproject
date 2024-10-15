package helper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import dataProvider.ConfigFileReader;

public class XpathHelper {
	private WebDriver driver;
	Logger Log = LogManager.getLogger(WaitHelper.class.getName());
	ConfigFileReader configFileReader = new ConfigFileReader();
	// wait helper constrcutor
	public XpathHelper(WebDriver driver) {
		this.driver = driver;
		
	}

	public String getXPath(WebDriver driver, WebElement element) {
        return (String) ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript("function getPathTo(element) {" +
                        "  var stack = [];" +
                        "  while (element.parentNode !== null) {" +
                        "    stack.unshift(" +
                        "      element.tagName + " +
                        "      (element.id ? '[@id=\"' + element.id + '\"]' : '')" +
                        "    );" +
                        "    element = element.parentNode;" +
                        "  }" +
                        "  return stack.join('/');" +
                        "}" +
                        "return getPathTo(arguments[0]);", element);
    }
}

