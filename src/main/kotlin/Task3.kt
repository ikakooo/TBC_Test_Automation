import TestingDriverConstants.chromeDriverPath
import org.openqa.selenium.chrome.ChromeDriver

fun main() {
    System.setProperty("webdriver.chrome.driver", chromeDriverPath)
    val rDriver = ChromeDriver()
    rDriver.get("http://the-internet.herokuapp.com/challenging_dom")

}