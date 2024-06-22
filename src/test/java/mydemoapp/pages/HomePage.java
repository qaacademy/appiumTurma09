package mydemoapp.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
    AndroidDriver driver;

    public String produto = "//android.widget.TextView[@content-desc='store item text' and @text='Sauce Labs Backpack']";
    public String idAddCarrinho = "Add To Cart button";
    public String btnCarrinho = "//android.view.ViewGroup[@content-desc='cart badge']/android.widget.ImageView";

    public HomePage(AndroidDriver driverScenario) {
        super(driverScenario);
        this.driver = driverScenario;
    }

}
