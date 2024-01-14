package pages;

import base.AmazonBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends AmazonBase {
  @FindBy(css = "a#nav-logo-sprites")
  public WebElement amazonLogo;

  @FindBy(css = " input#twotabsearchtextbox")
  public WebElement searchTextBox;

  @FindBy(css = "button[id='sp-cc-rejectall-link']")
  public WebElement declineCookie;

  @FindBy(id = "nav-search-submit-button")
  public WebElement searchSubmitButton;

  @FindBy(css = "[data-csa-c-pos='1'] .a-size-medium.a-text-normal")
  public WebElement clickOnMonitor;
  @FindBy(name = "submit.add-to-cart")
  public WebElement addToCartButton;

  @FindBy(css = "div#corePrice_feature_div > div .a-price-whole")
  public WebElement monitorPrice;

  @FindBy(css = "#sw-subtotal .a-price-whole")
  public WebElement subTotal;
  @FindBy(css = "[data-csa-c-pos='2'] .a-size-medium.a-text-normal")
  public WebElement secondLaptop;

  @FindBy(css = "[data-feature-name='corePrice'] .a-price-whole")
  public WebElement laptopPrice;

  @FindBy(css = "#sw-subtotal-item-count")
  public WebElement laptopSubTotalPrice;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }
}
