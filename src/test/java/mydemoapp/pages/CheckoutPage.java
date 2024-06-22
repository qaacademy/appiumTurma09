package mydemoapp.pages;

import io.appium.java_client.android.AndroidDriver;

public class CheckoutPage extends BasePage {
    AndroidDriver driver;

    public String inputIdNome= "Full Name* input field";
    public String inputIdEndereco = "Address Line 1* input field";

    public String inputIdCidade = "City* input field";
    public String inputIdCodigoPostal = "Zip Code* input field";

    public String inputIdPais = "Country* input field";

    public String btnIdIrParaPagamento = "To Payment button";

    public CheckoutPage(AndroidDriver driverScenario) {
        super(driverScenario);
        super.driver = driverScenario;
    }

}
