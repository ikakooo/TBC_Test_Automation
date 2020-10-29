import TestingDriverConstants.chromeDriverPath
import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.interactions.Actions

fun main() {
    System.setProperty("webdriver.chrome.driver", chromeDriverPath)
    val sDriver = ChromeDriver()


    sDriver.get("http://the-internet.herokuapp.com")
    Thread.sleep(1500)
    val shiftingContentButton = sDriver.findElement(By.xpath("//a[@href='/shifting_content']"))
    shiftingContentButton.click()
    Thread.sleep(1500)
    val menuElementContentButton = sDriver.findElement(By.xpath("//a[@href='/shifting_content/menu']"))
    menuElementContentButton.click()
    Thread.sleep(1500)
    val colorChange = sDriver.findElement(By.xpath("//a[@href='/']"))
    val color = colorChange.getCssValue("color")
    val actionBuilder = Actions(sDriver)
    actionBuilder.moveToElement(colorChange).build().perform()
    ////////ჰოუმ ბათონის მაუსის შეხებაზე დეთექშენ ჩექი ///////////////////////////////////////////////////////////////////
    println(
        "Color on mouse touch isChanged? -> ${
            !color.toCharArray().contentEquals(colorChange.getCssValue("color").toCharArray())
        }"
    )
    Thread.sleep(2000)

    //////////////////////////////ფოტოს კორდინატების ცვლილების შემოწმება///////////////////////////////////////
    sDriver.get("http://the-internet.herokuapp.com/shifting_content/image")

    val imgChange = sDriver.findElement(By.xpath("//img[@src='/img/avatar.jpg']"))
    val imgLocation = imgChange.getCssValue("left")
    val clickHereButton = sDriver.findElement(By.xpath("//a[@href='/shifting_content/image?pixel_shift=100']"))
    clickHereButton.click()
    val imgChanged = sDriver.findElement(By.xpath("//img[@src='/img/avatar.jpg']"))
    println(
        "IMG location  isChanged? -> ${
            !imgLocation.toCharArray().contentEquals(imgChanged.getCssValue("left").toCharArray())
        }"
    )
}