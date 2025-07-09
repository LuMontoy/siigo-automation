package co.com.siigo.utils.services;

import co.com.siigo.models.services.ServicesClient;
import com.github.javafaker.Faker;

import java.util.Locale;

public class ServicesFakeClient {

    public static ServicesClient getNewFakeClient() {

        Faker faker = new Faker(new Locale("es", "CO"));
        ServicesClient client = new ServicesClient();

        client.setName(faker.name().firstName());
        client.setJob(faker.job().title());

        return client;
    }
}
