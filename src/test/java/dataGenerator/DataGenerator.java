package dataGenerator;

import com.github.javafaker.Faker;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Locale;


public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateEmail(String locale) {
        Faker faker = new Faker(new Locale(locale));
        return faker.internet().emailAddress();
    }

    public static String generateFirstName(String locale) {
        Faker faker = new Faker(new Locale(locale));
        return faker.name().firstName();
    }

    public static String generateLastName(String locale) {
        Faker faker = new Faker(new Locale(locale));
        return faker.name().lastName();
    }

    public static String generateBirthday(String locale) {
        Faker faker = new Faker(new Locale(locale));
        Date birthday = faker.date().birthday();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy"); // Используйте формат yyyy-MM-dd
        return sdf.format(birthday);
    }

    public static String generateClubName(String locale) {
        Faker faker = new Faker(new Locale(locale));
        String club = "";
        int randomType = faker.number().numberBetween(1, 4);

        switch (randomType) {
            case 1:
                club = faker.color().name() + " " + faker.animal().name();
                break;
            case 2:
                club = faker.job().title() + " " + faker.company().suffix();
                break;
            case 3:
                club = faker.name().firstName() + "'s " + faker.rockBand().name();
                break;
            case 4:
                club = faker.address().cityName() + " " + faker.esports().event();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + randomType);
        }

        return club;
    }



    public static String generatePassword() {
        String allowedChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()-_=+[]{};:'\",.<>?/";
        SecureRandom random = new SecureRandom();
        int passwordLength = random.nextInt(3) + 6;
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < passwordLength; i++) {
            int randomIndex = random.nextInt(allowedChars.length());
            password.append(allowedChars.charAt(randomIndex));
        }
        return password.toString();
    }
}








