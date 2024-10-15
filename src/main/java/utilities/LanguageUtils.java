package utilities;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class LanguageUtils {
    private WebDriver driver;

    public LanguageUtils(WebDriver driver) {
        this.driver = driver;
    }

    public String getCurrentLanguage() {
        // Use JavascriptExecutor to execute JavaScript and retrieve the language variable
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Adjust the variable name here to match your actual variable name in the script tag
        String script = "return window.userLangVar || 'unknown';";
        String language = (String) js.executeScript(script);
        return language;
    }
}
