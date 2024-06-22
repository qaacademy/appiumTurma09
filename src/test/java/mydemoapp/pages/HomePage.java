package mydemoapp.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    AndroidDriver driver;

    public String produto = "//android.widget.TextView[@content-desc='store item text' and @text='Sauce Labs Backpack']";
    public String idAddCarrinho = "Add To Cart button";
    public String btnCarrinho = "//android.view.ViewGroup[@content-desc='cart badge']/android.widget.ImageView";

    public HomePage(AndroidDriver driverScenario) {
        this.driver = driverScenario;
    }

    public void clicarPorXpath(String elemento) {
        driver.findElement(AppiumBy.xpath(elemento)).click();
    }

    public void clicarPorAccId(String elemento) {
        driver.findElement(AppiumBy.accessibilityId(elemento)).click();
    }

}
