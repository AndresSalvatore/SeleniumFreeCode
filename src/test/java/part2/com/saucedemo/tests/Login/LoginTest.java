package part2.com.saucedemo.tests.Login;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import part2.com.saucedemo.base.BaseTest;

public class LoginTest extends BaseTest {



   @Test
    public void testLoginErrorMessage(){
        loginPage.setUsername("sadasd");
        loginPage.setPassword("asdasdasd");
        loginPage.clickLoginButton();
        String actualMessage = loginPage.getErrorMessage();
        Assert.assertTrue(actualMessage.contains("Epic sadface"));

    }

    @Test()
    public void testLogin(){
        loginPage.logIntoApplication("standard_user","secret_sauce");
        productsPage.isProductsHeaderDisplayer();
        boolean s= productsPage.isPageLoaded();
        System.out.printf(String.valueOf(s));
        Assert.assertTrue(productsPage.isProductsHeaderDisplayer());


    }



    }








