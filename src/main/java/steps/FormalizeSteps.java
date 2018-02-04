package steps;

import pages.Formalize;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.HashMap;

import static junit.framework.TestCase.assertTrue;

public class FormalizeSteps{

    @Step("поле {0} заполняется значением {1}")
    public void stepFillField(String field, String value){
        new Formalize().fillField(field, value);
    }

    @Step("поле {0} заполнено значением {1}")
    public void checkFillField(String field, String value){
        String actual = new Formalize().getFillField(field);
        assertTrue(String.format("Значение поля [%s] равно [%s]. Ожидалось - [%s]", field, actual, value),
                actual.equals(value));
    }

    @Step("Нажатие кнопки продолжить")
    public void clickSendButton(String button){
        new Formalize().selectButton(button);
    }


    @Step("Проверка ошибки")
    public void stepCheckFieldErrorMessage(String textError){
        new Formalize().checkFieldErrorMessage(textError);
    }

}
