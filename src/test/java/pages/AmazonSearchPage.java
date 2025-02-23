package pages;


public class AmazonSearchPage extends BasePage {


    private String searchBox = "//input[@id='twotabsearchtextbox']";
    private String searchButton = "//input[@id='nav-search-submit-button']";
    private String thirdResult = "(//div[@data-component-type='s-search-result'])[3]//a[contains(@class, 'a-link-normal')]";
    private String addToCartButton = "//input[@id='add-to-cart-button-ubb']";
    private String addedMessageText = "//*[contains(text(),'Agregado al carrito')]";

    public AmazonSearchPage() {
        super(driver);
    }

    public void navigateToAmazon() {
        navigateTo("https://www.amazon.com/");
    }

    public void entersearchForCriteria(String criteria) {
        write(searchBox, criteria);
    }

    public void clickSearch() {
        clickElement(searchButton);
    }

    public void goToPage(String pageNumber) {
        goToLinkText(pageNumber);
    }

    public void pick3rdItem() {
        clickElement(thirdResult);
    }

    public void addToCart() {
        clickElement(addToCartButton);
    }

    public String addedToCartMessage() {
        return textFromElement(addedMessageText);
    }
    
}
