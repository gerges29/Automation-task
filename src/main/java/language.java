import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class language {
    public WebElement buttonPOM (WebDriver driver)
    {
        return driver.findElement(By.xpath("//a[@href='#']"));
    }

    public WebElement selectPOM (WebDriver driver)
    {
        return driver.findElement(By.xpath("//a[@href='https://www.nagwa.com/ar/']"));
    }
}
