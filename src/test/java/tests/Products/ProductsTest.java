package tests.Products;

import org.testng.Assert;
import org.testng.annotations.Test;
import part2.com.saucedemo.base.BaseTest;

public class ProductsTest extends BaseTest {

    private final String user = "standard_user";
    private final String password = "secret_sauce";

    @Test
    public void testClickAddToCartAndCheckIfRemoveButtonWasDisplayed(){
        loginPage.logIntoApplication(user,password);
        productsPage.clickAddtoCartFirstItem();
        productsPage.checkIfRemoveButtonwasDisplayed();
        Assert.assertTrue(productsPage.checkIfRemoveButtonwasDisplayed());
    }

    @Test
    public void orderProductsByZtoA(){
        loginPage.logIntoApplication(user,password);
        productsPage.orderProductsByZtoA();
        productsPage.areRedTshirtProductAndCostDisplayed();
        Assert.assertTrue(productsPage.areRedTshirtProductAndCostDisplayed());

    }
    @Test
    public void getAndCompareCostOfRedTshirt(){
        loginPage.logIntoApplication(user,password);
        productsPage.orderProductsByZtoA();
        String originalCost = productsPage.costOfRedTshirt();
        String expectedCost = "$15.99";
        Assert.assertEquals(originalCost,expectedCost,"El costo esperado es el correcto:");

    }
}
