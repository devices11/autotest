package util;

import org.junit.runner.notification.Failure;

public class AllureListener extends ru.yandex.qatools.allure.junit.AllureRunListener {

    @Override
    public void testFailure(Failure failure){
        super.testFailure(failure);
    }

}
