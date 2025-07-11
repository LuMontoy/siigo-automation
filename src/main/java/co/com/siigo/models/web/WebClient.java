package co.com.siigo.models.web;

import lombok.Data;

@Data
public class WebClient {

    String clientType;
    String idType;
    String id;
    String name;
    String lastName;

    String city;
    String contactLastName;
    String contactMail;
    String contactRol;
    String contactIndicator;
    String contactTel;
}
