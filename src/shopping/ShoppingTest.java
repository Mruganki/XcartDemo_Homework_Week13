package shopping;

import browserTesting.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class ShoppingTest extends BaseTest {
    @Before
    public void openbrowser (){

        String baseurl ="https://mobile.x-cart.com/";
        openBrowser(baseurl);
    }
    @Test
    public void verifyThatUserShouldPlaceOrderSuccessfullyForAvengers()throws InterruptedException{

        mouseHoverToElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/ul[1]/li[2]/span[1]"));//Hot deals link
       // Thread.sleep(3000);
        //click on sales
        driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/ul[1]/li[2]/ul[1]/li[1]/a[1]/span[1]")).click();
        String expectedSalesText = "Sale";
        String actualSalesText = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("You are not on Sales Page", expectedSalesText, actualSalesText);
        //hover on sort by
        mouseHoverToElement(By.xpath("//span[contains(text(),'Recommended')]"));
        //click on Name A - z
        driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[5]/a[1]")).click();
        String expecteNameAlphabatically = "Sort by: Name A - Z";
        String ActuallyNameAlphabatically = getTextFromElement(By.xpath(("//div[@class='list-header']")));
        Assert.assertEquals("Product are not Arranged in Alphabatical order", expecteNameAlphabatically, expecteNameAlphabatically);
        Thread.sleep(2000);
        //click on add to cart button
        clickOnElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/ul[1]/li[1]/div[1]/div[2]/div[4]/div[1]/button[1]"));
       // verify text msg
        String expectedMsg = "Product has been added to your cart";
        String ActualMsg = getTextFromElement(By.xpath("//li[text()='Product has been added to your cart']"));
        Assert.assertEquals("Product has not been added to your cart",expectedMsg,ActualMsg);
        //click on pop up X button
        clickOnElement(By.xpath("//a[@class='close']"));
        clickOnElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[5]/div[4]"));//click on your cart
        Thread.sleep(2000);
        clickOnElement(By.xpath("//a[@class='regular-button cart']"));//click on view cart
        //verify msg on webpage
        String expectedShoppingCart = "Your shopping cart - 1 item";
        String actualshoppingCart = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("Your Item is not added to the cart",expectedShoppingCart,actualshoppingCart);
        // change quntity to 2
        driver.findElement(By.id("amount16")).clear();//delete qty '1'
        Thread.sleep(1000);
        driver.findElement(By.id("amount16")).click();//click on qty
        Thread.sleep(1000);
        driver.findElement(By.id("amount16")).sendKeys("2");//enter qty '2'
        //verify updated shoppigcart msg on url
        String expectedShoppingCartupdated = "Your shopping cart - 2 items";
        String actualshoppingCartupdated = getTextFromElement(By.xpath("//h1[text()='Your shopping cart - 2 items']"));
        Assert.assertEquals("Your cart is not having 2 items",expectedShoppingCartupdated,actualshoppingCartupdated);
        //Verify subtotal
        String expectedSubtotalamt = "Subtotal: $29.98";
        String actualSubTotalAmt = getTextFromElement(By.xpath("//li[@class='subtotal']"));
        Assert.assertEquals("Your Subtoal is wrong",expectedSubtotalamt,actualSubTotalAmt);
        Thread.sleep(2000);
        //verify total
        String expectedtotalamt = "$36.00";
        String actualTotalAmt = getTextFromElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/ul[1]/li[4]/span[1]/span[1]"));
        Assert.assertEquals("Your total cost is wrong",expectedtotalamt,actualTotalAmt);
        //click on go to checkout
        clickOnElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/ul[1]/li[5]/button[1]/span[1]"));
       //verify login page
        String Logintext = "Log in to your account";
        String loginActualText = getTextFromElement(By.xpath("//body[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/h3[1]"));
        Assert.assertEquals("User is not on login accout page",Logintext,loginActualText);
        Thread.sleep(2000);
       //enter email address
        driver.findElement(By.id("email")).sendKeys("wannabuy9@gmail.com");
        //click on continue
        clickOnElement(By.xpath("//button[@class='btn  regular-button anonymous-continue-button submit']"));
        //enter all mandetoryfields
        driver.findElement(By.id("shippingaddress-firstname")).sendKeys("Supergirl");
        driver.findElement(By.id("shippingaddress-lastname")).sendKeys("Always");
        driver.findElement(By.id("shippingaddress-street")).sendKeys("10 Willow row");
        driver.findElement(By.id("shippingaddress-city")).clear();//clear the text which is by default in the textfield
        driver.findElement(By.id("shippingaddress-city")).sendKeys("Manchester");
        //driver.findElement(By.id("shippingaddress-country-code")).clear();
        //selectByvalueFromDropDown(By.id("shippingaddress-country-code"),"GB");// take mandetory as it is
        //driver.findElement(By.id("shippingaddress-state-id")).clear();
        Thread.sleep(2000);
        sendTextToElement(By.id("shippingaddress-custom-state"),"Alwoodly");
        driver.findElement(By.id("shippingaddress-zipcode")).clear();
        sendTextToElement(By.id("shippingaddress-zipcode"),"40012");
        clickOnElement(By.id("create_profile"));
        sendTextToElement(By.id("password"),"wonderful123");
        Thread.sleep(2000);
       // click on delivery#
        mouseHoverToElement(By.id("method128"));
       driver.findElement(By.id("method128")).click();
        //click on payment method
        mouseHoverToElement(By.id("pmethod6"));
        clickOnElement(By.id("pmethod6"));
        Thread.sleep(2000);
        //verify total
        String totalAmt = "$37.03";
        String totalAmtActual = getTextFromElement(By.xpath("//div[@class='total clearfix']"));
        Assert.assertEquals("please check your total amount",totalAmt,totalAmtActual);
        //click on place an order button
        Thread.sleep(2000);
        clickOnElement(By.xpath("//span[text()='Place order: $37.03']"));
        // verify Thank you msg
        String thankuMsg ="Thank you for your order";
        String thankuMsgActual = getTextFromElement(By.id("page-title"));
        Assert.assertEquals("You have not placed an order yet",thankuMsg,thankuMsgActual);
    }
    @Test
    public void verifyThatUserShouldClearShoppingCartSuccessfully() throws InterruptedException{

        mouseHoverToElement(By.xpath("//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[2]/span"));//hover on hotdeals link
        clickOnElement(By.xpath("//*[@id=\"header-area\"]/div[1]/div/div[4]/div/ul/li[2]/ul/li[2]/a/span"));//click on bestseller
        String bestSellerText = "Bestsellers";
        //Verify bestseller
        String bestSellerActual = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("You are not on bestseller page",bestSellerText,bestSellerActual);
        //mouse hover on sort by
        mouseHoverToElement(By.xpath("//span[@class='sort-by-label']"));
       // click on Name A -Z
        clickOnElement(By.xpath("//*[@id=\"XLite-Module-CDev-Bestsellers-View-BestsellersPage-sortby-1\"]/li[4]/a"));
        Thread.sleep(3000);
        //mouse hover on product  “Vinyl Idolz: Ghostbusters”
        mouseHoverToElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/ul[1]/li[6]/div[1]/h5[1]/a[1]"));
        //click on add to basket
        clickOnElement(By.xpath("//button[@class='btn  regular-button add-to-cart product-add2cart productid-13']"));
        // verify pop up msg
        String popupMsg = "Product has been added to your cart" ;
         String popupActualMsg = getTextFromElement(By.xpath("//li[text()='Product has been added to your cart']"));
         Assert.assertEquals("Product has not been added to cart",popupMsg,popupActualMsg);
         //click on X to close the pop up
         clickOnElement(By.xpath("//a[@class='close']"));
         // Click on “Your cart” icon and Click on “View cart” button
        clickOnElement(By.xpath("//div[@title='Your cart']"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//span[text()='View cart']"));
        //verify shopping cart
        String shoppinCartMsg = "Your shopping cart - 1 item";
        String shoppingCartActual = getTextFromElement(By.id("page-title"));
        Assert.assertEquals("Your shopping cart has not been added",shoppinCartMsg,shoppingCartActual);
        // click on empty cart link
        clickOnElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/a[1]"));
        // verify text on alert
        Thread.sleep(2000);
        String alertTextMsg ="Are you sure you want to clear your cart?";
        String alertTextDriver = driver.switchTo().alert().getText();//verify text from non inspected element with right click
        Assert.assertEquals("Cart is not Emptied",alertTextMsg,alertTextDriver);
        //click OK on alert
        Thread.sleep(2000);
        driver.switchTo().alert().accept();// to click 'OK' on alert window when no right click available to inspect
        //verify empty cart green popup bar
        String emptyCartMsg = "Item(s) deleted from your cart";
        String emptyCartActualMsg = getTextFromElement(By.xpath("//li[text()='Item(s) deleted from your cart']"));
        Assert.assertEquals("Your cart is NOT Empty",emptyCartMsg,emptyCartActualMsg);
        //verify your cart is empty text
        Thread.sleep(2000);
        String cartEmptyMsg = "Your cart is empty";
        String cartEmptyActualMsg = getTextFromElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/h1[1]"));
        Assert.assertEquals("Your cart is not empty",cartEmptyMsg,cartEmptyActualMsg);

    }
    @After
    public void tearDown(){
        closedBrowser();

    }





}


