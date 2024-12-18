package dataGenerator;

import com.github.javafaker.Faker;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


public class DataGenerator {
    private DataGenerator() {

    }

    // генерыция даты
    public static String generateDate(int shift) {
        return LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    // генерация емаил адреса
    public static String generateEmail(String locale) {
        Faker faker = new Faker(new Locale(locale));
        return faker.internet().emailAddress();
    }

    // генерация имени
    public static String generateFirstName(String locale) {
        Faker faker = new Faker(new Locale(locale));
        return faker.name().firstName();
    }

    // генерация фамилии
    public static String generateLastName(String locale) {
        Faker faker = new Faker(new Locale(locale));
        return faker.name().lastName();
    }

    // генерация даты рождения
    public static String generateBirthday(String locale) {
        Faker faker = new Faker(new Locale(locale));
        return faker.date().birthday().toString(); // Возвращает дату в формате строки
    }

    // генерация названия клуба
    public static String generateClubName(String locale) {
        Faker faker = new Faker(new Locale(locale));
        String club = "";

        // Генерация случайного числа для выбора типа названия
        int randomType = faker.number().numberBetween(1, 4);

        switch (randomType) {
            case 1:
                // Название с прилагательным и существительным
                club = faker.color().name() + " " + faker.animal().name();
                break;
            case 2:
                // Название с двумя существительными
                club = faker.job().title() + " " + faker.company().suffix();
                break;
            case 3:
                // Название с именем и существительным
                club = faker.name().firstName() + "'s " + faker.rockBand().name();
                break;
            case 4:
                // Название с местоположением и существительным
                club = faker.address().cityName() + " " + faker.esports().event();
                break;
        }

        return club;
    }

    // генерация 1 пароля
    public static String generatePassword() {
        String allowedChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()-_=+[]{};:'\",.<>?/";

        SecureRandom random = new SecureRandom();
        int passwordLength = random.nextInt(3) + 6; // 6, 7 или 8 символов

        StringBuilder password = new StringBuilder();
        for (int i = 0; i < passwordLength; i++) {
            int randomIndex = random.nextInt(allowedChars.length());
            password.append(allowedChars.charAt(randomIndex));
        }
        return password.toString();
    }
    // генерация (копия первого пароля) password1 ,,,
}







