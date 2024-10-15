package dataProvider;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.testng.Assert;

public class ExcelData {
	private String TestDataSheetName;
	private String TestDataColumnName;
	private ExcelReader reader;

	public ExcelData(String FileName, String TestDataSheetName, String TestDataColumnName) {
		this.TestDataSheetName = TestDataSheetName;
		this.TestDataColumnName = TestDataColumnName;
		reader = new ExcelReader(FileName);
	}

	public Map<String, String> getTestdata(String DataSetID) {
		Map<String, String> testdata = new LinkedHashMap<String, String>();
		// int rowCount = reader.getRowCount(TestDataSheetName);
		int columnCount = reader.getColumnCount(TestDataSheetName);
		// System.out.println(rowCount+" "+columnCount);
		int cellRowNum = reader.getCellRowNum(TestDataSheetName, TestDataColumnName, DataSetID);
		ZipSecureFile.setMinInflateRatio(0);
		// System.out.println(cellRowNum);

		for (int j = 1; j <= columnCount; j++) {
			String key = reader.getCellData(TestDataSheetName, j, 1);
			String value = reader.getCellData(TestDataSheetName, j, cellRowNum);
			if (value.contains(".0")) {
				String[] split = value.split("[.]");
				value = split[0];
			}
			testdata.put(key, value);
			if (testdata.containsValue("")) {
				testdata.remove(reader.getCellData(TestDataSheetName, j, 1));
			}
		}
		return testdata;

		// System.out.println(testdata);
		// System.out.println(testdata.get("AssetModelType"));
	}

	public void updateTestData(String DataSetID, String ColumnName, String TestDataValue) {
		ZipSecureFile.setMinInflateRatio(0);

		if (reader.isSheetExist(TestDataSheetName)) {
			int cellRowNum = reader.getCellRowNum(TestDataSheetName, TestDataColumnName, DataSetID);
			reader.setCellData(TestDataSheetName, ColumnName, cellRowNum, TestDataValue);
		} else {
			Assert.fail("Sheet " + TestDataSheetName + " is not exist");
		}

	}
	

	public void updateTestData2(String[] dataSetIDs, String columnName, String testDataValue) {
	    ZipSecureFile.setMinInflateRatio(0);

	    if (reader.isSheetExist(TestDataSheetName)) {
	        for (String dataSetID : dataSetIDs) {
	            int cellRowNum = reader.getCellRowNum(TestDataSheetName, TestDataColumnName, dataSetID);
	            reader.setCellData(TestDataSheetName, columnName, cellRowNum, testDataValue);
	        }
	    } else {
	        Assert.fail("Sheet " + TestDataSheetName + " does not exist");
	    }
	}


	public void copyAndAppendData(String existingDataSetID, String newDataSetID) {
        ZipSecureFile.setMinInflateRatio(0);

        if (reader.isSheetExist(TestDataSheetName)) {
            // Locate the existing row
            int existingRowNum = reader.getCellRowNum(TestDataSheetName, TestDataColumnName, existingDataSetID);
            // Locate the new row
            int newRowNum = reader.getCellRowNum(TestDataSheetName, TestDataColumnName, newDataSetID);

            // Get the column count
            int columnCount = reader.getColumnCount(TestDataSheetName);

            // Copy data from the existing row to the new row
            for (int j = 1; j <= columnCount; j++) {
                String value = reader.getCellData(TestDataSheetName, j, existingRowNum);
                reader.setCellData(TestDataSheetName, reader.getCellData(TestDataSheetName, j, 1), newRowNum, value);
            }

            System.out.println("Data copied and appended successfully from row " + existingRowNum + " to row " + newRowNum);
        } else {
            Assert.fail("Sheet " + TestDataSheetName + " does not exist");
        }
    }
}
