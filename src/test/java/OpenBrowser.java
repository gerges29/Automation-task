import config.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static java.lang.System.getProperty;


public class OpenBrowser {


     WebDriver driver = null;

        language lang;

        search search;


        @BeforeTest
        public void OpenBrowser() throws InterruptedException {



            //bridge between test scripts and browser
            String chromePath = getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");

            System.out.println(chromePath);
            System.setProperty("webdriver.chrome.driver", chromePath);

            //new object of WebDriver
            driver = new ChromeDriver(options);

            //navigate to google website and maximize screen and sleep 3 seconds
            driver.manage().window().maximize();
            Thread.sleep(3000);

            //open website
            driver.navigate().to("https://www.nagwa.com/en/");

            //create new objets
            lang = new language();
            search = new search();
        }


        @Test
        public void ChooseLanguage() {

            // Enter different language using POM
            lang.buttonPOM(driver).click();
            lang.selectPOM(driver).click();
            String expectedtitle = "نجوى";
            String actualtitle = driver.getTitle();
            Assert.assertEquals(actualtitle, expectedtitle);
        }


        @Test
        public void Search() throws InterruptedException {

            //get data from config file
            String searchInput = ConfigReader.getInstance().getSearchInput();

            //search steps using pom
            search.iconPOM(driver).click();
            search.fildPOM(driver).sendKeys(searchInput);
            search.fildPOM(driver).sendKeys(Keys.ENTER);

            search.secLessonPOM(driver).click();
            //search.worksheetPOM(driver).click();

            //count number of Questions
            int questionCount = driver.findElements(By.className("instance")).size();
            System.out.println("Number of questions: " + questionCount);
        }

        @AfterTest
        public void CloseDriver() throws InterruptedException {
            Thread.sleep(3000);
            driver.quit();
        }

    }