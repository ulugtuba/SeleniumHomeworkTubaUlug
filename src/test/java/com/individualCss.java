package com;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class individualCss {


    @Test
    public void userRegisterCss(){


        System.setProperty("webdriver.chrome.driver", "/opt/chromedriver");

        ChromeDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 30);

        driver.manage().window().maximize();
        driver.get("https://secure.sahibinden.com/kayit");

        driver.manage().deleteAllCookies();
        List<Cookie> cookieList = new ArrayList<>();
        cookieList.add(new Cookie("testBox","51",".sahibinden.com","/",null));
        cookieList.add(new Cookie("tbSite","x",".sahibinden.com","/",null));
        cookieList.forEach(cookie -> driver.manage().addCookie(cookie));


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("#name")));
        WebElement name = driver.findElement(By.id("#name"));
        name.sendKeys("Tuba");
        System.out.println("İsim yazıldı ");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("#surname")));
        WebElement surname = driver.findElement(By.id("#surname"));
        surname.sendKeys("Uluğ");
        System.out.println("Soyisim yazıldı");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("#email")));
        WebElement mail = driver.findElement(By.id("#email"));
        mail.sendKeys("tubaulug@mailinator.com");
        System.out.println("Email yazıldı" );

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("#password")));
        WebElement password = driver.findElement(By.id("#password"));
        password.sendKeys("password123");
        System.out.println("Şifre yazıldı" );

        driver.executeScript("document.getElementById('endUserLicenseAgreement').click()");
        System.out.println("Agreement check e tıklandı ");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("#signUpButton")));
        WebElement signupButton = driver.findElement(By.id("#signUpButton"));
        signupButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("confirmSubmit")));
        WebElement confirmEmailButton = driver.findElement(By.id("confirmSubmit"));
        confirmEmailButton.click();

        driver.quit();

    }


}
