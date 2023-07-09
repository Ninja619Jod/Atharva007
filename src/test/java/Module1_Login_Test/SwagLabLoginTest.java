package Module1_Login_Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import LibraryFiles.BaseClass;
import LibraryFiles.UtilityClass;
import Module1_Login.SwagLabHomePage;
import Module1_Login.SwagLabLoginPage;
import Module3_Menu.SwagLabMenuPage;

public class SwagLabLoginTest extends BaseClass
{
	SwagLabLoginPage login;
	SwagLabHomePage home;
	SwagLabMenuPage menu;	
	int TCID;
	
	@BeforeClass
	public void openBrowser() throws EncryptedDocumentException, IOException 
	{		
		initializeBrowser();
		 login=new SwagLabLoginPage(driver);  
		 home=new SwagLabHomePage(driver);
		 menu=new SwagLabMenuPage(driver);
	}
	
	@BeforeMethod
	public void loginToApp() throws InterruptedException, EncryptedDocumentException, IOException
	{
		Thread.sleep(2000);
		login.inpSwagLabLoginPageUsername(UtilityClass.getPFData("UN"));
		login.inpSwagLabLoginPagePassword(UtilityClass.getPFData("PWD"));
		login.clickSwagLabLoginPageLoginBtn();	
		Thread.sleep(1000);
	}
	
	@Test(priority = 1)
	public void verifyLogo() throws InterruptedException 
	{
		Reporter.log("Jai Shree Ram...", true);
		TCID=101;
		Thread.sleep(2000);
		boolean actResult = home.getSwagLabHomePageLogoResult();
		Assert.assertTrue(actResult,"Failed1- act result is false:   ");
		Reporter.log("Jai Shree Ram...", true);
	}
	
	@Test(priority = 2)
	public void verifyAddToCartBtnCovertToRemove() throws InterruptedException, EncryptedDocumentException, IOException
	{
		Reporter.log("Jai Shree Ram...", true);
		Reporter.log("Jai Shree Hanuman...", true);
		TCID=102;
		Thread.sleep(2000);
		home.clickSwagLabHomePageAddToCartBtn();
		Thread.sleep(2000);
		String actResult = home.getSwagLabHomePageRemoveBtn();
		String expResult=UtilityClass.getTD(0, 0);
		
		Thread.sleep(3000);
		
		WebElement rm = home.getRemoveBtn();
		
		if((rm.isDisplayed()))
		{
			
			JavascriptExecutor js = ((JavascriptExecutor)driver);
			js.executeScript("arguments[0].setAttribute('style','border:2px solid red; background:yellow')", rm);
			
		}
		Thread.sleep(3000);
		
		
		Assert.assertEquals(actResult, expResult,"Failed2- both results are diff:  ");
		
		home.getSwagLabHomePageRemoveBtn();
		Reporter.log("My name is Niraj");
		
	}
	
	@AfterMethod
	public void logoutFromApp(ITestResult s1) throws InterruptedException, IOException 
	{
		if(s1.getStatus()==ITestResult.FAILURE)
		{
			Thread.sleep(3000);
			
			WebElement rm = home.getRemoveBtn();
			
		
				
				JavascriptExecutor js = ((JavascriptExecutor)driver);
				js.executeScript("arguments[0].setAttribute('style','border:2px solid red; background:yellow')", rm);
				
			
			Thread.sleep(3000);
			
			UtilityClass.captureSS(driver, TCID);
		}
		home.clickSwagLabHomePageMenuBtn();
		Thread.sleep(2000);
		menu.clickSwagLabMenuPageLogout();
	}
	

	
	
	@AfterClass
	public void closeBrowser() throws InterruptedException
	{		
		Thread.sleep(2000);
		driver.quit();
	}

}
