package com;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class corparateCss {

    @Test
    public void userRegister() throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "/opt/chromedriver");

        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
        driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(1, TimeUnit.MINUTES);

        WebDriverWait wait = new WebDriverWait(driver, 30);

        driver.manage().window().maximize();

        driver.get("https://secure.sahibinden.com/kayit/kurumsal/");

        driver.manage().deleteAllCookies();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("#name")));
        WebElement name =  driver.findElement(By.id("#name"));
        name.sendKeys("Tuba");
        System.out.println("İsim yazıldı ve placeholder = " +name.getAttribute("placeholder") );

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("#surname")));
        WebElement surname= driver.findElement(By.id("#surname"));
        surname.sendKeys("Test");
        System.out.println("Soyisim yazıldı ve placeholder = " +surname.getAttribute("placeholder") );


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("#email")));
        WebElement email= driver.findElement(By.id("#email"));
        email.sendKeys("tubauluggg@gmail.com");
        System.out.println("Email yazıldı ve placeholder = " +email.getAttribute("placeholder") );


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("#password")));
        WebElement password= driver.findElement(By.id("#password"));
        password.sendKeys("password1234");
        System.out.println("Şifre yazıldı ve placeholder = " +password.getAttribute("placeholder") );


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("#phone")));
        WebElement phone = driver.findElement(By.id("#phone"));
        phone.sendKeys("2126907878");
        System.out.println("Telefon yazıldı ve placeholder = " +phone.getAttribute("placeholder") );

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("#category")));
        Select realEstateSelect = new Select(driver.findElement(By.id("#category")));
        realEstateSelect.selectByVisibleText("Emlak");
        System.out.println("Faliyet alanı seçildi.");


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("#city")));
        Select citySelect = new Select(driver.findElement(By.id("#city")));
        citySelect.selectByValue("34");
        System.out.println("Şehir seçildi.");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("#town")));
        WebElement town = driver.findElement(By.id("#town"));

        Thread.sleep(3000);

        String isDisabled = town.getAttribute("disabled");
        System.out.println(isDisabled);
        Thread.sleep(1000);

        if (isDisabled == null){

            Select townSelect = new Select(town);
            townSelect.selectByVisibleText("Arnavutköy");
            System.out.println("İlçe seçildi.");
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("#quarter")));
        Select quarterSelect = new Select(driver.findElement(By.id("#quarter")));
        quarterSelect.selectByVisibleText("Bolluca Mah.");
        System.out.println("Mahalle seçildi.");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='Şahıs Şirketi']")));
        WebElement companyType= driver.findElement(By.xpath("//label[text()='Şahıs Şirketi']"));
        companyType.click();
        System.out.println("İşletme türü seçildi.");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("#taxOfficeCity")));
        Select takeOfficeCity = new Select(driver.findElement(By.id("#taxOfficeCity")));
        takeOfficeCity.selectByVisibleText("İstanbul");
        System.out.println("Vergi dairesi ili seçildi.");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("#taxOffice")));
        Select takeOffice = new Select(driver.findElement(By.id("#taxOffice")));
        takeOffice.selectByVisibleText("Bakırköy Vergi Dairesi");
        System.out.println("Vergi dairesi seçildi.");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("#taxNumber")));
        WebElement takeNumber = driver.findElement(By.id("#taxNumber"));
        takeNumber.sendKeys("2664567893");
        System.out.println("Vergi numarsı girildi.");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("#idNumber")));
        WebElement idNumber = driver.findElement(By.id("#idNumber"));
        idNumber.sendKeys("26674879065");
        System.out.println("TC kimlik numarası girildi.");


        driver.executeScript("document.getElementById('#endUserLicenseAgreement').click()");
        System.out.println("Kurumsal Hesap Sözleşmesi ve Eklerini kabul ediyorum tıklandı");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("#signUpButton")));
        driver.findElement(By.id("#signUpButton")).click();
        System.out.println("Kayıt ola tıklandı.");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("#confirmSubmit")));;
        WebElement confirmEmailButton  = driver.findElement(By.id("#confirmSubmit"));
        confirmEmailButton.click();

        driver.quit();


    }
}



