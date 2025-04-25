package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage{

    private final By productsHeader= By.xpath("//div[@class='product_label']");
    private final By addToCartButton = By.xpath("//*[@id='inventory_container']/div/div[1]/div[3]/button");
    private final By removeButton = By.xpath("//*[@id=\'inventory_container\']/div/div[1]/div[3]/button");
    private final By dropDownField = By.xpath("//*[@id=\'inventory_filter_container\']/select");
    private final By redTshirt = By.xpath("//*[@id=\'item_3_title_link\']/div");
    private final By costRedTshirt= By.xpath("//*[@class='inventory_item_price'][1]");


    public ProductsPage(WebDriver driver) {
        super(driver); // Llama al constructor de BasePage y le pasa el driver
    }

    @Override
    public boolean isPageLoaded() {
        return driver.getCurrentUrl().contains("saucedemo");
    }

    public boolean isProductsHeaderDisplayer(){
       return find(productsHeader).isDisplayed();
    }

    public void clickAddtoCartFirstItem(){
        click(addToCartButton);
    }

    public boolean checkIfRemoveButtonwasDisplayed(){
        return find(removeButton).isDisplayed();
    }

    public void orderProductsByZtoA(){
        selectByVisibleText(dropDownField,"Name (Z to A)");
    }

    public boolean areRedTshirtProductAndCostDisplayed(){
        return find(redTshirt).isDisplayed() && find(costRedTshirt).isDisplayed();
    }

    public String costOfRedTshirt(){
        return find(costRedTshirt).getText();
    }








}

