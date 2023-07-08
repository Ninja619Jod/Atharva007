package Module1_Login;
//pom class 2

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabHomePage 
{
	@FindBy(xpath="//div[@class='app_logo']") private WebElement logo;
	@FindBy(xpath = "//div[@class='bm-burger-button']") private WebElement menuBtn;
	@FindBy(xpath = "//button[@class='btn btn_primary btn_small btn_inventory']") private WebElement addToCart;
	@FindBy(xpath = "//button[@class='btn btn_secondary btn_small btn_inventory']") private WebElement remove;
	
	
	public SwagLabHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean getSwagLabHomePageLogoResult() 
	{
		boolean result = logo.isDisplayed();
		return result;	
	}
	
//	public void verifySwagLabHomePageLogo() 
//	{
//		boolean result = logo.isDisplayed();
//		
//		if(result==true)
//		{
//			System.out.println("Logo found --> TC Pass");
//		}
//		else
//		{
//			System.out.println("Logo not found --> TC Fail");
//		}
//	}
	
	public void clickSwagLabHomePageMenuBtn() 
	{
		menuBtn.click();
	}
	
	public void clickSwagLabHomePageAddToCartBtn() 
	{
		addToCart.click();
	}
	
	public String getSwagLabHomePageRemoveBtn()
	{
		String actText = remove.getText();
		return actText;
	}
	
	public WebElement getRemoveBtn() {
		return remove;
	}
	
//	public void verifySwagLabHomePageRemoveBtn(String expText)
//	{
//		String actText = remove.getText();
//		if(actText.equals(expText))
//		{
//			System.out.println("Pass");
//		}
//		else
//		{
//			System.out.println("Fail");
//		}
//	}

}
