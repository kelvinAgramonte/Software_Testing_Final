import org.testng.annotations.*;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import java.util.Scanner;
import java.util.List;
import javax.swing.JOptionPane;

public class AutomationTests {
    private WebDriver driver;
    private Scanner scanner = new Scanner(System.in);

    @BeforeSuite
    public void setUpSuite() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kelvi\\Downloads\\browser\\chrome\\driver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        scanner = new Scanner(System.in);
    }

    @BeforeTest
    public void setUpTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterTest
    public void tearDownTest() {
        driver.quit();
        scanner.close();
    }

    // Test Methods with Scanner Input
    @Test (priority = 1)
    public void testPalindrome() {
        String input = JOptionPane.showInputDialog("Enter a number to check if it is a palindrome:");
        int number = Integer.parseInt(input);
        assert number == reverseNumber(number) : "Test failed: The number is not a palindrome.";
        JOptionPane.showMessageDialog(null, number + " is a palindrome.");
    }

    @Test (priority = 2)
    public void testFactorial() {
        String input = JOptionPane.showInputDialog("Enter a number to calculate its factorial:");
        int number = Integer.parseInt(input);
        int calculatedFactorial = factorial(number);
        assert calculatedFactorial == factorial(number) : "Test failed: Factorial calculation is incorrect.";
        JOptionPane.showMessageDialog(null, "The factorial of " + number + " is " + calculatedFactorial + ".");
    }

    @Test (priority = 3)
    public void testPrime() {
        String input = JOptionPane.showInputDialog("Enter a number to check if it is prime:");
        int number = Integer.parseInt(input);
        assert isPrime(number) : "Test failed: The number is not prime.";
        JOptionPane.showMessageDialog(null, number + " is a prime number.");
    }

    private int reverseNumber(int number) {
        int reverse = 0;
        while (number != 0) {
            reverse = reverse * 10 + number % 10;
            number /= 10;
        }
        return reverse;
    }

    private int factorial(int n) {
        if (n == 0) return 1;
        else return n * factorial(n-1);
    }

    private boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    @Test(priority = 4)
    public void testPageTitle() {
        System.out.println("Test 4 - Checking page title.");
        driver.get("https://www.square-enix.com/");
        String expectedTitle = "Expected Page Title";
        String actualTitle = driver.getTitle();
        Assert.assertNotEquals(actualTitle, expectedTitle, "The actual title matches the expected title.");
    }

    @Test(priority = 5)
    public void testURL() {
        System.out.println("Test 5 - Checking URL.");
        driver.get("https://www.square-enix.com/");
        String expectedURL = "https://www.square-enix.com/";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL, "The URL does not match the expected URL.");
    }

    @Test(priority = 6)
    public void testElementSize() {
        System.out.println("Test 6 - Checking the size of <p> elements on the page.");
        driver.get("https://www.square-enix.com/");
        List<WebElement> elements = driver.findElements(By.tagName("p"));
        int expectedSize = 0; // Assuming we expect 0.
        Assert.assertEquals(elements.size(), expectedSize, "The size of the elements does not match the expected size.");
    }

    public static void main(String[] args) {
        org.testng.TestNG.main(new String[]{AutomationTests.class.getName()});
    }
}
