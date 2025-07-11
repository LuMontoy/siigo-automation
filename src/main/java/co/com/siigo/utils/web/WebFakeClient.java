package co.com.siigo.utils.web;

import co.com.siigo.models.web.WebClient;
import com.github.javafaker.Faker;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class WebFakeClient {

    public static WebClient getNewFakeClient() {
        List<String> colombianCities = Arrays.asList(
                "Bogota", "Medellin", "Cali", "Barranquilla", "Cartagena"
        );
        String[] citiesArray = colombianCities.toArray(new String[0]);

        Faker faker = new Faker(new Locale("es", "CO"));
        WebClient client = new WebClient();

        client.setName(faker.name().firstName());
        client.setLastName(faker.name().lastName());
        client.setCity(faker.options().option(citiesArray));
        client.setId(String.valueOf(faker.number().numberBetween(1_000_000, 10_000_000)));

        return client;
    }
}
