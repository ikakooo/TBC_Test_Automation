import TestingDriverConstants.chromeDriverPath
import org.junit.Assert.assertEquals
import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver

fun main() {

    val websitePath = "http://the-internet.herokuapp.com/upload"
    val fileForUploadPath = "C:\\Users\\ikakooo\\Desktop\\icons\\ic_person.png"

    System.setProperty("webdriver.chrome.driver", chromeDriverPath)
    val driver = ChromeDriver()

    /////////1) ფაილის ატვირთვა და შემოწმება////////////////////////
    driver.get(websitePath)

    val choseFileButton = driver.findElement(By.id("file-upload"))
    choseFileButton.sendKeys(fileForUploadPath)
    Thread.sleep(1000)

    val uploadButton = driver.findElement(By.id("file-submit"))
    uploadButton.click()

    val verifyFileUploadedOrNot = driver.findElement(By.tagName("h3"))
    println("From Task1: ${verifyFileUploadedOrNot.text} ->->->  ")
    println(verifyFileUploadedOrNot.text.toCharArray().contentEquals("File Uploaded!".toCharArray()))
    assertEquals(verifyFileUploadedOrNot.text, "File Uploaded!")
    Thread.sleep(2000)

}