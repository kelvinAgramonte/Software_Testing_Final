import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchBoxVisibleTest extends BaseTest {

    @Test
    public void testSearchBoxVisible() {
        driver.get("https://www.imdb.com");
        WebElement searchBox = driver.findElement(By.id("suggestion-search"));
        Assert.assertTrue(searchBox.isDisplayed(), "Search box is not visible.");
    }
}
