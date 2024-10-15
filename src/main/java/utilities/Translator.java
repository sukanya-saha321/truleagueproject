package utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Translator {

    private WebDriver driver;
    private static Map<String, Map<String, String>> translationDictionary = new HashMap<>();

    static {
        try {
            String path = System.getProperty("user.dir") + "\\TestData\\DBQ_IIS_testdata.xlsx";
            initializeTranslations(path, "Languages");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Translator(WebDriver driver) {
        this.driver = driver;
    }

    public static void initializeTranslations(String filePath, String sheetName) throws IOException {
        FileInputStream file = new FileInputStream(new File(filePath));
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheet(sheetName);

        if (sheet == null) {
            throw new IllegalArgumentException("Sheet with name " + sheetName + " does not exist in the provided Excel file.");
        }

        Iterator<Row> rowIterator = sheet.iterator();
        Row headerRow = rowIterator.next(); // Skip header row

        Map<String, Integer> languageColumnMap = new HashMap<>();
        for (Cell cell : headerRow) {
            String language = cell.getStringCellValue().toLowerCase();
            if (!language.equals("english text")) {
                languageColumnMap.put(language, cell.getColumnIndex());
                translationDictionary.put(language, new HashMap<>());
            }
        }

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            String englishText = row.getCell(0).getStringCellValue();

            for (Map.Entry<String, Integer> entry : languageColumnMap.entrySet()) {
                String language = entry.getKey();
                int columnIndex = entry.getValue();
                String translatedText = row.getCell(columnIndex).getStringCellValue();
                translationDictionary.get(language).put(englishText, translatedText);
            }
        }

        workbook.close();
        file.close();
    }

    public String getCurrentLanguage() {
        // Use JavascriptExecutor to execute JavaScript and retrieve the language variable
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Adjust the variable name here to match your actual variable name in the script tag
        String script = "return window.userLangVar || 'unknown';";
        String language = (String) js.executeScript(script);
        return language;
    }

    public String translateText(String text, String language) {
        Map<String, String> translations = translationDictionary.get(language.toLowerCase());
        if (translations != null && translations.containsKey(text)) {
            return translations.get(text);
        } else {
            return "Translation not found";
        }
    }
}
