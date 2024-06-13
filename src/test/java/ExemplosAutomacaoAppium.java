import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebElement;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Map;

public class ExemplosAutomacaoAppium {

    AndroidDriver driver;

    @Before
    public void before() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setPlatformVersion("13.0");
        options.setAutomationName("UIAutomator2");
        options.setDeviceName("emulator-5554");
        options.setApp("/Users/mac/Documents/automatizaoMobileTurma09/src/test/resources/ApiDemos-debug.apk");
        options.setNoReset(false);
        options.setAppPackage("io.appium.android.apis");
        options.setAppActivity(".ApiDemos");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(AppiumBy.id("com.android.permissioncontroller:id/continue_button")).click();
        driver.findElement(AppiumBy.id("android:id/button1")).click();
    }

    @Test
    public void primeiroExemplo() {

        driver.findElement(AppiumBy.accessibilityId("App")).click();
        driver.findElement(AppiumBy.accessibilityId("Activity")).click();
        driver.findElement(AppiumBy.accessibilityId("Hello World")).click();
        Assert.assertEquals("Hello, World!", driver.findElement(AppiumBy.id("io.appium.android.apis:id/text")).getText());
        String activity = driver.currentActivity();
        Assert.assertEquals(".app.HelloWorld", activity);
    }

    @Test
    public void scrollDown() {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("
                + "new UiSelector().text(\"WebView\"));"));
    }

    @Test
    public void dragAndDrop() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();

        RemoteWebElement source = (RemoteWebElement) driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));
        RemoteWebElement destination = (RemoteWebElement) driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_2"));
        driver.executeScript("gesture: dragAndDrop", Map.of("sourceId", source.getId(), "destinationId", destination.getId()));
    }

    @Test
    public void webViewTest() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("
                + "new UiSelector().text(\"WebView\"));"));
        driver.findElement(AppiumBy.accessibilityId("WebView")).click();
        Object[] handles = driver.getContextHandles().toArray();
        System.out.println(handles[0] + " - " + handles[1]);
        String webViewContext = (String) handles[1];
        driver.context(webViewContext);

        Assert.assertTrue(driver.findElement(By.xpath("//body")).isDisplayed());
        driver.context((String) handles[0]);

    }

    @Test
    public void recorded(){
        var el1 = driver.findElement(AppiumBy.accessibilityId("Views"));
        el1.click();
        var el2 = driver.findElement(AppiumBy.accessibilityId("Drag and Drop"));
        el2.click();
        var el3 = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));
        el3.click();

    }

    @After
    public void after() {
        if (driver != null) {
            driver.quit();
        }
    }


}
