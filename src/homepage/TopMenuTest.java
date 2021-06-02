package homepage;

import browserTesting.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class TopMenuTest extends BaseTest {

    @Before

    public void verifyUserShouldNavigateToShippingPageSuccessfully() throws InterruptedException{
        String baseurl = "https://mobile.x-cart.com/";

        openBrowser(baseurl);
        clickOnElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/ul[1]/li[3]/a[1]/span[1]"));
        Thread.sleep(3000);
        String expectedShippingText ="Shipping";
        String actualShippingText = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("You are not on Shipping page",expectedShippingText,actualShippingText);
    }
    @Test

    public void verifyUserShoudNagivateToNewPageSuccessfully() throws InterruptedException{

        clickOnElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/ul[1]/li[4]/a[1]/span[1]"));
        Thread.sleep(3000);
        String expectedNewLink = "New arrivals";
        String actualNewLing = getTextFromElement(By.id("page-title"));
        Assert.assertEquals("You are not on New Arrivals page",expectedNewLink,actualNewLing);

    }
    @Test

    public void verifyUserShouldNavigateToComingsoonPageSucessfully(){

        clickOnElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/ul[1]/li[5]/a[1]/span[1]"));
        String expectedComingSoonText = "Coming soon";
        String actualComingSoonText = getTextFromElement(By.xpath("//h1[text()='Coming soon']"));
        Assert.assertEquals("You are not on Coming soon Page",expectedComingSoonText,actualComingSoonText);
    }
    @Test
    public void verifyUserShouldNavigateToContactUsPageSucessfully()throws InterruptedException{

        clickOnElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/ul[1]/li[6]/a[1]/span[1]"));
        Thread.sleep(2000);
        String expectedContactUs = "Contact us";
        String actualContactUs = getTextFromElement(By.xpath("//h1[text()='Contact us']"));
        Assert.assertEquals("You are not on Contact Us Page", expectedContactUs,actualContactUs);
    }


}
