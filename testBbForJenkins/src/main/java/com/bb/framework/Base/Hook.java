package com.bb.framework.Base;

import com.bb.framework.pages.LoginPage;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Hook {

    public static WebDriver driver;


    protected LoginPage loginPage = null;






    @BeforeMethod
    public void setUp() {

        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to("http://beta.blackbird.ai");

       loginPage = new LoginPage(driver);

       // loginPage = new LoginPage(driver);


    }


    @AfterMethod
    public void tearDown() {

        driver.close();
        driver.quit();
    }
}
