package com.saucedemo.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.xpath("//*[@id=\"login_button_container\"]/div/form/h3");

    public LoginPage(WebDriver driver){
        super(driver);
    }

    @Override
    public boolean isPageLoaded() {
        return driver.getCurrentUrl().contains("saucedemo");
    }

    //SET Methods
    public void setUsername(String username){
        set(usernameField, username);
    }

    public void setPassword(String password){
        set(passwordField, password);
    }

    public ProductsPage clickLoginButton(){
        click(loginButton);
        return new ProductsPage(driver);
    }

    public ProductsPage logIntoApplication(String username, String password){
        setUsername(username);
        setPassword(password);
        return clickLoginButton();
    }

    public String getErrorMessage(){
        return find(errorMessage).getText();
    }



}
