package steps;

import base.AmazonBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;


public class AddToCartStepDefinition extends AmazonBase {
    HomePage homePage = new HomePage();
    String monitorPrice= null;
    String laptopPrice= null;
    @Given("a user enter {string} in search field")
    public void aUserEnterInSearchField(String searchText) {
        homePage.searchTextBox.sendKeys(searchText);
        homePage.searchSubmitButton.click();
    }

    @And("user select the first monitor on the list")
    public void userSelectTheFirstMonitorOnTheList() {
        CommonSteps.waitForElementToBeClickable(homePage.amazonLogo);
        CommonSteps.scrollDownToElement(homePage.clickOnMonitor);
        homePage.clickOnMonitor.click();
    }

    @When("user add item to cart")
    public void userAddItemToCart() {
        CommonSteps.waitForElementToBeClickable(homePage.monitorPrice);
        monitorPrice= CommonSteps.getMonitorPrice();
        System.out.println(monitorPrice);
        CommonSteps.scrollDownToElement(homePage.addToCartButton);
        homePage.addToCartButton.click();
    }

    @Then("the sub total on the Cart is identical to the product page")
    public void theSubTotalOnTheCartIsIdenticalToTheProductPage() {
        CommonSteps.waitForElementToBeClickable(homePage.subTotal);
        String subTextTotal= homePage.subTotal.getText();
        Assert.assertEquals(monitorPrice,subTextTotal);


    }

    @And("user select the second laptop on the list")
    public void userSelectTheSecondLaptopOnTheList() {
        CommonSteps.waitForElementToBeClickable(homePage.amazonLogo);
        CommonSteps.scrollDownToElement(homePage.secondLaptop);
        homePage.secondLaptop.click();
    }

    @When("user add laptop to cart")
    public void userAddLaptopToCart() {
        CommonSteps.waitForElementToBeClickable(homePage.laptopPrice);
        laptopPrice= CommonSteps.getLaptopPrice();
        System.out.println(laptopPrice);
        CommonSteps.scrollDownToElement(homePage.addToCartButton);
        homePage.addToCartButton.click();
    }

    @Then("the laptop sub total on the Cart should be identical to the product page")
    public void theLaptopSubTotalOnTheCartShouldBeIdenticalToTheProductPage() {
        CommonSteps.waitForElementToBeClickable(homePage.laptopSubTotalPrice);
        String laptopSubTotal= homePage.subTotal.getText();

        System.out.println(laptopPrice);
        System.out.println(laptopSubTotal);

        Assert.assertEquals(laptopPrice,laptopSubTotal);
    }
}
