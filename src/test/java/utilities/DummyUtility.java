package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DummyUtility {
	
	public static void main(String args[]) throws IOException {
		FileInputStream fl = new FileInputStream("./testData//DataDriven.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fl);
		XSSFSheet sheet = wb.getSheet("Sheet1");
		int lastRow = sheet.getLastRowNum();
		
		Random random = new Random();
		int rowIndex = random.nextInt(lastRow)+1;//last row is my 0th row
		XSSFRow row = sheet.getRow(rowIndex);
		
		for(Cell value:row) {
			System.out.print(value+"\t");
		}
		wb.close();
		fl.close();
	}

}
