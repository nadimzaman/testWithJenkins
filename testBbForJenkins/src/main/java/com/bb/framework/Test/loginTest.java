package com.bb.framework.Test;

import com.bb.framework.Base.Hook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class loginTest extends Hook {



    @Test
    public void loginWithInValidIdAndInvalidPassword(){


        loginPage.clickLoginLinkInHomePage();
        loginPage.veryFyLogInPageTitle("Blackbird.AI");
        loginPage.loginWithIdAndPassword("n@asss.com", "c123223");
        loginPage.errorMessage_forInvalidInputs_inLOGIN("User none found or password is incorrect");
    }
}

