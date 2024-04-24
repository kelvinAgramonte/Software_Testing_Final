import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
public class NavigateMoreLikeThisSectionTest extends BaseTest {

    @Test
    public void clickMoreLikeThisRightArrow() throws InterruptedException {
        // Navigate to the IMDb page for "The Godfather Part II"
        driver.get("https://www.imdb.com/title/tt0071562/");

        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 4000);");
        Thread.sleep(2000);

        WebElement rightArrow = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".ipc-shoveler__arrow--right.ipc-icon--chevron-right-inline")));
        // Click the right arrow in the "More Like This" section
        rightArrow.click();

        // Additional actions or verifications can be added here
    }
}
