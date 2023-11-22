package tests;

import com.github.javafaker.Faker;
import utils.RandomUtils;

import java.util.Locale;

public class TestData {

    public String picture = "test.jpg";
    public String textForCheck = "Thanks for submitting the form";
    RandomUtils randomUtils = new RandomUtils();
    public String gender = randomUtils.getRandomGender();
    public String month = randomUtils.getRandomMonth();
    public String subject = randomUtils.getRandomSubject();
    public String hobbies = randomUtils.getRandomHobbies();
    public String state = randomUtils.getRandomState();
    public String city = randomUtils.getRandomCity(state);
    Faker faker = new Faker(new Locale("en-GB"));
    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String userEmail = faker.internet().emailAddress();
    public String userNumber = faker.phoneNumber().subscriberNumber(10);
    public String day = String.valueOf(faker.number().numberBetween(10, 28));
    public String year = String.valueOf(faker.number().numberBetween(1900, 2100));
    public String address = faker.address().fullAddress();

}
