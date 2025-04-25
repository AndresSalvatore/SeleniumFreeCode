package part2.com.saucedemo.base;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public abstract class BaseTest {

protected WebDriver driver;
private ThreadLocal<WebDriver> driverThreadLocal= new ThreadLocal<>();
protected LoginPage loginPage;
protected ProductsPage productsPage;

//non change

public WebDriver getDriver(){
    return driverThreadLocal.get();
}

@BeforeMethod
    public void setUp(){
    final String url = "https://www.saucedemo.com/v1/";
    driverThreadLocal.set(new ChromeDriver());
    driver=getDriver();
    driver.manage().window().maximize();
    driver.get(url);
    loginPage = new LoginPage(driver);
    productsPage = new ProductsPage(driver);
}

@AfterMethod
    public void tearDown(){
    if(getDriver()!=null)
    {
        getDriver().quit();
        driverThreadLocal.remove();
    }


}





}
