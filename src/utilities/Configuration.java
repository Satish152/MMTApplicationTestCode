package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class Configuration {
public static Properties property;
public static int RowCount;
public static XSSFSheet sheet;
	public void LoadConfiguration(){
		property=new Properties();
		File file=new File("H:\\workspace\\ZenqTask\\Configuration\\Config.property");
		
		try {
			FileInputStream fis=new FileInputStream(file);
			property.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void loadExcel(String filePath,String SheetName,int SheetIndex){
		File file=new File(filePath);
		FileInputStream fis;
		try {
			fis = new FileInputStream(file);
			XSSFWorkbook wb=new XSSFWorkbook(fis);
			if(SheetName.equals("")){
			sheet=wb.getSheet(SheetName);
			}else{
				sheet=wb.getSheetAt(SheetIndex);
			}
			RowCount=sheet.getLastRowNum();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@DataProvider(name="TestDataProvider")
	public Object[][] TestData(){
		loadExcel(property.getProperty("TestDataSheetpath"), "Sheet1", 0);
		Object[][] data=new Object[RowCount][5];
		for(int i=1;i<data.length;i++){
			for(int j=0;j<sheet.getRow(i).getLastCellNum();j++){
				data[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
				System.out.println(data[i][j]);
			}
		}
		return data;
	}
}
