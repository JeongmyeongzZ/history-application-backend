package application.history;

import com.github.javafaker.Faker;

import java.util.Locale;

public interface WithFaker {
    Faker faker = new Faker(Locale.KOREA);
}
