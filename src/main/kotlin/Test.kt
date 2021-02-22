import TestingDriverConstants.chromeDriverPath
import org.junit.Before
import org.junit.Test
import org.openqa.selenium.chrome.ChromeDriver

class Test {
    private lateinit var driver:ChromeDriver
    @Before
    fun driverSetup(){
        System.setProperty("webdriver.chrome.driver",  "src\\main\\kotlin\\Chromedrivers\\chromedriver.exe")
        driver = ChromeDriver()
    }
    @Test
    fun repeatGetRequest(){
        repeat(10000){
            driver.get("https://github.com/ikakooo")
            Thread.sleep((500+it).toLong())
        }
    }
}