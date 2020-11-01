import TestingDriverConstants.chromeDriverPath
import com.google.gson.annotations.Until
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.StringEndsWith.endsWith

import org.junit.Assert

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.By
import org.openqa.selenium.WebElement


fun main() {
    System.setProperty("webdriver.chrome.driver", chromeDriverPath)
    val rDriver = ChromeDriver()
    rDriver.get("http://the-internet.herokuapp.com/challenging_dom")

    val verifyFileUploadedOrNot = rDriver.findElements(By.tagName("tbody"))
    val trFind: List<WebElement> = verifyFileUploadedOrNot[0].findElements(By.tagName("tr"))
    val trElements = trFind[0].text.split(" ")
    (0..5).forEach {
        val stingCharArray = trElements[it].toCharArray()
      val stingSize =  stingCharArray.size
      Assert.assertEquals(stingCharArray[stingSize-1], '0')
//        println(it)
//        println(stingCharArray[stingSize-1])
        /////// ეს შედარების ასერტი უფრო მარტივად და გასაგებად მუშაობს
        assertThat(trElements[it], endsWith("0"))
        println(
            "Last Char is zero? -> ${
                stingCharArray[stingSize-1] == '0'
            }"
        )
    }


}
