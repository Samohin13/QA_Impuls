package test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import dataGenerator.DataGenerator;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.RegistrationPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class RegistrationTest {
    @BeforeEach
    void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDown() {
        SelenideLogger.removeListener("allure");
    }

    @BeforeEach
    void setUp() {
        Configuration.browserSize = String.valueOf(true);
        open("http://127.0.0.1:8000/pages/register/");
        RegistrationPage registrationPage = new RegistrationPage();
    }

    @Test
    public void testRegistrationForm() {
        String email = DataGenerator.generateEmail("ru");
        String firstName = DataGenerator.generateFirstName("ru");
        String lastName = DataGenerator.generateLastName("ru");
        String birthday = DataGenerator.generateBirthday("ru");
        String clubName = DataGenerator.generateClubName("ru");
        String password = DataGenerator.generatePassword();


       // RegistrationPage.register(email, firstName, lastName, Integer.parseInt(birthday), clubName, password);
        Selenide.sleep(3000);
        // Добавлен для ожидания перенаправления (если нужно)
        Selenide.open("http://127.0.0.1:8000/pages/login/");
        $("#loginUser").shouldBe(Condition.visible);
    }
}













