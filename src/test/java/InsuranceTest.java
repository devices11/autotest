import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Title;
import steps.*;

import java.util.HashMap;

public class InsuranceTest extends BasePageSteps {

    private MainPageSteps mainPageSteps = new MainPageSteps();
    private TravelInsurancePageSteps travelInsurancePageSteps = new TravelInsurancePageSteps();
    private ChoicePolicySteps choicePolicySteps = new ChoicePolicySteps();
    private FormalizeSteps formalizeSteps = new FormalizeSteps();
    private HashMap<String, String> testDate = new HashMap<>();


    @Test
    @Title("Страхование путешественников")
    public void testInsurance(){

        mainPageSteps.stepSelectMainMenu("Застраховать себя");
        mainPageSteps.stepSelectSubMenu("Страхование путешественников");
        travelInsurancePageSteps.checkPageTitle("Страхование путешественников");
        travelInsurancePageSteps.goToChoicePolicy("id=f6c836e1-5c5c-4367-b0d0-bbfb96be9c53");
        nextTab();
        choicePolicySteps.stepSelectChoicePolicy("Минимальная");
        choicePolicySteps.goToFormalize();

        testDate.put("Фамилия застрахованного","Ivanov");
        testDate.put("Имя застрахованного","Ivan");
        testDate.put("Дата рождения застрахованного","15.12.1985");
        testDate.put("Фамилия","Иванов");
        testDate.put("Имя","Иван");
        testDate.put("Отчество","Иванович");
        testDate.put("Дата рождения","15.12.1985");
        testDate.put("Серия паспорта","5499");
        testDate.put("Номер паспорта","547852");
        testDate.put("Дата выдачи","16.12.2003");
        testDate.put("Кем выдан","Отделением УФМС по г.Москва");

        formalizeSteps.stepFillFields(testDate);
        formalizeSteps.clickSendButton("Продолжить");
        formalizeSteps.stepCheckFieldErrorMessage("Заполнены не все обязательные поля");
        formalizeSteps.checkFillFields(testDate);
    }
}