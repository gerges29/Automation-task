import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class search {


    public WebElement iconPOM (WebDriver driver)
    {
       return driver.findElement(By.xpath("//button[@type='button']"));
    }

    public WebElement fildPOM (WebDriver driver)
    {
        return driver.findElement(By.id("txt_search_query"));
    }

    public WebElement secLessonPOM (WebDriver driver)
    {
        return driver.findElement(By.xpath("//a[@href='https://www.nagwa.com/en/lessons/167131671315/']"));
    }

    public WebElement worksheetPOM (WebDriver driver)
    {
        return driver.findElement(By.xpath("//a[@href='../../worksheets/737102191030/']"));
    }


}
