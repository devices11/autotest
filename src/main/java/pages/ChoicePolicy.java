package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BasePageSteps;

import java.util.ArrayList;

public class ChoicePolicy {

    @FindBy(xpath = "//*[contains(text(),'Выбор полиса')]")
    WebElement title;

    @FindBy(xpath = "//div[contains(@class,'b-form-box-block')]")
    public WebElement setInsurance;

    @FindBy(xpath = "//span[contains(@class,'b-button-block-center')]")
    public WebElement buttonFormalize;

    public ChoicePolicy() {
        PageFactory.initElements(BasePageSteps.getDriver(), this);
        (new WebDriverWait(BasePageSteps.getDriver(), 10))
                .until(ExpectedConditions.visibilityOf(title));
    }

    public void selectSetInsurance (String insuranceItem) {
        setInsurance.findElement(By.xpath(".//*[contains(text(),'"+insuranceItem+"')]")).click();
    }

}
