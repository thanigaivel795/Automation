package generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
@Listeners(Result.class)
public abstract class BaseTest implements IAutoConst{
	public WebDriver driver;
	public String url=Utility.getProperty(CONFIG_PATH,"URL");
	String ITO=Utility.getProperty(CONFIG_PATH, "ITO");
	public long dur=Long.parseLong(ITO);
	static
	{
		System.setProperty(chrome_key,chrome_value);
		System.setProperty(gecko_key,gecko_value);

	}
	@BeforeMethod
	public void openApplication() {
		 driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(dur, TimeUnit.SECONDS);
		driver.get(url);
	}
	@AfterMethod
	public void closeApplication() {
		driver.close();
	}

}
