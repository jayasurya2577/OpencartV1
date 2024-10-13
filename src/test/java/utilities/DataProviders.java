package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

      @DataProvider(name="Login")
      public String[][] loginData() throws IOException{
    	  String path ="./testData//openCart.xlsx";
    	  ExcelUtility xlUtil = new ExcelUtility(path);
    	  
    	  int rowCount = xlUtil.getRowCount("Sheet1");
    	  int columnCount = xlUtil.getCellCount("Sheet1", 1);
    	  String logindata[][] = new String[rowCount][columnCount];
    	  for(int i=1;i<=rowCount;i++) {
    		  for(int j=0;j<columnCount;j++) {
    			  logindata[i-1][j] = xlUtil.getCellData("Sheet1", i, j);
    		  }
    	  }
    	  return logindata;
      }
     }
