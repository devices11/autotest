package steps;

import pages.Formalize;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.HashMap;

import static junit.framework.TestCase.assertTrue;

public class FormalizeSteps extends BasePageSteps{

    @Step("поле {0} заполняется значением {1}")
    public void stepFillField(String field, String value){
        new Formalize(driver).fillField(field, value);
    }

    @Step("поле {0} заполнено значением {1}")
    public void checkFillField(String field, String value){
        String actual = new Formalize(driver).getFillField(field);
        assertTrue(String.format("Значение поля [%s] равно [%s]. Ожидалось - [%s]", field, actual, value),
                actual.equals(value));
    }

    @Step("Заполняются поля:")
    public void stepFillFields(HashMap<String, String> fields){
        fields.forEach(this::stepFillField);
    }

    @Step("Нажатие кнопки продолжить")
    public void clickSendButton(String button){
        new Formalize(driver).selectButton(button);
    }


    @Step("Проверка ошибки")
    public void stepCheckFieldErrorMessage(String textError){
        new Formalize(driver).checkFieldErrorMessage(textError);
    }

    @Step("Поля заполнены верно")
    public void checkFillFields(HashMap<String, String> fields){
        fields.forEach(this::checkFillField);
    }

}
