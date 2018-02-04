package steps;

import pages.TravelInsurancePage;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class TravelInsurancePageSteps {

    @Step(" заголовок страницы - равен {0}")
    public void checkPageTitle(String expectedTitle) {
        String actualTitle = new TravelInsurancePage().title.getText();
        assertTrue(String.format("Заголовок равен [%s]. Ожидалось - [%s]",
                actualTitle, expectedTitle), actualTitle.contains(expectedTitle));
    }

    @Step("выполнено нажатие на Оформить онлайн на картинке")
    public void goToChoicePolicy(String imgItem){
        new TravelInsurancePage().clickSendButton(imgItem);
    }
}
