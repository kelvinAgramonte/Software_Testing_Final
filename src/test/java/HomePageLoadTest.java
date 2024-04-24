import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageLoadTest extends BaseTest {

    @Test
    public void testHomePageLoad() {
        driver.get("https://www.imdb.com");
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("IMDb"), "Home page didn't load successfully.");
    }
}
