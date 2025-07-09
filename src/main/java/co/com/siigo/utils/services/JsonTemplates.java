package co.com.siigo.utils.services;

import co.com.siigo.models.services.ServicesClient;

public class JsonTemplates {

    public String bodyRequestReqres(ServicesClient client) {
        return "{\n" +
                "    \"name\": \"" + client.getName() + "\",\n" +
                "    \"job\": \"" + client.getJob() + "\"\n" +
                "}";
    }
}
