package hotdeals;

import browserTesting.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import java.util.Base64;

public class HotDealTest extends BaseTest {

    @Before
    public void openbrowser() {
        String baseurl = "https://mobile.x-cart.com/";
        openBrowser(baseurl);
    }

    @Test
    public void verifySalesProductsArrangeAlphabetically() throws InterruptedException {

        mouseHoverToElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/ul[1]/li[2]/span[1]"));
        Thread.sleep(3000);
        driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/ul[1]/li[2]/ul[1]/li[1]/a[1]/span[1]")).click();
        String expectedSalesText = "Sale";
        String actualSalesText = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("You are not on Sales Page", expectedSalesText, actualSalesText);
        mouseHoverToElement(By.xpath("//span[contains(text(),'Recommended')]"));
        driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[5]/a[1]")).click();
        String expecteNameAlphabatically = "Sort by: Name A - Z";
        String ActuallyNameAlphabatically = getTextFromElement(By.xpath(("//div[@class='list-header']")));
        Assert.assertEquals("Product are not Arranged in Alphabatical order", expecteNameAlphabatically, expecteNameAlphabatically);
    }

    @Test
    public void VerifyProductsPriceArrangeLowToHigh() throws InterruptedException {

        mouseHoverToElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/ul[1]/li[2]/span[1]"));
        Thread.sleep(3000);
        driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/ul[1]/li[2]/ul[1]/li[1]/a[1]/span[1]")).click();
        String expectedSaleText = "Sale";
        String actualSalesText = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("You are not on Sale page", expectedSaleText, actualSalesText);
        mouseHoverToElement(By.xpath("//span[contains(text(),'Recommended')]"));
        driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[3]/a[1]")).click();
        String expectedPricetext = "Price Low - High";
        String actualPriceText = getTextFromElement(By.xpath(("//span[text()='Price Low - High']")));
        Assert.assertEquals("Product price is not arranged as low to high", expectedPricetext, actualPriceText);
    }

    @Test
    public void verifySalesProductsArrangeByRates() throws InterruptedException {

        mouseHoverToElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/ul[1]/li[2]/span[1]"));
        Thread.sleep(3000);
        driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/ul[1]/li[2]/ul[1]/li[1]/a[1]/span[1]")).click();
        String expectedSaleText = "Sale";
        String actualSalesText = getTextFromElement(By.xpath("//h1[@id='page-title']"));
        Assert.assertEquals("You are not on Sale page", expectedSaleText, actualSalesText);
        mouseHoverToElement(By.xpath("//span[contains(text(),'Recommended')]"));
        driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[7]/a[1]")).click();
        Thread.sleep(2000);
        String expectedRateText = "Rates";
        String actualRateText = getTextFromElement(By.xpath("//span[text()='Rates ']"));
        Assert.assertEquals("Product Rates is not arranged as expected", expectedRateText, actualRateText);
    }

    @Test
    public void verifyBestSellersProductsArrangeByZToA() throws InterruptedException {
        mouseHoverToElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/ul[1]/li[2]/span[1]"));
        Thread.sleep(3000);
        //Bestseller
        driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/ul[1]/li[2]/ul[1]/li[2]/a[1]/span[1]")).click();
        String expectedSaleText = "Bestsellers";
        String actualSalesText = getTextFromElement(By.xpath("//h1[@id ='page-title']"));
        Assert.assertEquals("You are not on BestSeller page", expectedSaleText, actualSalesText);
        mouseHoverToElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/span[2]"));
        driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[5]/a[1]")).click();
        Thread.sleep(2000);
        String expectedRateText = "Name Z - A";
        String actualRateText = getTextFromElement(By.xpath("//span[text()='Name Z - A']"));
        Assert.assertEquals("Product Rates is not arranged as expected", expectedRateText, actualRateText);

    }

    @Test
    public void verifyBestSellersProductsPriceArrangeHighToLow() throws InterruptedException {
        mouseHoverToElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/ul[1]/li[2]/span[1]"));
        driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/ul[1]/li[2]/ul[1]/li[2]/a[1]/span[1]")).click();
        String expectedSaleText = "Bestsellers";
        String actualSalesText = getTextFromElement(By.xpath("//h1[@id ='page-title']"));
        Assert.assertEquals("You are not on BestSeller page", expectedSaleText, actualSalesText);
        Thread.sleep(3000);
        mouseHoverToElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/span[2]"));
        driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[3]/a[1]")).click();
        String expectedTextMsg = "Price High - Low";
        String actualTextMsg = getTextFromElement(By.xpath("//span[contains(text(),'Price High - Low')]"));
        Assert.assertEquals("Product Price is not arranged High - Low", expectedTextMsg, actualTextMsg);
    }

    @Test
    public void verifyBestSellersProductsArrangeByRates() throws InterruptedException {
        mouseHoverToElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/ul[1]/li[2]/span[1]"));
        driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/ul[1]/li[2]/ul[1]/li[2]/a[1]/span[1]")).click();
        String expectedSaleText = "Bestsellers";
        String actualSalesText = getTextFromElement(By.xpath("//h1[@id ='page-title']"));
        Assert.assertEquals("You are not on BestSeller page", expectedSaleText, actualSalesText);
        Thread.sleep(3000);
        mouseHoverToElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/span[2]"));
        driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[6]/a[1]")).click();
        String expectedRateMsg = "Rates";
        String actualRateMsg = getTextFromElement(By.xpath("//span[text()='Rates ']"));
        Assert.assertEquals("Product Rates is not arranged as expected", expectedRateMsg, actualRateMsg);

    }

    @After
    public void teardown() {

        closedBrowser();

    }

}














