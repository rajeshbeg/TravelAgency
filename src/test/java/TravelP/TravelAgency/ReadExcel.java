package TravelP.TravelAgency;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.annotations.Test;

public class ReadExcel {
	String Path="E:\\automation testing\\TestExcel\\TravelAgency.xlsx";
	@Test
	public void ReadTest() throws IOException, ClassNotFoundException{
		FileInputStream fis = new FileInputStream("E:\\automation testing\\TestExcel\\TravelAgency.xlsx");
	
		//Select Work book
		XSSFWorkbook wb= new XSSFWorkbook(fis);
		XSSFSheet sh=wb.getSheetAt(0);
//		System.out.println(sh.getRow(0).getCell(0).getStringCellValue());
		
		ArrayList<String> executTC= new ArrayList<String>();
		
		
		int lastrowNumbersh=sh.getLastRowNum();
		int maxRow=sh.getLastRowNum();
		
		
		for (int rowIndex=1;rowIndex<=maxRow;rowIndex++)
		{
			System.out.println("going from :"+rowIndex+"to the: "+maxRow);
			System.out.println(sh.getRow(rowIndex).getCell(1).toString());
			if(sh.getRow(rowIndex).getCell(1).toString().equals("Y"))
			{
				String execls=	sh.getRow(rowIndex).getCell(2).toString();
				System.out.println("executing the class "+execls);
				

				//Update TestNg
				String clasname = "TravelP.TravelAgency."+execls;
				Class c2 = Class.forName(clasname);
				
				TestListenerAdapter tla = new TestListenerAdapter();
				TestNG testng = new TestNG();
				testng.setTestClasses(new Class[] {c2});
				//testng.setTestClasses(new Class[] {com.qatools.com.QAServent.class});
				testng.addListener(tla); 
				testng.run();
				
				executTC.add(sh.getRow(rowIndex).getCell(0).toString());
			}

		}

		wb.close();
	

	}
}	

