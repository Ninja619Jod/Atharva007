package Module1_Login;
//pom class 1

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabLoginPage 
{
	//step1: declaration 
	@FindBy(xpath="(//input[@class='input_error form_input'])[1]") private WebElement UN;   // private WebElement UN=driver.findElement(By.xpath(""))
	@FindBy(xpath = "//input[@placeholder='Password']") private WebElement PWD;   // private WebElement pwd=driver.findElement(By.xpath(""))
	@FindBy(xpath = "//input[@class='submit-button btn_action']") private WebElement loginBtn;   // private WebElement loginBtn=driver.findElement(By.xpath(""))
	WebDriver driver1;
	
	//step2: initialization 
	public SwagLabLoginPage(WebDriver driver)
	{
		driver1=driver;
		PageFactory.initElements(driver, this);                 //className.methodname(WebdriverObject, this)
	}
	
	//step3: usage
	public void inpSwagLabLoginPageUsername(String username) 
	{
		UN.sendKeys(username);
	}
	
	public void inpSwagLabLoginPagePassword(String password)
	{
		PWD.sendKeys(password);
	}
	
	public void clickSwagLabLoginPageLoginBtn()
	{
		loginBtn.click();
	}
	
}
