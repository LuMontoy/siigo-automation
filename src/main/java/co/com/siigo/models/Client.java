package co.com.siigo.models;

import lombok.Data;

@Data
public class Client {

    String clientType;
    String idType;
    String id;
    String name;
    String lastName;

    String contactName;
    String contactLastName;
    String contactMail;
    String contactRol;
    String contactIndicator;
    String contactTel;
}
