package steps;

import pages.ChoicePolicy;
import ru.yandex.qatools.allure.annotations.Step;

public class ChoicePolicySteps{
    @Step("Выбрана сумма страховой защиты {0}")
    public void stepSelectChoicePolicy(String choicePolicyItem){
        new ChoicePolicy().selectSetInsurance(choicePolicyItem);
    }

    @Step("Выполнено нажатие на Оформить")
    public void goToFormalize(){
        new ChoicePolicy().buttonFormalize.click();
    }
}
