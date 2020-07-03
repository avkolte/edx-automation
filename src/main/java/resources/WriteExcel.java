package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class WriteExcel {

	public void writeExcel(String[] courses,String[] time) throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("/home/avkolte/eclipse-workspace/edx-automation/src/main/java/resources/config.properties");
		prop.load(fis);
		FileInputStream fin = new FileInputStream(prop.getProperty("writeExcel"));
		XSSFWorkbook workbook = new XSSFWorkbook(fin);
        XSSFSheet sheet = workbook.getSheet("Sheet1");
        sheet.setColumnWidth(0, 80*256);
        sheet.setColumnWidth(1, 50*256);
        Row headerRow = sheet.createRow(0);
        Cell headerCell1 = headerRow.createCell(0);
        Cell headerCell2 = headerRow.createCell(1);
        headerCell1.setCellValue("Course");
        headerCell2.setCellValue("Time");    
        
        int j=0;
		for(int i=1;i<=2;i++)
		{
			
			
			sheet.createRow(i).createCell(0).setCellValue(courses[j]);
			sheet.getRow(i).createCell(1).setCellValue(time[j]);
			j++;
		}



        
        
        
		try {
			fin.close();
			FileOutputStream fout = new FileOutputStream(prop.getProperty("writeExcel"));
			workbook.write(fout);
			fout.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
	
}
    
