package steps;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ScenarioSteps {

    BasePageSteps basePageSteps = new BasePageSteps();
    MainPageSteps mainPageSteps = new MainPageSteps();
    TravelInsurancePageSteps travelInsurancePageSteps = new TravelInsurancePageSteps();
    ChoicePolicySteps choicePolicySteps = new ChoicePolicySteps();
    FormalizeSteps formalizeSteps = new FormalizeSteps();

    @When("^выбран пункт меню \"(.*)\"$")
    public void stepSelectMainMenu(String menuItem){
        mainPageSteps.stepSelectMainMenu(menuItem);
    }

    @Then("^выбран вид страхования \"(.*)\"$")
    public void stepSelectSubMenu(String menuItem){
        mainPageSteps.stepSelectSubMenu(menuItem);
    }

    @When("^заголовок страницы равен \"(.*)\"$")
    public void checkPageTitle(String expectedTitle){
        travelInsurancePageSteps.checkPageTitle(expectedTitle);
    }

    @Then("^выполнено нажати на изображение \"(.*)\"$")
    public void goToChoicePolicy(String imgItem){
        travelInsurancePageSteps.goToChoicePolicy(imgItem);
    }

    @When("^выполнен переход на открывшуюся вкладку$")
    public void nextTab(){
        basePageSteps.nextTab();
    }

    @When("^выбрана сумма страховой защиты \"(.*)\"$")
    public void selectSetInsurance (String insuranceItem){
        choicePolicySteps.stepSelectChoicePolicy(insuranceItem);
    }

    @Then("^выполнено нажатие на кнопку Оформить$")
    public void goToFormalize(){
        choicePolicySteps.goToFormalize();
    }

    @When("^заполняются поля:$")
    public void fillForm(DataTable fields){
        fields.asMap(String.class, String.class)
                .forEach((field, value) -> formalizeSteps.stepFillField(field, value));
    }

    @Then("^выполнено нажатие на кнопку \"(.*)\"$")
    public void clickSendButton(String button){
        formalizeSteps.clickSendButton(button);
    }

    @Then("^значения полей равны:$")
    public void checkFillForm(DataTable fields){
        fields.asMap(String.class, String.class)
                .forEach((field, value) -> formalizeSteps.checkFillField(field, value));
    }

    @Then("^присутствует сообщение об ошибке \"(.+)\"$")
    public void checkErrorMessage(String textError){
        formalizeSteps.stepCheckFieldErrorMessage(textError);

    }
}
