package utils;

import com.github.javafaker.Faker;
import tests.StudentRegistrationTestData;

import java.security.SecureRandom;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

import static org.apache.commons.lang3.StringUtils.length;

public class RandomUtils {

    Faker faker = new Faker(new Locale("en-GB"));
    StudentRegistrationTestData studentRegistrationTestData = new StudentRegistrationTestData();


    public static String getRandomString(int len) {
//        String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));

        return sb.toString();
    }


    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRandomDay(int min, int max) {
        String day = String.valueOf(ThreadLocalRandom.current().nextInt(min, max + 1));
        if (length(day) < 2) {
            day = "0" + day;
        }
        return day;
    }

    public static String getRandomItemFromArray(String[] array) {
        int index = getRandomInt(0, array.length - 1);

        return array[index];
    }

    public String getRandomGender() {
        return faker.options().option(studentRegistrationTestData.genders);
    }

    public String getRandomSubject() {
        return faker.options().option(studentRegistrationTestData.subjects);
    }

    public String getRandomMonth() {
        return faker.options().option(studentRegistrationTestData.month);

    }

    public String getRandomHobbies() {
        return faker.options().option(studentRegistrationTestData.hobbies);
    }

    public String getRandomState() {
        return faker.options().option(studentRegistrationTestData.states);
    }

    public String getRandomCity(String state) {
        String city = null;
        if (state.equals("NCR")) {
            city = faker.options().option(studentRegistrationTestData.ncrCities);
        }
        if (state.equals("Uttar Pradesh")) {
            city = faker.options().option(studentRegistrationTestData.uttarPradeshCities);
        }
        if (state.equals("Haryana")) {
            city = faker.options().option(studentRegistrationTestData.haryanaCities);
        }
        if (state.equals("Rajasthan")) {
            city = faker.options().option(studentRegistrationTestData.rajasthanCities);
        }

        return city;
    }
}



