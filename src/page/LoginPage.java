package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	private WebDriver driver;
@FindBy(id="email")
private WebElement un;
@FindBy(id="pass")
private WebElement pw;
public void sendUserName(String un1) {
	un.sendKeys(un1);
   }
public void sendPassWord(String pw1) {
	pw.sendKeys(pw1);
}
}
