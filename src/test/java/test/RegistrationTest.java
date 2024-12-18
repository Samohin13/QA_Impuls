package test;

import com.codeborne.selenide.Configuration;

import dataGenerator.DataGenerator;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.RegistrationPage;

import static com.codeborne.selenide.Selenide.open;


public class RegistrationTest {

    @BeforeEach
    void setUp()  {
        Configuration.browserSize = String.valueOf(true);
        open("http://127.0.0.1:8000/pages/register/");
    }

        @Test
        public void testSuccessfulRegistration() {
            // Открываем страницу регистрации
            open("http://127.0.0.1:8000/pages/register/");

            // Генерация тестовых данных
            String locale = "ru";
            String email = DataGenerator.generateEmail(locale);
            String firstName = DataGenerator.generateFirstName(locale);
            String lastName = DataGenerator.generateLastName(locale);
            String birthday = DataGenerator.generateBirthday(locale);
            String clubName = DataGenerator.generateClubName(locale);
            String password = DataGenerator.generatePassword();

            // Инициализация страницы
            RegistrationPage registrationPage = new RegistrationPage();

            // Выполнение регистрации
            registrationPage.register(email, firstName, lastName, birthday, clubName, password);

            // Проверка успешной регистрации
            // Здесь вы можете добавить проверку на наличие элемента с сообщением об успешной регистрации
            // Например:
            // $("selector-success-message").shouldHave(text("Регистрация прошла успешно"));
        }

        @Test
        public void testRegistrationWithInvalidEmail() {
            // Открываем страницу регистрации
            open("http://127.0.0.1:8000/pages/register/");

            // Генерация тестовых данных
            String locale = "en";
            String invalidEmail = "invalid-email"; // Невалидный email
            String firstName = DataGenerator.generateFirstName(locale);
            String lastName = DataGenerator.generateLastName(locale);
            String birthday = DataGenerator.generateBirthday(locale);
            String clubName = DataGenerator.generateClubName(locale);
            String password = DataGenerator.generatePassword();

            // Инициализация страницы
            RegistrationPage registrationPage = new RegistrationPage();

            // Выполнение регистрации с невалидным email
            registrationPage.register(invalidEmail, firstName, lastName, birthday, clubName, password);

            // Проверка сообщения об ошибке
            // Например:
            // $("selector-error-message").shouldHave(text("Некорректный email"));
        }

//        @Test
//        public void testRegistrationWithMismatchedPasswords() {
//            // Открываем страницу регистрации
//            open("http://127.0.0.1:8000/pages/register/");
//
//            // Генерация тестовых данных
//            String locale = "en";
//            String email = DataGenerator.generateEmail(locale);
//            String firstName = DataGenerator.generateFirstName(locale);
//            String lastName = DataGenerator.generateLastName(locale);
//            String birthday = DataGenerator.generateBirthday(locale);
//            String clubName = DataGenerator.generateClubName(locale);
//            String password = DataGenerator.generatePassword();
//            String mismatchedPassword = DataGenerator.generatePassword(); // Второй пароль, не совпадающий с первым
//
//            // Инициализация страницы
//            RegistrationPage registrationPage = new RegistrationPage();
//
//            // Указание некорректного подтверждения пароля
//            registrationPage.register(email, firstName, lastName, birthday, clubName, password);
//            registrationPage.password1.setValue(mismatchedPassword);
//
//            // Проверка сообщения об ошибке
//            // Например:
//            // $("selector-error-message").shouldHave(text("Пароли не совпадают"));
        }













