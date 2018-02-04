package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BasePageSteps;


public class TravelInsurancePage extends BasePage{

    @FindBy(xpath = "//div[contains(@class,'sbrf-div-list-inner --area bp-area body-container')]")
    public WebElement sendButton;

    @FindBy(xpath = "//div[@class='sbrf-rich-outer']/h1")
    public WebElement title;


    public TravelInsurancePage (){
        PageFactory.initElements(BasePageSteps.getDriver(), this);
        (new WebDriverWait(BasePageSteps.getDriver(), 20))
                .until(ExpectedConditions.visibilityOf(title));
    }

    public void clickSendButton (String imgItem){
        sendButton.findElement(By.xpath(".//img[contains(@src,'"+imgItem+"')]")).click();
    }

}
