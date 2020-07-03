package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
	public String getexcel(int row, int col) throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("/home/avkolte/eclipse-workspace/edx-automation/src/main/java/resources/config.properties");
		prop.load(fis);
		String input1 =null;
		FileInputStream input = new FileInputStream(prop.getProperty("readExcel"));
		XSSFWorkbook wb =new XSSFWorkbook(input);
		XSSFSheet s1 = wb.getSheetAt(0);
		String s=s1.getRow(row).getCell(col).getStringCellValue();
        input1=s;
		
        return input1;
	}

}
