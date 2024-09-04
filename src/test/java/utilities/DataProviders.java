package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	//DataProvider 1
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException{
		String path=".\\testData\\testdata.xlsx";
		ExcelUtility xlutil = new ExcelUtility(path);
		
		int totalrows=xlutil.getRowCount("Login");
		int totalcols=xlutil.getCellCOunt("Login", 1);
		
		String logindata [][]=new String [totalrows][totalcols];
		for(int i=1;i<=totalrows;i++)
		{
			for(int j=0;j<totalcols;j++) {
				logindata[i-1][j] =xlutil.getCellData("Login", i, j);
			}
		}
		
		
		return logindata;
		
	}
	
	
	
	
	
	
	
	
}
