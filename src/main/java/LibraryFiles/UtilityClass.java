package LibraryFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class UtilityClass
{		
	public static String getPFData(String key) throws IOException
	{
		FileInputStream file=new FileInputStream("C:\\Users\\niraj\\OneDrive\\Desktop\\3rdSeptBEveMaven\\PropertyFile.properties");
		Properties p=new Properties();
		p.load(file);
		String value = p.getProperty(key);
		return value;
	}
	
	
	//@AuthorName: Niraj
	//This method is use to get test data from excel sheet 
	//need to pass 2 inputs:  1-rowIndex  2-cellIndex
	public static  String getTD(int rowIndex,int CellIndex) throws EncryptedDocumentException, IOException
	{
		FileInputStream file=new FileInputStream("C:\\Users\\niraj\\OneDrive\\Desktop\\Swag.xlsx");
		 Sheet sh = WorkbookFactory.create(file).getSheet("Sheet1");
		String value = sh.getRow(rowIndex).getCell(CellIndex).getStringCellValue();
		return value;
	}
		
	
	public static void captureSS(WebDriver driver,int TCIDNumer) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("C:\\Users\\niraj\\OneDrive\\Desktop\\3rdSeptBEveMaven\\FailedTCesSS\\TestCaseID"+TCIDNumer+ ".png");
		FileHandler.copy(src, dest);		
	}

}
