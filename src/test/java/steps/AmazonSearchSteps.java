package steps;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.AmazonSearchPage;



public class AmazonSearchSteps {

    
    AmazonSearchPage amazon = new AmazonSearchPage();

    @Given("^The user navigates to www.amazon.com$")
    public void navigatesToAmazon() {
        amazon.navigateToAmazon();
    }

    @And("^searches for (.+)$")
    public void searchForProduct(String criteria) {
        amazon.entersearchForCriteria(criteria);
        amazon.clickSearch();
    }

    @And("^navigates to the page number (.+)$")
    public void navigateToSecondPage(String pageNumber) {
        amazon.goToPage(pageNumber);
    }

    @And("^selects the third item$")
    public void selectThirdItem() {
        amazon.pick3rdItem();
    }

    @Then("^the user is able to add it to the cart$")
    public void itemCanBeAddedToCart() {
        amazon.addToCart();
        Assert.assertEquals("Agregado al carrito", amazon.addedToCartMessage());
    }
    
}
